package org.jsp.spring_ioc_container2.constructor_injection;

public class Pen {

	private String color;
	private double cost;
	private String type;
	
	public Pen(String color, double cost, String type) {
		this.color = color;
		this.cost = cost;
		this.type = type;
	}

	public String toString() {
		return "[color = " + color + ", cost = " + cost + ", type = " + type + "]";
	}
}