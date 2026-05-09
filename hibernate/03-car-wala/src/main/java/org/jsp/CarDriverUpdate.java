package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarDriverUpdate {

	public static void main(String[] args) {
		
		Car c = new Car();
		c.setId(102);
		c.setBrand("Volvo");
		c.setColor("Red");
		c.setPrice(5000000.0);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("imam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(c);
		et.commit();
	}
}