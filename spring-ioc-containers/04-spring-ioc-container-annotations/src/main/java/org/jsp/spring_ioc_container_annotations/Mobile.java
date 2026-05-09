package org.jsp.spring_ioc_container_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

	@Value( value = "Black")
	String color;
	
	@Value( value = "999.0")
	double price;
	
	@Value (value = "mi")
	String brand;
	
	public void mobileDetails() {
		System.out.println(color);
		System.out.println(price);
		System.out.println(brand);
	}
}