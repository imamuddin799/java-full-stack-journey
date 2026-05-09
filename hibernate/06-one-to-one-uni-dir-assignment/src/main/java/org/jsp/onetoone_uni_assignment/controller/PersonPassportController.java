package org.jsp.onetoone_uni_assignment.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.jsp.onetoone_uni_assignment.dao.PersonPassportDao;
import org.jsp.onetoone_uni_assignment.dto.Passport;
import org.jsp.onetoone_uni_assignment.dto.Person;

public class PersonPassportController {

	public static void main(String[] args) {
		
		Passport passport = new Passport();
		passport.setId(1002);
		passport.setPassportNumber("A1234576");
//		Date formate should be YYYY-MM-DD
		String date = "2025-03-07";
		LocalDate issueLocalDate = LocalDate.parse(date);
		Date issueDate = Date.valueOf(issueLocalDate);
		passport.setIssueDate(issueDate);
		LocalDate expiryLocalDate = issueLocalDate.plusYears(5);
		Date expiryDate = Date.valueOf(expiryLocalDate);
		passport.setExpiryDate(expiryDate);
		passport.setCountry("India");
		
//		System.out.println(issueDate);
//		System.out.println(expiryDate);
		
		Person person = new Person();
		person.setId(102);
		person.setName("Vamshi");
		
//		Gender should be either Male or Female
		person.setGender("Male");
		person.setAge(24);
		person.setPassport(passport);
		
		PersonPassportDao dao = new PersonPassportDao();
//		dao.savePerson(person);
		
//		dao.findPersonById(101);
//		dao.findPassportById(1001);
		
		dao.findAllPersons();
		dao.findAllPassports();
	}
}