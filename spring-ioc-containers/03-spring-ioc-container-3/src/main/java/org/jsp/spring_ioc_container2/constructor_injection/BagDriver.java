package org.jsp.spring_ioc_container2.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BagDriver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bag.xml");
		Bag bag = (Bag) context.getBean("mybag");
		bag.bagDetails();
	}
}