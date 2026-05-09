package org.jsp.manytomany_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomany_bi.dto.Course;
import org.jsp.manytomany_bi.dto.Student;

public class StudentCourseDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
	
	public void saveStudent(Student student) {
		transaction.begin();
		manager.persist(student);
		transaction.commit();
		System.out.println("\nStudent saved...\n");
	}
	
	public void saveCourse(Course course) {
		transaction.begin();
		manager.persist(course);
		transaction.commit();
		System.out.println("\nCourse saved...\n");
	}
	
	public void updateStudent(Student student) {
		if(student != null) {
			transaction.begin();
			manager.merge(student);
			transaction.commit();
			System.out.println("\nStudent Updated...\n");
		}
	}
	
	public void updateCourse(Course course) {
		if(course != null) {
			transaction.begin();
			manager.merge(course);
			transaction.commit();
			System.out.println("\nCourse Updated...\n");
		}
	}
	
	public void findStudentById(int studentId) {
		Student student = manager.find(Student.class, studentId);
		if(student != null) {
			System.out.println(student);
		}
		else {
			System.out.println("There is no student with id : "+ studentId);
		}
	}
	
	public void findCourseById(int courseId) {
		Course course = manager.find(Course.class, courseId);
		if(course != null) {
			System.out.println(course);
		}
		else {
			System.out.println("There is no course with id : "+ courseId);
		}
	}
	
	public void findAllStudents() {
		Query query = manager.createQuery("select student from Student student");
		List<Student> students = query.getResultList();
		if(!students.isEmpty()) {
			for(Student student : students) {
				System.out.println(student);
			}
		}
		else {
			System.out.println("\nNo students are there...\n");
		}
	}
	
	public void findAllCourses() {
		Query query = manager.createQuery("select course from Course course");
		List<Course> courses = query.getResultList();
		if(!courses.isEmpty()) {
			for(Course course : courses) {
				System.out.println(course);
			}
		}
		else {
			System.out.println("\nNo courses are there...\n");
		}
	}
	
	public void deleteStudentById(int studentId) {
		Student student = manager.find(Student.class, studentId);
		if(student != null) {
			student.setCourses(null);
			transaction.begin();
			manager.remove(student);
			transaction.commit();
			System.out.println("\nStudent deleted...\n");
		}
		else {
			System.out.println("\nStudent not found with id : "+ studentId +"\n");
		}
	}
	
	public void deleteCourseById(int courseId) {
		Course course = manager.find(Course.class, courseId);
		if(course != null) {
//			course.setStudents(null);
//			System.out.println(course.getStudents());
			
			List<Student> students = course.getStudents();
			for(Student student : students) {
				student.getCourses().remove(course);
			}
			course.setStudents(null);
			transaction.begin();
			manager.remove(course);
			transaction.commit();
			System.out.println("\nCourse delete...\n");
		}
		else {
			System.out.println("\nCourse not found with id : "+ courseId +"\n");
		}
	}
	
	public void assignCourseToStudentById(int courseId, int studentId) {
		Student student = manager.find(Student.class, studentId);
		Course course = manager.find(Course.class, courseId);
		if(student != null && course != null) {
			course.getStudents().add(student);
			student.getCourses().add(course);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
			System.out.println("\nCourse assigned from student...\n");
		}
	}
	
	public void unassignCourseFromStudentById(int courseId, int studentId) {
		Student student = manager.find(Student.class, studentId);
		Course course = manager.find(Course.class, courseId);
		if(student != null && course != null) {
			course.getStudents().remove(student);
			student.getCourses().remove(course);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
			System.out.println("\nCourse unassigned from student");
		}
	}
	
	public void assignStudentToCourseById(int studentId, int courseId) {
		Course course = manager.find(Course.class, courseId);
		Student student = manager.find(Student.class, studentId);
		
		if(course != null && student != null) {
			student.getCourses().add(course);
			course.getStudents().add(student);
			
			transaction.begin();
			manager.merge(course);
			transaction.commit();
			System.out.println("\nStudent assigned to course");
		}
	}
	
	public void unassignStudentFromCourseById(int studentId, int courseId) {
		Student student = manager.find(Student.class, studentId);
		Course course = manager.find(Course.class, courseId);
		if(student != null && course != null) {
			student.getCourses().remove(course);
			course.getStudents().remove(student);
			transaction.begin();
			manager.merge(course);
			transaction.commit();
			System.out.println("\nCourse unassigned from student");
		}
	}
}