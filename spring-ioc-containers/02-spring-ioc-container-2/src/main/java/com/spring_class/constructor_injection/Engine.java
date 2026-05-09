package com.spring_class.constructor_injection;

public class Engine {

	private int engineNumber;
	private String brand;
	private double cost;
	
	public Engine(int engineNumber, String brand, double cost) {
		this.engineNumber = engineNumber;
		this.brand = brand;
		this.cost = cost;
	}
	
	public void engineDetails() {
		System.out.println("Engine Number : "+ engineNumber);
		System.out.println("Engine Brand : "+ brand);
		System.out.println("Engine Cost : "+ cost);
	}
}