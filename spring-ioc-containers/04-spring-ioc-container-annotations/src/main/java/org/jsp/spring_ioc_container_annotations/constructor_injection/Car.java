package org.jsp.spring_ioc_container_annotations.constructor_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	String brand;
	String color;
	double cost;
	Engine engine;
	Wheel wheel;
//	public Car(@Value (value = "BMW") String brand, @Value (value = "Red") String color, @Value (value = "300000") double cost, @Autowired Engine engine, @Autowired Wheel wheel) {
//		this.brand = brand;
//		this.color = color;
//		this.cost = cost;
//		this.engine = engine;
//		this.wheel = wheel;
//	}
	
	@Autowired
	public Car(@Value (value = "BMW") String brand, @Value (value = "Red") String color, @Value (value = "300000") double cost, Engine engine, Wheel wheel) {
		this.brand = brand;
		this.color = color;
		this.cost = cost;
		this.engine = engine;
		this.wheel = wheel;
	}
	
	public void carDetails() {
		System.out.println(brand);
		System.out.println(color);
		System.out.println(cost);
		engine.engineDetails();
		wheel.wheelDetails();
	}
}