package org.jsp.manytomany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.manytomany_bi.dao.StudentCourseDao;
import org.jsp.manytomany_bi.dto.Course;
import org.jsp.manytomany_bi.dto.Student;

public class StudentCouseController {

	public static void main(String[] args) {
		
		Course c1 = new Course();
        c1.setTitle("Java Programming");
        c1.setInstructor("John Smith");
        c1.setDuration(8);
        c1.setFee(5000.00);

        Course c2 = new Course();
        c2.setTitle("Database Management");
        c2.setInstructor("Alice Johnson");
        c2.setDuration(6);
        c2.setFee(4500.00);
        
        List<Course> courses = new ArrayList<Course>();
        courses.add(c1);
        courses.add(c2);
        
        Student s1 = new Student();
        s1.setStudentName("John Doe");
        s1.setStudentAge(22);
        s1.setStudentEmail("john.doe@example.com");
        s1.setDepartment("Computer Science");

        Student s2 = new Student();
        s2.setStudentName("Emma Watson");
        s2.setStudentAge(24);
        s2.setStudentEmail("emma.watson@example.com");
        s2.setDepartment("Information Technology");
        
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        
        StudentCourseDao dao = new StudentCourseDao();
        
//        Case-1
//        c1.setStudents(students);
//        c2.setStudents(students);
//        s1.setCourses(courses);
//        s2.setCourses(courses);
//        
//        dao.saveStudent(s1);
        
//        Case-2
//        c1.setStudents(students);
//        c2.setStudents(students);
//        s1.setCourses(courses);
//        s2.setCourses(courses);
//        
//        dao.saveCourse(c1);
        
//        Case-3
//        s1.setCourses(courses);
//        s2.setCourses(courses);
        
//        dao.saveStudent(s1);
        
//        Case-4
//        c1.setStudents(students);
//        c2.setStudents(students);
//        
//        dao.saveCourse(c1);
        
//        courses.remove(c1);
//        students.remove(s2);
//        c2.setCourseId(6);
//        s1.setStudentId(7);
//        dao.updateStudent(s1);
        
//        dao.deleteStudentById(1);
//        dao.deleteCourseById(2);
        
//        dao.assignStudentToCourseById(5, 4);
//        dao.unassignStudentToCourseById(3, 4);
        
        dao.findAllStudents();
        dao.findAllCourses();
	}
}