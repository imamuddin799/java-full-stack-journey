package org.jsp.spring_ioc_container2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BatDriver {

	public static void main(String[] args) {
		
//		j2ee-container

//		ApplicationContext context = new ClassPathXmlApplicationContext("bat.xml");
//		Bat bat = (Bat) context.getBean("mybat");
//		bat.batShot();
		
//		core-container
		Resource resource = new ClassPathResource("bat.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Bat bat = (Bat) factory.getBean("mybat");
		bat.batShot();
	}
}