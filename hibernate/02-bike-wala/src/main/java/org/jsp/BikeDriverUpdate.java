package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BikeDriverUpdate {

	public static void main(String[] args) {
		Bike b = new Bike();
		b.setBid(107);
		b.setName("TVS");
		b.setColor("Grey");
		b.setPrice(205000);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//update
		et.begin();
		em.merge(b);
		et.commit();
	}
}