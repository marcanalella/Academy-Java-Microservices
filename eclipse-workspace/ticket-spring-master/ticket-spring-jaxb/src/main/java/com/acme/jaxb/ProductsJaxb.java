package com.acme.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
public class ProductsJaxb {
	private List<ProductJaxb> products;

	@XmlElement(name="product")
	public List<ProductJaxb> getProducts() {
		return products;
	}

	public void setProducts(List<ProductJaxb> products) {
		this.products = products;
	}
}
