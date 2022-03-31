package com.acme.ws;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.jws.WebService;

import com.acme.jaxb.ProductJaxb;
import com.acme.model.ProductManager;

@WebService(name="ProductManager", 
		    serviceName="TicketWeb",
		    targetNamespace="http://acme.com/ticketweb/v1")
public class ProductManagerPort {
	@Inject
	private ProductManager pm;

	public List<ProductJaxb> getAllProducts() {
		return pm.getAllProducts().stream()
								  .map(ProductJaxb::fromProduct)
								  .collect(Collectors.toList());
	}

	public void addProduct(ProductJaxb product) {
		pm.addProduct(product.toProduct());
		
	}

	public ProductJaxb findProductById(String id) {
		return pm.findProductById(id).map(ProductJaxb::fromProduct)
									 .orElse(null);
	}

}
