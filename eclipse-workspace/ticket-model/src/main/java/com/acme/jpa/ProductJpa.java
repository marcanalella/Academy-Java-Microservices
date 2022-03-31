package com.acme.jpa;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.acme.model.Product;

@Entity
@Table(name="PRODUCT")
public class ProductJpa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME", length=32)
	private String name;
	
	@Column(name="PRICE")
	private double price;

	@ManyToMany // no cascade PERSIST, dao decides per single case
	private List<ProductTypeJpa> types;
	
	public Product toProduct() {
		return new Product(id != null ? id.toString() : null, 
						   name, 
						   price,
						   types.stream()
						   		.map(ProductTypeJpa::toProductType)
						   	    .collect(Collectors.toList()));
	}
	
	public static ProductJpa fromProduct(Product product) {
		ProductJpa pj = new ProductJpa();
		// no id: auto-generation
		pj.setName(product.getName());
		pj.setPrice(product.getPrice());
		pj.setTypes(product.getTypes().stream()
									  .map(ProductTypeJpa::fromProductType)
									  .collect(Collectors.toList()));
		return pj;
	}
	
	public Integer getId() {
		return id;
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

	public List<ProductTypeJpa> getTypes() {
		return types;
	}

	public void setTypes(List<ProductTypeJpa> types) {
		this.types = types;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, types);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProductJpa))
			return false;
		ProductJpa other = (ProductJpa) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(types, other.types);
	}

	@Override
	public String toString() {
		return "ProductJpa [id=" + id + ", name=" + name + ", price=" + price + ", types=" + types + "]";
	}
}
