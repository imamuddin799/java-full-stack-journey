package org.jsp.spring_ioc_container2.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDriver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("person.xml");
		Person person = (Person) context.getBean("myperson");
		person.personDetails();
	}
}