package org.jsp.spring_ioc_container2.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaptopMouseDriver {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("laptop.xml");
		Laptop laptop = (Laptop) context.getBean("mylaptop");
		laptop.laptopDetails();
	}
}