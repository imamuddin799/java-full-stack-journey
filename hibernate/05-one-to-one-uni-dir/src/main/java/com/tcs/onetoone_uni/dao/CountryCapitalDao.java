package com.tcs.onetoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tcs.onetoone_uni.dto.Capital;
import com.tcs.onetoone_uni.dto.Country;

public class CountryCapitalDao {

	public void saveCountry(Country country) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(country);
		transaction.commit();
		System.out.println("Country saved successfully");
	}
	
	public void saveOnlyCapital(Capital capital) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(capital);
		transaction.commit();
		System.out.println("Capital saved successfully");
	}
	
	
//	If we will execute this method then it will work same like saveCountry() method. So, this method this not required.
	
//	public void saveOnlyCountry(Country country) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		transaction.begin();
//		manager.persist(country);
//		transaction.commit();
//		System.out.println("Only Country saved successfully");
//	}
	
	public void updateCountryById(Country country) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Country countryFromDatabase = manager.find(Country.class, country.getCid());
		if(countryFromDatabase != null) {
			transaction.begin();
			manager.merge(country);
			transaction.commit();
			System.out.println("Country updated successfully");
		}
		else {
			System.out.println("There is no country id "+ country.getCid());
		}
	}
	
	public void updateCapitalById(Capital capital) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Capital capitalFromDatabase = manager.find(Capital.class, capital.getId());
		if(capitalFromDatabase != null) {
			transaction.begin();
			manager.merge(capital);
			transaction.commit();
			System.out.println("Capital updated successfully");
		}
		else {
			System.out.println("There is no capital id "+ capital.getId());
		}
	}
	
	public Country findCountryById(int cid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		return manager.find(Country.class, cid);
	}
	
	public Capital findCapitalById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		return manager.find(Capital.class, id);
	}
	
	public void deleteCountryById(int cid) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Country country = manager.find(Country.class, cid);
		if(country != null) {
			transaction.begin();
			manager.remove(country);
			transaction.commit();
		}
		else {
			System.out.println("The given country id "+ cid +" is not present");
		}
	}
	
//	If we will execute this method it will give an error (Cannot delete or update a parent row: a foreign key constraint fails (`onetoone_uni`.`country`, CONSTRAINT `FKq3g3cae5vuqhcib862mx6o9oh` FOREIGN KEY (`capital_id`) REFERENCES `capital` (`id`)))
	
//	public void deleteCapitalById(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		
//		Capital capital = manager.find(Capital.class, id);
//		if(capital != null) {
//			transaction.begin();
//			manager.remove(capital);
//			transaction.commit();
//		}
//		else {
//			System.out.println("The given country id "+ id +" is not present");
//		}
//	}
	
	public void displayAllCountries() {
		System.err.println("Displaying all Conntries");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query allCountries = manager.createQuery("select country from Country country");
		List<Country> countries = allCountries.getResultList();
		System.err.println("Countries Found:"+ countries.size());
		for(Country country : countries) {
			System.out.println(country);
		}
	}
	
	public void displayAllCapitals() {
		System.err.println("Displaying all Capitals");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		
		Query allCapitals = manager.createQuery("select capital from Capital capital");
		List<Capital> capitals = allCapitals.getResultList();
		System.err.println("Capitals Found:"+ capitals.size());
		for(Capital capital : capitals) {
			System.out.println(capital);
		}
	}
}