package com.spring_class.setter_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MouseDriver {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("mouse.xml");
		
		Mouse mouse = (Mouse) context.getBean("mouse");
		System.out.println(mouse.getBrand());
		System.out.println(mouse.getColor());
		System.out.println(mouse.getCost());
		System.out.println(mouse.getType());
	}
}