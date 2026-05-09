package com.jsp.caching2.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.caching2.dto.Student;

public class CachingController {

	public static void main(String[] args) {
//		Student student = new Student();
//		student.setId(102);
//		student.setName("Dimple");
//		student.setMarks(80);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
//		transaction.begin();
//		manager.persist(student);
//		transaction.commit();
		
		Student student = manager.find(Student.class, 101);
		Student student1 = manager.find(Student.class, 102);
		
		System.out.println(student);
		System.out.println(student1);
		
		Student student2 = manager.find(Student.class, 101);
		Student student3 = manager.find(Student.class, 102);
		
		System.out.println(student2);
		System.out.println(student3);
		
		Student student4 = manager.find(Student.class, 101);
		Student student5 = manager.find(Student.class, 102);
		
		System.out.println(student4);
		System.out.println(student5);
		
		Student student6 = manager.find(Student.class, 101);
		Student student7 = manager.find(Student.class, 102);
		
		System.out.println(student6);
		System.out.println(student7);
	}
}