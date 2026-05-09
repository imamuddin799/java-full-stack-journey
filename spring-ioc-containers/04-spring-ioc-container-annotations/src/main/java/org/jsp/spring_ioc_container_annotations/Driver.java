package org.jsp.spring_ioc_container_annotations;

import org.jsp.animal.AnimalSound;
import org.jsp.spring_ioc_container_annotations.constructor_injection.Car;
import org.jsp.spring_ioc_container_annotations.constructor_injection.Laptop;
import org.jsp.spring_ioc_container_annotations.setter_injection.Movie;
import org.jsp.spring_ioc_container_annotations.setter_injection.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myspringconfig.xml");
		Mobile mobile = (Mobile) context.getBean("mobile");
		mobile.mobileDetails();
		
		Pen pen = (Pen) context.getBean("pen");
		pen.penDetails();
		
		Writer writer = (Writer) context.getBean("writer");
		writer.writerDetails();
		
		Laptop laptop = (Laptop) context.getBean("laptop");
//		Bag laptop2 = context.getBean(Bag.class, "bag");
		Laptop laptop2 = context.getBean(Laptop.class, "mylaptop");
		laptop.laptopDetails();
		
		Car car = context.getBean(Car.class, "mycar");
		car.carDetails();
		
		System.out.println("<=============================>\n\n");
		
		Movie movie = context.getBean(Movie.class, "movie");
		System.out.println(movie.getName());
		System.out.println(movie.getPublishDate());
		System.out.println(movie.getActorName());
		
		System.out.println("<=============================>\n\n");
		
		Student student = context.getBean(Student.class, "student");
		System.out.println(student.getName());
		System.out.println(student.getAddress());
		System.out.println(student.getPhone());
		System.out.println(student.getBag().getBrand());
		System.out.println(student.getBag().getColor());
		System.out.println(student.getBag().getCost());
		

		System.out.println("<=============================>\n\n");
		
//		Animal animal = context.getBean(Lion.class, "lion");
		AnimalSound sound = context.getBean(AnimalSound.class, "animalSound");
		sound.doSound();
		
		System.out.println("<=============================>\n\n");
		
		ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) context;
		applicationContext.close();
	}
}