package org.jsp.compositkey.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.compositkey.dto.Amazon;

public class AmazonDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	public void saveAmazon(Amazon amazon) {
		transaction.begin();
		manager.persist(amazon);
		transaction.commit();
	}
	
	public void fetchAllAmazon(){
		Query query = manager.createQuery("select amazon from Amazon amazon");
		List<Amazon> amazons = query.getResultList();
		if(!amazons.isEmpty()) {
			for (Amazon amazon : amazons) {
				System.err.println(amazon);
			}
		}
		else {
			System.out.println("\nNo Amazon are there...\n");
		}
	}
}