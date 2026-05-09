package org.jsp.spring_ioc_container2.constructor_injection;

public class Bag {

	String color;
	double cost;
	String capacity;
	
	public Bag(String color, double cost, String capacity) {
		this.color = color;
		this.cost = cost;
		this.capacity = capacity;
	}
	
	public void bagDetails() {
		System.out.println("Color : "+ color +", Cost : "+ cost +", Capacity : "+ capacity);
	}
}