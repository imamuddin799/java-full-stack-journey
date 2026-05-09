package org.jsp.manytoone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

public class EmployeeDepartmentDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public void saveEmployee(Employee employee) {
		Query allEmployee = manager.createQuery("select employee from Employee employee");
		List<Employee> employees = allEmployee.getResultList();
		
		if (!employees.isEmpty()) {
			for (Employee employee2 : employees) {
				if (employee2.getEmail().equals(employee.getEmail())) {
					System.out.println("Employee already present");
					return;
				}
			}
		}
		
		Query query = manager.createQuery("select department from Department department");
		List<Department> departments = query.getResultList();
		
		if (employee.getDepartment() != null) {
			long alreadyPresentDepartment = 0;
			if (!departments.isEmpty()) {
				for (Department department : departments) {
					if (department.getName().equals(employee.getDepartment().getName())) {
						alreadyPresentDepartment = department.getId();
						break;
					}
				}
			}
			
			if(alreadyPresentDepartment != 0) {
				Department department = manager.find(Department.class, alreadyPresentDepartment);
				employee.setDepartment(department);
				transaction.begin();
				manager.persist(employee);
				transaction.commit();
				System.out.println("Employee saved...");
			}
			else {
				transaction.begin();
				manager.persist(employee.getDepartment());
				System.out.println("Department saved");
				manager.persist(employee);
				transaction.commit();
				System.out.println("Employee saved...");
			}
		} else {
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			System.out.println("Employee saved...");
		}
	}

	public void saveDepartment(Department department) {
		Query query = manager.createQuery("select department from Department department");
		List<Department> departments = query.getResultList();
		long alreadyPresentDepartment = 0;
		for(Department department2 : departments) {
			if(department2.getName().equals(department.getName())) {
				alreadyPresentDepartment = department2.getId();
			}
		}
		if(alreadyPresentDepartment != 0) {
			transaction.begin();
			manager.persist(department);
			transaction.commit();
		}
		else {
			System.out.println("Department already present...");
		}
		
	}

	public void findEmployeeById(int employeeId) {
		Employee employee = manager.find(Employee.class, employeeId);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("Employee not found with id : " + employeeId);
		}
	}

	public void findDeprtmentById(int departmentId) {
		Department department = manager.find(Department.class, departmentId);
		if (department != null) {
			System.out.println(department);
		} else {
			System.out.println("Department not found with id : " + departmentId);
		}
	}

	public void displayAllEmployees() {
		Query query = manager.createQuery("select employee from Employee employee");
		List<Employee> employees = query.getResultList();

		if (!employees.isEmpty()) {
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		} else {
			System.out.println("There is no employee saved yet...");
		}
	}

	public void displayAllDepartments() {
		Query query = manager.createQuery("select department from Department department");
		List<Department> departments = query.getResultList();

		if (!departments.isEmpty()) {
			for (Department department : departments) {
				System.out.println(department);
			}
		} else {
			System.out.println("There is no department saved yet...");
		}
	}

	public void updateEmployeeById(Employee employee) {
		Employee employeeFromDatabase = manager.find(Employee.class, employee.getId());
		if (employeeFromDatabase != null) {
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			System.out.println("Employee Updated...");
		} else {
			System.out.println("There is no employee found with the id : " + employee.getId());
		}
	}

	public void updateDepartmentById(Department department) {
		Department departmentFromDatabase = manager.find(Department.class, department.getId());
		if (departmentFromDatabase != null) {
			transaction.begin();
			manager.merge(department);
			transaction.commit();
			System.out.println("Department Updated...");
		} else {
			System.out.println("There is no department found with the id : " + department.getId());
		}
	}
}