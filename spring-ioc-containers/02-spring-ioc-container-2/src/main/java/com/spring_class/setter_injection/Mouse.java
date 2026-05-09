package com.spring_class.setter_injection;

public class Mouse {

	private String brand;
	private String color;
	private String cost;
	private String type;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
//	@Override
//	public String toString() {
//		return "Mouse [brand=" + brand + ", color=" + color + ", cost=" + cost + ", type=" + type + "]";
//	}
}
