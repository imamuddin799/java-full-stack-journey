package com.spring_class.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PenDriver {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("pen.xml");
		Pen pen = (Pen) context.getBean("pen");
		pen.penDetails();
	}
}