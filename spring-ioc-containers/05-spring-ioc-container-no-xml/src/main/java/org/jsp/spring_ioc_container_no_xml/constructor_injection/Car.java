package org.jsp.spring_ioc_container_no_xml.constructor_injection;

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
	
	@Autowired
	public Car(@Value (value = "Audi") String brand, @Value (value = "White") String color, @Value (value = "9000000") double cost, Engine engine, Wheel wheel) {
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
		System.out.println(engine.brand);
		System.out.println(engine.cc);
		System.out.println(engine.cost);
		System.out.println(wheel.brand);
		System.out.println(wheel.price);
		System.out.println(wheel.type);
	}
}