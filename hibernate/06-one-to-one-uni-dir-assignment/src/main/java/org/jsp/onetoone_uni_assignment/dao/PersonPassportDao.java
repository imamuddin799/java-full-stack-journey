package org.jsp.onetoone_uni_assignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoone_uni_assignment.dto.Passport;
import org.jsp.onetoone_uni_assignment.dto.Person;

public class PersonPassportDao {

	public void savePerson(Person person) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(person);
		transaction.commit();
		System.out.println("Person saved successfully");
	}
	
	public void savePassport(Passport passport) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(passport);
		transaction.commit();
		System.out.println("Passport saved successfully");
	}
	
	public void findPersonById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Person person = manager.find(Person.class, id);
		if(person != null) {
			System.out.println(person);
		}
		else {
			System.out.println("Person does not found");
		}
	}
	
	public void findPassportById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Passport passport = manager.find(Passport.class, id);
		if(passport != null) {
			System.out.println(passport);
		}
		else {
			System.out.println("Passport does not found");
		}
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
			System.out.println("There is no person with id "+ person.getId());
		}
	}
	
	public void updatePassportById(Passport passport) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Passport passportFromDatabase = manager.find(Passport.class, passport.getId());
		if(passportFromDatabase != null) {
			transaction.begin();
			manager.merge(passport);
			transaction.commit();
			System.out.println("Passport updated successfully");
		}
		else {
			System.out.println("There is no passport with id "+ passport.getId());
		}
	}
	
	public void deletePersonById(Person person) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Person personFromDatabase = manager.find(Person.class, person.getId());
		if(personFromDatabase != null) {
			transaction.begin();
			manager.remove(personFromDatabase);
			transaction.commit();
			System.out.println("Person deleted successfully");
		}
		else {
			System.out.println("There no person found with id "+ person.getId());
		}
	}
	
	public void findAllPersons() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query allPersons = manager.createQuery("select person from Person person");
		List<Person> persons = allPersons.getResultList();
		if(persons != null) {
			for(Person person : persons) {
				System.out.println(person);
			}
		}
		else {
			System.out.println("Person does not found");
		}
	}
	public void findAllPassports() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query allPasports = manager.createQuery("select passport from Passport passport");
		List<Passport> passports = allPasports.getResultList();
		if(passports != null) {
			for(Passport passport : passports) {
				System.out.println(passport);
			}
		}
		else {
			System.out.println("Passport does not found");
		}
	}
}