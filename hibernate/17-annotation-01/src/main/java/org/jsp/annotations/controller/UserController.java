package org.jsp.annotations.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.annotations.dto.Users;

public class UserController {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Users users = new Users();
		users.setUname("Kuldip");
		users.setAddress("Hyd");
		users.setEmail("kuldeep4@gmail.com");
		users.setMno(9876543210L);
		
		transaction.begin();
		manager.persist(users);
		transaction.commit();
	}
}