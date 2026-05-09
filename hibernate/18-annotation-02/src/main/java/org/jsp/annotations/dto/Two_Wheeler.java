package org.jsp.annotations.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bike")
public class Two_Wheeler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "sr_no")
	private int bid;
	
	@Column(name = "brand")
	private String name;
	
	@Column (nullable = false)
	private String color;
	
	@Column (name = "price")
	private double cost;
	
	@Column(name = "emailId", unique = true)
	private String email;
	
	@NotNull
	private long phone;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Two_Wheeler [bid = " + bid + ", name = " + name + ", color = " + color + ", cost = " + cost
				+ ", email = " + email + ", phone = " + phone + "]";
	}
}