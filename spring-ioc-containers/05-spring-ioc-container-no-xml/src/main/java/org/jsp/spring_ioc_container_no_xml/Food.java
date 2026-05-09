package org.jsp.spring_ioc_container_no_xml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Food {

	@Value(value = "North Indian")
	String type;
	
	@Value(value = "200")
	double cost;
	
	@Value(value = "500g")
	String quantity;
	
	@Value(value = "Biryani")
	String name;
	
	public void foodDetails() {
		System.out.println(name);
		System.out.println(cost);
		System.out.println(quantity);
		System.out.println(type);
	}
}