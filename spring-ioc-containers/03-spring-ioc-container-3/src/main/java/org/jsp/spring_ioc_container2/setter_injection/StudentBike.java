package org.jsp.spring_ioc_container2.setter_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentBike {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("student2.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student.getName());
		System.out.println(student.getAddress());
		System.out.println(student.getMarks());
		System.out.println(student.getBike().getBrand());
		System.out.println(student.getBike().getColor());
		System.out.println(student.getBike().getCost());
	}
}