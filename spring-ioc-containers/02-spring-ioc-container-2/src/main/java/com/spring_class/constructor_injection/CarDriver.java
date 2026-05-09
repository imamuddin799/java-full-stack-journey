package com.spring_class.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarDriver {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("car.xml");
		Car car = (Car) context.getBean("car");
		car.carDetials();
		
	}
}