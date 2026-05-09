package org.jsp.spring_ioc_container_no_xml.constructor_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Wheel {

	String brand;
	double price;
	String type;
	
	public Wheel(@Value (value = "Ceat") String brand, @Value (value = "15000") double price, @Value (value = "Tubeless") String type) {
		this.brand = brand;
		this.price = price;
		this.type = type;
	}
}