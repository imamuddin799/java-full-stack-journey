package org.jsp.spring_ioc_container_no_xml;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.spring_ioc_container_no_xml.constructor_injection.Car;
import org.jsp.spring_ioc_container_no_xml.inser_into_database.Bike;
import org.jsp.spring_ioc_container_no_xml.setter_injection.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Food food = applicationContext.getBean(Food.class, "food");
		food.foodDetails();
		
		Car car = applicationContext.getBean(Car.class, "car");
		car.carDetails();
		
		System.out.println("<=============================================================>\n\n");
		
		Student student = applicationContext.getBean(Student.class, "student");
		System.out.println(student.getName());
		System.out.println(student.getAddress());
		System.out.println(student.getPhone());
		System.out.println(student.getLaptop().getBrand());
		System.out.println(student.getLaptop().getColor());
		System.out.println(student.getLaptop().getCost());
		System.out.println(student.getBag().getBrand());
		System.out.println(student.getBag().getColor());
		System.out.println(student.getBag().getCost());
		
		System.out.println("<=============================================================>\n\n");
		
		Bike bike = applicationContext.getBean(Bike.class, "bike");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(bike);
		transaction.commit();
		System.out.println("Successful");
	}
}