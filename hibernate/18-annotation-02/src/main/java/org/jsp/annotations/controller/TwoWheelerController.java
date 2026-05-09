package org.jsp.annotations.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.annotations.dto.Two_Wheeler;

public class TwoWheelerController {

	public static void main(String[] args) {
		
		Two_Wheeler two_Wheeler = new Two_Wheeler();
		two_Wheeler.setName("Splendor");
		two_Wheeler.setColor("Black");
		two_Wheeler.setCost(97000.00);
		two_Wheeler.setEmail("bikewala@gmail.com");
		two_Wheeler.setPhone(9876543210L);
		
//		this will not be executed color cannot be null
		Two_Wheeler two_Wheeler1 = new Two_Wheeler();
		two_Wheeler1.setName("Splendor");
		two_Wheeler1.setColor(null);
		two_Wheeler1.setCost(97000.00);
		two_Wheeler1.setEmail("bikewala@gmail1.com");
		two_Wheeler1.setPhone(9876543210L);
		
//		this will not be executed email cannot be duplicate
		Two_Wheeler two_Wheeler2 = new Two_Wheeler();
		two_Wheeler2.setName("Splendor");
		two_Wheeler2.setColor("Blue");
		two_Wheeler2.setCost(97000.00);
		two_Wheeler2.setEmail("bikewala@gmail.com");
		two_Wheeler2.setPhone(9876543210L);
		
//		I don't know why it is accepting null phone
		Two_Wheeler two_Wheeler3 = new Two_Wheeler();
		two_Wheeler3.setName("Splendor");
		two_Wheeler3.setColor("Red");
		two_Wheeler3.setCost(97000.00);
		two_Wheeler3.setEmail("bikewala@gmail3.com");
//		two_Wheeler3.setPhone(9876543210L);  // not sending explicitly by commenting it
		
		Two_Wheeler two_Wheeler4 = new Two_Wheeler();
		two_Wheeler4.setName("Splendor");
		two_Wheeler4.setColor("Black");
		two_Wheeler4.setCost(97000.00);
		two_Wheeler4.setEmail("bikewala@gmail4.com");
		two_Wheeler4.setPhone(9876543210L);
		
		Two_Wheeler two_Wheeler5 = new Two_Wheeler();
		two_Wheeler5.setName("Splendor");
		two_Wheeler5.setColor("Black");
		two_Wheeler5.setCost(97000.00);
		two_Wheeler5.setEmail("bikewala@gmail5.com");
		two_Wheeler5.setPhone(9876543210L);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(two_Wheeler5);
		transaction.commit();
	}
}