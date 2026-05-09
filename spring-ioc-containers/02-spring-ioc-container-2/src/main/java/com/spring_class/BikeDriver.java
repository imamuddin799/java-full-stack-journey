package com.spring_class;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BikeDriver {

	public static void main(String[] args) { 
		// JEE containner
//		ApplicationContext context = new ClassPathXmlApplicationContext("bike.xml");
//		Bike bike = (Bike) context.getBean("mybike1");
//		bike.start();
//		bike.stop();
		
		// Core container
//		Resource resource=new ClassPathResource("bike.xml");
//		BeanFactory factory=new XmlBeanFactory(resource);
//		Bike bike = (Bike) factory.getBean("mybike1");
//		bike.start();
//		bike.stop();
		

	}
}
