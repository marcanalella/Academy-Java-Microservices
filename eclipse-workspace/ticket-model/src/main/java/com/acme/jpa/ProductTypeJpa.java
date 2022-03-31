package com.acme.jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.acme.model.ProductType;

@Entity
@Table(name="PRODUCT_TYPE")
public class ProductTypeJpa {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="NAME", length=10)
	private String name;
	
	public ProductType toProductType() {
		return ProductType.valueOf(name);
	}
	
	public static ProductTypeJpa fromProductType (ProductType pt) {
		ProductTypeJpa ptj = new ProductTypeJpa();
		ptj.setName(pt.name());
		return ptj;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProductTypeJpa))
			return false;
		ProductTypeJpa other = (ProductTypeJpa) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ProductTypeJpa [id=" + id + ", name=" + name + "]";
	}
}
