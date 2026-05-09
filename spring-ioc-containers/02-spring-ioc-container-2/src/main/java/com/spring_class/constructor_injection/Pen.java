package com.spring_class.constructor_injection;

public class Pen {

	private String brand;
	private String color;
	private double cost;
	
	public Pen(String brand, String color, double cost) {
		this.brand = brand;
		this.color = color;
		this.cost = cost;
	}
	
	public void penDetails() {
		System.out.println("Brand : "+ brand);
		System.out.println("Color : "+ color);
		System.out.println("Cost : "+ cost);
	}
}