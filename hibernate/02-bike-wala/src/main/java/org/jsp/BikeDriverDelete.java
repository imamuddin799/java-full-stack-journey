package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BikeDriverDelete {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Bike bike = em.find(Bike.class, 102);
		if(bike != null) {
			et.begin();
			em.remove(bike);
			et.commit();
		}
		else {
			System.out.println("The id does not exists");
		}
	}
}