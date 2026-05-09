package org.jsp.spring_ioc_container2.setter_injection;

public class Pen {

	private String color;
	private String brand;
	private double cost;

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void greet() {
		System.out.println("Hello User");
	}
	
	public void bye() {
		System.out.println("Bye bye User");
	}
}