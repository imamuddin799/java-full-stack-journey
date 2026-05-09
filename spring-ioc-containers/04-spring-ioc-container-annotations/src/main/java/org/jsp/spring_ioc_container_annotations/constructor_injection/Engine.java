package org.jsp.spring_ioc_container_annotations.constructor_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	String brand;
	int cc;
	double cost;
	public Engine(@Value(value = "Hero") String brand, @Value(value = "200") int cc, @Value(value = "60000") double cost) {
		this.brand = brand;
		this.cc = cc;
		this.cost = cost;
	}
	
	public void engineDetails() {
		System.out.println(brand);
		System.out.println(cc);
		System.out.println(cost);
	}
}