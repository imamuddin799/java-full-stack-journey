package com.spring_class;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMarks {

	public static void main(String[] args) { // JEE Container
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("student.xml");
		Student student= (Student) applicationContext.getBean("stud");
		student.percentage(25, 30);
		System.out.println("Total Sum marks: "+ student.marks(50, 50));
		
		// Core Container
		
//		Difference between bean factory and application context
	}
}
