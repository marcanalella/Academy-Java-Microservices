package com.acme.jaxb;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.acme.model.Product;
import com.acme.model.ProductType;

@XmlRootElement(name="product")
//@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductJaxb {
	private String id;
	
	private String name;
	
	private double price;
	
	private List<String> types;
	
	public static ProductJaxb fromProduct (Product product) {
		ProductJaxb pj = new ProductJaxb();
		pj.setId(product.getId());
		pj.setName(product.getName());
		pj.setPrice(product.getPrice());
		pj.setTypes(product.getTypes().stream()
									  .map(ProductType::toString)
									  .collect(Collectors.toList()));		
		return pj;
	}
	
	public Product toProduct() {
		return new Product(id, name, price, types.stream()
										         .map(ProductType::valueOf)
										         .collect(Collectors.toList()));
	}

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlElementWrapper(name="types")
	@XmlElement(name="type")
	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}
}
