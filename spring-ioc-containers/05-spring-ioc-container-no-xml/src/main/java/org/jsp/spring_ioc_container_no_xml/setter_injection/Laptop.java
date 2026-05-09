package org.jsp.spring_ioc_container_no_xml.setter_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

	String brand;
	String color;
	double cost;
	
	public String getBrand() {
		return brand;
	}
	
	@Value (value = "Asus")
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	
	@Value (value = "Silver")
	public void setColor(String color) {
		this.color = color;
	}
	public double getCost() {
		return cost;
	}
	
	@Value (value = "62000.00")
	public void setCost(double cost) {
		this.cost = cost;
	}
}