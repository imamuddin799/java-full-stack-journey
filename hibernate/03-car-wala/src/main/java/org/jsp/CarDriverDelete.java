package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarDriverDelete {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("imam");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = em.find(Car.class, 101);
		
		if(c != null) {
			et.begin();
			em.remove(c);
			et.commit();
		}
		else {
			System.out.println("The id is not present");
		}
	}
}