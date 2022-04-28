package com.example.CS3250Project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	@Column(name = "Wholesale")
	private Double wholesale;
	
	@Column(name = "Sale_Price")
	private Double saleprice;
	
	@Column(name = "Supplier_ID")
	private long supplierId;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getWholesale() {
		return wholesale;
	}
	public void setWholesale(Double wholesale) {
		this.wholesale = wholesale;
	}
	
	public Double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}
	
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	
}
