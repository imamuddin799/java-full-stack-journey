package com.spring_class.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee = (Employee) context.getBean("employee");
		
		employee.employeeDetails();
	}
}