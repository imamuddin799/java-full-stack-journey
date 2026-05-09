package org.jsp.manytoone.controller;

import org.jsp.manytoone.dao.EmployeeDepartmentDao;
import org.jsp.manytoone.dto.Department;
import org.jsp.manytoone.dto.Employee;

public class EmployeeDepartmentController {

	public static void main(String[] args) {
		
		Department department = new Department();
		department.setName("Human Resources");
		department.setLocation("New York");
		department.setHeadOfDepartment("Alice Johnson");
        
//        Department department = new Department();
//        department.setName("IT Department");
//        department.setLocation("San Francisco");
//        department.setHeadOfDepartment("Bob Smith");
        
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAge(28);
        employee.setEmail("john.doe@example.com");
        employee.setSalary(55000.00);

//        Employee employee = new Employee();
//        employee.setName("Emma Watson");
//        employee.setAge(32);
//        employee.setEmail("emma.watson@example.com");
//        employee.setSalary(62000.00);
//        employee.setDepartment(department);
//
//        Employee employee = new Employee();
//        employee.setName("David Brown");
//        employee.setAge(26);
//        employee.setEmail("david.brown@example.com");
//        employee.setSalary(48000.00);
//        employee.setDepartment(department);
//
//        Employee employee = new Employee();
//        employee.setName("Sophia Martinez");
//        employee.setAge(29);
//        employee.setEmail("sophia.martinez@example.com");
//        employee.setSalary(67000.00);
//        employee.setDepartment(department);
//
//        Employee employee = new Employee();
//        employee.setName("James Wilson");
//        employee.setAge(35);
//        employee.setEmail("james.wilson@example.com");
//        employee.setSalary(75000.00);
//        employee.setDepartment(department);
//
//        Employee employee = new Employee();
//        employee.setName("Olivia Taylor");
//        employee.setAge(30);
//        employee.setEmail("olivia.taylor@example.com");
//        employee.setSalary(71000.00);
//        employee.setDepartment(department);
//
//        Employee employee = new Employee();
//        employee.setName("Michael Johnson");
//        employee.setAge(27);
//        employee.setEmail("michael.johnson@example.com");
//        employee.setSalary(53000.00);
//        employee.setDepartment(department);
//
//        Employee employee = new Employee();
//        employee.setName("Isabella Clark");
//        employee.setAge(31);
//        employee.setEmail("isabella.clark@example.com");
//        employee.setSalary(69000.00);
//        employee.setDepartment(department);
        
		EmployeeDepartmentDao dao = new EmployeeDepartmentDao();
		
//		dao.saveDepartment(department);
		
//		Case-1
//		Employee has Department
//        employee.setDepartment(department);
//        dao.saveEmployee(employee);
		
//		Case-2
//      Employee doesn't have Department
//        dao.saveEmployee(employee);
        
		
		dao.displayAllDepartments();
		dao.displayAllEmployees();
	}
}