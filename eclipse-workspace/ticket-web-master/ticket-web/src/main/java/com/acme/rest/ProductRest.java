package com.acme.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static javax.ws.rs.core.MediaType.*;

import com.acme.jaxb.ProductJaxb;
import com.acme.jaxb.ProductsJaxb;
import com.acme.model.Product;
import com.acme.model.ProductManager;

@Path("product")
public class ProductRest {
	@Inject
	private ProductManager pm;
	
	@GET
	@Produces({APPLICATION_JSON, APPLICATION_XML})
	public ProductsJaxb getAll(@QueryParam("from") @Min(0) int from, 
							   @QueryParam("max") @DefaultValue("20") @Min(0) int max) {
		ProductsJaxb r = new ProductsJaxb();
		r.setProducts(pm.getAllProducts().stream()
							      .skip(from)
							      .limit(max)
								  .map(ProductJaxb::fromProduct)
								  .collect(Collectors.toList()));
		return r;
	}
	
	@GET
	@Path("{id}")
	@Produces({APPLICATION_JSON, APPLICATION_XML})
	public Response getProduct (@PathParam("id") String id) {
//		Optional<Product> prod = pm.findProductById(id);
//		if (prod.isPresent()) {
//			return Response.ok(ProductJaxb.fromProduct(prod.get())).build();
//		} else {
//			return Response.status(Status.NOT_FOUND).build();
//		}
		
//		return pm.findProductById(id).map(p -> Response.ok(ProductJaxb.fromProduct(p)))
//									 .orElseGet(() -> Response.status(Status.NOT_FOUND))
//									 .build();
		
		return pm.findProductById(id).map(ProductJaxb::fromProduct)
								 	 .map(Response::ok)
								 	 .orElseGet(() -> Response.status(Status.NOT_FOUND))
								 	 // orElse(...) would be ok 
						 	 		 .build();
	}
	
	@PUT // Otherwise @POST without @Path would be probably fine
//	@Path("{id}") // would be fine e.g. with a client-generated UUID
	@Path("new") // would be nice a @GET @Path("new") returning the latest product addeds
	@Consumes({APPLICATION_JSON, APPLICATION_XML})
	public Response addProduct (ProductJaxb product) {
		pm.addProduct(product.toProduct());
	// it could be nice to return the key of the new product (or the product with the key)
		return Response.accepted().build();
	}
	
}
