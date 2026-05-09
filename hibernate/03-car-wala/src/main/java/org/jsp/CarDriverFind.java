package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarDriverFind {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("imam");
		EntityManager em = emf.createEntityManager();
		
		Car c = em.find(Car.class, 102);
		System.out.println(c);
		
		Car c2 = em.getReference(Car.class, 102);
		System.out.println(c2);
	}
}