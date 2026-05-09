package org.jsp.caching.controller;

import org.jsp.caching.dao.StudentDao;
import org.jsp.caching.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		
//		Student student = new Student();
//		student.setSid(1);
//		student.setName("Hero");
//		student.setAddress("Hyd");
		
//		Student student = new Student();
//		student.setSid(2);
//		student.setName("Sheela");
//		student.setAddress("Hyd");
		
		StudentDao dao = new StudentDao();
//		dao.saveStudent(student);
		
		dao.findStudentById(1);
		dao.findStudentById(2);
		dao.findStudentById(1);
		dao.findStudentById(2);
		dao.findStudentById(1);
		dao.findStudentById(2);
		dao.findStudentById(1);
		dao.findStudentById(2);
		dao.findStudentById(1);
		dao.findStudentById(2);
	}
}