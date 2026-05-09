package org.jsp.onetoone_bi_assignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetoone_bi_assignment.dto.Car;
import org.jsp.onetoone_bi_assignment.dto.Engine;

public class CarEngineDao {

	public void saveCar(Car car) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(car);
		transaction.commit();
		System.out.println("Car saved successfully");
	}
	
	public void saveEngine(Engine engine) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(engine);
		transaction.commit();
		System.out.println("Engin saved successfully");
	}
	
	public void findCarById(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		
		Car car = manager.find(Car.class, id);
		if(car != null) {
			System.out.println(car);
		}
		else {
			System.out.println("Car not found..!!");
		}
	}
	
	public void findEngineById(int engineId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		
		Engine engine = manager.find(Engine.class, engineId);
		if(engine != null) {
			System.out.println(engine);
		}
		else {
			System.out.println("Engine not found..!!");
		}
	}
	
	public void fetchAllCars() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select car from Car car");
		List<Car> cars = query.getResultList();
		
		if(!cars.isEmpty()) {
			for(Car car : cars) {
				System.out.println(car);
			}
		}
		else {
			System.out.println("There is no Car available");
		}
	}
	
	public void fetchAllEngines() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select engine from Engine engine");
		List<Engine> engines = query.getResultList();
		
		if(!engines.isEmpty()) {
			for(Engine engine : engines) {
				System.out.println(engine);
			}
		}
		else {
			System.out.println("There is no Engine available");
		}
	}
	
	public void updateCarById(Car car) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Car carFromDatabase = manager.find(Car.class, car.getCarId());
		if(carFromDatabase != null) {
			transaction.begin();
			manager.merge(car);
			transaction.commit();
			System.out.println("Car updated successfully");
		}
		else {
			System.out.println("The provided id "+ car.getCarId() +" not found");
		}
	}
	
	public void updateEngineById(Engine engine) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Engine engineFromDatabase = manager.find(Engine.class, engine.getId());
		if(engineFromDatabase != null) {
			transaction.begin();
			manager.merge(engine);
			transaction.commit();
			System.out.println("Engine updated successfully");
		}
		else {
			System.out.println("The proveded id "+ engine.getId() +" not found");
		}
	}
	
	public void deleteCarById(int carId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Car car = manager.find(Car.class, carId);
		if(car != null) {
			transaction.begin();
			manager.remove(car);
			transaction.commit();
			System.out.println("Car removed successfully");
		}
		else {
			System.out.println("There is no car found with id "+ carId);
		}
	}
	
	public void deleteEngineById(int engineId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imam");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Engine engine = manager.find(Engine.class, engineId);
		if(engine != null) {
			transaction.begin();
			manager.remove(engine);
			transaction.commit();
			System.out.println("Engine removed successfully");
		}
		else {
			System.out.println("There is no engine found with id "+ engineId);
		}
	}
}