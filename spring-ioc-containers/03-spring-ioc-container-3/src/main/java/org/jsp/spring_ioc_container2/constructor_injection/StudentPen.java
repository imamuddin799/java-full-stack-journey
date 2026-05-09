package org.jsp.spring_ioc_container2.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentPen {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("student.xml");
		Student student = (Student) context.getBean("student");
		student.studentDetails();
	}
}