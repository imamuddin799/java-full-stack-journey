package org.jsp.spring_ioc_container2.setter_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PenDriver {

	public static void main(String[] args) {
		
		// ApplicationContext context = new ClassPathXmlApplicationContext("pen.xml");
		// Pen pen = (Pen) context.getBean("mypen");
		// System.out.println(pen.getBrand());
		// System.out.println(pen.getColor());
		// System.out.println(pen.getCost());

		// ClassPathXmlApplicationContext ref = (ClassPathXmlApplicationContext) context;
		// ref.close(); // close the context to release resources
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("pen.xml");
		Pen pen = (Pen) context.getBean("mypen");
		System.out.println(pen.getBrand());
		System.out.println(pen.getColor());
		System.out.println(pen.getCost());

		context.close(); // close the context to release resources
	}
}