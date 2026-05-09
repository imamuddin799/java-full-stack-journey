package org.jsp.spring_ioc_container2.constructor_injection;

public class Car {

	private String brand;
    private String model;
    private int year;
    private Engine engine; // Composition
    
	public Car(String brand, String model, int year, Engine engine) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.engine = engine;
	}
	
	public void carDetails() {
		System.out.println("Car [brand=" + brand + ", model=" + model + ", year=" + year + ", engine=" + engine.engineDetails() + "]");
	}
    
    
}