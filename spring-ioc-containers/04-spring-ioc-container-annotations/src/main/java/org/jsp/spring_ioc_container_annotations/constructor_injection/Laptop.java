package org.jsp.spring_ioc_container_annotations.constructor_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

	String brand;
	String color;
	double cost;
	public Laptop(@Value(value = "Dell") String brand, @Value(value = "Silver") String color,@Value(value = "99999.99") double cost) {
		this.brand = brand;
		this.color = color;
		this.cost = cost;
	}
	
	public void laptopDetails() {
		System.out.println(brand);
		System.out.println(color);
		System.out.println(cost);
	}
}