package org.jsp.spring_ioc_container_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pen {

	@Value (value = "Agni 4.0")
	String brand;
	
	@Value (value = "5.0")
	double cost;
	
	@Value (value = "Blue")
	String color;
	
	public void penDetails() {
		System.out.println(brand);
		System.out.println(cost);
		System.out.println(color);
	}
}