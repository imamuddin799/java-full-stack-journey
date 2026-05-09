package org.jsp.onetoone_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoone_bi.dto.Heart;
import org.jsp.onetoone_bi.dto.Person;

public class PersonHeartDao {

	public void savePerson(Person person) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(person);
		transaction.commit();
		System.out.println("Person saved successfully");
	}
	
	public void saveHeart(Heart	heart) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(heart);
		transaction.commit();
		System.out.println("Heart saved successfully");
	}
	
	public void updatePersonById(Person person) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Person personFromDatabase = manager.find(Person.class, person.getId());
		
		if(personFromDatabase != null) {
			transaction.begin();
			manager.merge(person);
			transaction.commit();
			System.out.println("Person updated successfully");
		}
		else {
			System.out.println("The person does not exists");
		}
	}
	
	public void updateHeartById(Heart heart) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Heart heartFromDatabase = manager.find(Heart.class, heart.getId());
		
		if(heartFromDatabase != null) {
			transaction.begin();
			manager.merge(heart);
			transaction.commit();
			System.out.println("Heart updated successfully");
		}
		else {
			System.out.println("The heart does not exists");
		}
	}
	
	public void findPersonById(int personId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Person person = manager.find(Person.class, personId);
		if(person != null) {
			System.out.println(person);
		}
		else {
			System.out.println("There is no person found with id "+ personId);
		}
	}
	
	public void findHeartById(int heartId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Heart heart = manager.find(Heart.class, heartId);
		if(heart != null) {
			System.out.println(heart);
		}
		else {
			System.out.println("There is no heart found with id "+ heartId);
		}
	}
	
	public void deletePersonById(int personId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Person person = manager.find(Person.class, personId);
		if(person != null) {
			transaction.begin();
			manager.remove(person);
			transaction.commit();
			System.out.println("Person removed successfully with id "+ personId);
		}
		else {
			System.out.println("There is no person found with id "+ personId);
		}
	}
	
	public void deleteHeartById(int heartId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Heart heart = manager.find(Heart.class, heartId);
		if(heart != null) {
			transaction.begin();
			manager.remove(heart);
			transaction.commit();
			System.out.println("Person removed successfully with id "+ heartId);
		}
		else {
			System.out.println("There is no person found with id "+ heartId);
		}
	}
	
	public void fetchAllPersons() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select person from Person person");
		List<Person> persons = query.getResultList();
		if(!persons.isEmpty()) {
			for(Person person : persons) {
				System.out.println(person);
			}
		}
		else {
			System.out.println("There is no person. Please add first and then you will get");
		}
	}
	
	public void fetchAllHearts() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select heart from Heart heart");
		List<Heart> hearts = query.getResultList();
		
		if(!hearts.isEmpty()) {
			for(Heart heart : hearts) {
				System.out.println(heart);
			}
		}
		else {
			System.out.println("There is no heart found. Please first add and then you will get");
		}
	}
}