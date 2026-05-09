package org.jsp.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.employee.dto.Employee;

public class EmployeeDao {

	public void saveEmployee(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("Employee saved successfully");
	}

	public void updateEmployee(Employee employee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee employeeFromDatabase = entityManager.find(Employee.class, employee.getEid());
		if (employeeFromDatabase != null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			System.out.println("Employee details updated successfully");
		} else {
			System.out.println("Employee is not present");
		}
	}

	public Employee findEmployeeById(int employeeId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager.find(Employee.class, employeeId);
	}

	public void deleteEmployeeById(int employeeId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			System.out.println("Employee Removed successfully");
		} else {
			System.out.println("Employee not found");
		}
	}
	
	public List<Employee> fetchAllEmployees(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select employee from Employee employee");
		List<Employee> employees = query.getResultList();
		return employees;
	}
}