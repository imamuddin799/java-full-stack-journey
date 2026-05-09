package com.spring_class.constructor_injection;

public class Car {

	private String brand;
	private String color;
	private double cost;
	private Engine engine;
	
	public Car(String brand, String color, double cost, Engine engine) {
		this.brand = brand;
		this.color = color;
		this.cost = cost;
		this.engine = engine;
	}

	public void carDetials() {
		System.out.println("Brand : "+ brand);
		System.out.println("Color : "+ color);
		System.out.println("Cost : "+ cost);
		engine.engineDetails();
	}
}