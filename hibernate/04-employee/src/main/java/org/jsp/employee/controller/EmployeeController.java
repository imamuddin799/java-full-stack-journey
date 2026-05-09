package org.jsp.employee.controller;

import java.util.List;
import java.util.ListIterator;

import org.jsp.employee.dao.EmployeeDao;
import org.jsp.employee.dto.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		
//		Employee employee = new Employee();
//		employee.setEid(107);
//		employee.setName("Virat Kohli");
//		employee.setSal(10000);
//		employee.setAddress("Delhi");
		
		EmployeeDao dao = new EmployeeDao();
		
//		dao.saveEmployee(employee);
		
//		dao.deleteEmployeeById(101);
		
//		Employee findEmployee = dao.findEmployeeById(111);
//		System.out.println(findEmployee);
		
//		dao.updateEmployee(employee);
		
		List<Employee> employees = dao.fetchAllEmployees();
		
		ListIterator<Employee> listIterator = employees.listIterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
	}
}