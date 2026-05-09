package org.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BikeDriver {

	public static void main(String[] args) {
		
		Bike b = new Bike();
		b.setBid(102);
		b.setName("Hero");
		b.setColor("Black");
		b.setPrice(97000.0);
		
		Bike b1 = new Bike();
		b1.setBid(103);
		b1.setName("Pulser");
		b1.setColor("Red");
		b1.setPrice(125000.0);
		
		Bike b2 = new Bike();
		b2.setBid(104);
		b2.setName("Apache");
		b2.setColor("White");
		b2.setPrice(200000.0);
		
		Bike b3 = new Bike();
		b3.setBid(105);
		b3.setName("Passion");
		b3.setColor("Black");
		b3.setPrice(120000.0);
		
		Bike b4 = new Bike();
		b4.setBid(106);
		b4.setName("Himalayan");
		b4.setColor("Grey");
		b4.setPrice(400000.0);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//save
		et.begin();
		em.persist(b);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		et.commit();
	}
}