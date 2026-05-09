package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarDriver {

	public static void main(String[] args) {
		
		Car c = new Car();
		c.setId(101);
		c.setBrand("BMW");
		c.setColor("Black");
		c.setPrice(4000000.0);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("imam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
	}
}