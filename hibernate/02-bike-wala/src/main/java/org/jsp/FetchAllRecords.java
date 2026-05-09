package org.jsp;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FetchAllRecords {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select b from Bike b");
		List<Bike> b = q.getResultList();
		
		for(Bike bike : b) {
			System.out.println(bike);
		}
		
		ListIterator<Bike> listItr = b.listIterator();
		
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		
		Query q1 = em.createQuery("select b from Bike b where b.bid = ?1");
		q1.setParameter(1, 102);
		Bike b1 = (Bike) q1.getSingleResult();
		
		if(b1 != null) {
			System.out.println(b1);
		}
	}
}