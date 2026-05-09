package org.jsp.spring_ioc_container_no_xml.constructor_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {

	String brand;
	int cc;
	double cost;
	
	public Engine(@Value (value = "Toyota") String brand, @Value (value = "400") int cc, @Value (value = "400000") double cost) {
		this.brand = brand;
		this.cc = cc;
		this.cost = cost;
	}
}