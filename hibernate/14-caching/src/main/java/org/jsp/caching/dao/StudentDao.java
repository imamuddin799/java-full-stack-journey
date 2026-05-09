package org.jsp.caching.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.caching.dto.Student;

public class StudentDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void saveStudent(Student student) {
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		System.out.println("\nStudent saved...\n");
	}
	
	public void findStudentById(int sid) {
		Student student = manager.find(Student.class, sid);
		System.out.println(student);
	}
}