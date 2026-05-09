package org.jsp;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllRecords {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("imam");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Car c");
		List<Car> c = q.getResultList();
		
		for(Car car : c) {
			System.out.println(car);
		}
		
		ListIterator<Car> listItr = c.listIterator();
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		
		Query q1 = em.createQuery("select c from Car c where c.id = ?1");
		q1.setParameter(1, 102);
		Car c1 = (Car) q1.getSingleResult();
		
		System.out.println(c1);
		
		q1.setParameter(1, 101);
		
		Car c2 = (Car) q1.getSingleResult();
		System.out.println(c2);
	}
}