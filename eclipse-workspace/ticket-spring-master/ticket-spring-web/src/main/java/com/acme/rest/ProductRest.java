package com.acme.rest;

import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.acme.jaxb.ProductJaxb;
import com.acme.jaxb.ProductsJaxb;
import com.acme.model.ProductManager;

@RestController
@RequestMapping("/rest/product")
public class ProductRest {
	private final ProductManager pm;
	
	@Inject
	public ProductRest(ProductManager pm) {
		this.pm = pm;
	}

	@GetMapping(produces={"application/xml","application/json"})
	public ProductsJaxb getAll(
			@RequestParam(value="from",defaultValue="0") int from, 
  		    @RequestParam(value="max",defaultValue="999") int max) {
		ProductsJaxb r = new ProductsJaxb();
		r.setProducts(pm.getAllProducts().stream()
							      .skip(from)
							      .limit(max)
								  .map(ProductJaxb::fromProduct)
								  .collect(Collectors.toList()));
		return r;
	}
	
	@GetMapping(produces={"application/xml","application/json"},
				path="{id}")
	public ResponseEntity<ProductJaxb> getProduct (@PathVariable("id") String id) {

		return ResponseEntity.of(pm.findProductById(id).map(ProductJaxb::fromProduct));
	}
	
	@PutMapping(consumes={"application/xml","application/json"},
			    path="new")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addProduct (@RequestBody ProductJaxb product) {
		pm.addProduct(product.toProduct());
	// it could be nice to return the key of the new product (or the product with the key)
	}	
}
