package org.jsp.spring_ioc_container_annotations.constructor_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Wheel {

	String brand;
	double cost;
	String type;
	public Wheel(@Value(value = "MRF") String brand, @Value(value = "20000") double cost, @Value(value = "Tubeless") String type) {
		this.brand = brand;
		this.cost = cost;
		this.type = type;
	}
	
	public void wheelDetails() {
		System.out.println(brand);
		System.out.println(cost);
		System.out.println(type);
	}
}