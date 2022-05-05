package com.davidgaytan.lil.learningspring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "sprint1")
public class Orders {
	
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Date date;
	private String cust_email;
	private double cust_location;
	private String product_id;
	private double orderquantity;
	
	
	public Orders(String product_id, double orderId, Date date, String cust_email, double cust_location,
			double orderquantity) {
		super();
		this.product_id = product_id;
		this.date = date;
		this.cust_email = cust_email;
		this.cust_location = cust_location;
		this.orderquantity = orderquantity;
	}


	public String getOrderproductId() {
		return product_id;
	}


	public void setproduct_id(String product_id) {
		this.product_id = product_id;
	}



	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCust_email() {
		return cust_email;
	}


	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}


	public double getCust_location() {
		return cust_location;
	}


	public void setCust_location(double cust_location) {
		this.cust_location = cust_location;
	}


	public double getOrderquantity() {
		return orderquantity;
	}


	public void setOrderquantity(double orderquantity) {
		this.orderquantity = orderquantity;
	}


	@Override
	public String toString() {
		return "Orders [product_id=" + product_id  + ", date=" + date + ", cust_email="
				+ cust_email + ", cust_location=" + cust_location + ", orderquantity=" + orderquantity + "]";
	}



}
