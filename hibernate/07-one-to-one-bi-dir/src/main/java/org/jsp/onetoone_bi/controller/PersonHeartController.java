package org.jsp.onetoone_bi.controller;

import org.jsp.onetoone_bi.dao.PersonHeartDao;
import org.jsp.onetoone_bi.dto.Heart;
import org.jsp.onetoone_bi.dto.Person;

public class PersonHeartController {
	
	public static void main(String[] args) {
//		Insert 1st person
		
//		Person person = new Person();
//		person.setId(101);
//		person.setName("Rahul");
//		person.setAddress("Hyd");
//		person.setMobile(9876543210L);
//		
//		Heart heart = new Heart();
//		heart.setId(1001);
//		heart.setBitsPerMinute(90);
//		heart.setWeight(2.5);

//		Update 1st person
		
//		Person person = new Person();
//		person.setId(101);
//		person.setName("Rahul Kumar");
//		person.setAddress("Hyd");
//		person.setMobile(9876543201L);
//		
//		Heart heart = new Heart();
//		heart.setId(1001);
//		heart.setBitsPerMinute(95);
//		heart.setWeight(3.5);
		
//		Insert 2nd person
		
//		Person person = new Person();
//		person.setId(102);
//		person.setName("Dimple");
//		person.setAddress("Bihar");
//		person.setMobile(9876543012L);
//		
//		Heart heart = new Heart();
//		heart.setId(1002);
//		heart.setBitsPerMinute(90);
//		heart.setWeight(1.5);
		
//		Update 2nd person
		
//		Person person = new Person();
//		person.setId(102);
//		person.setName("Dimple Kumari");
//		person.setAddress("UP");
//		person.setMobile(9876543021L);
//		
//		Heart heart = new Heart();
//		heart.setId(1002);
//		heart.setBitsPerMinute(85);
//		heart.setWeight(2.5);
		
//		Insert 3rd person
		
//		Person person = new Person();
//		person.setId(103);
//		person.setName("Amit");
//		person.setAddress("Hyd");
//		person.setMobile(9876543043L);
//		
//		Heart heart = new Heart();
//		heart.setId(1003);
//		heart.setBitsPerMinute(70);
//		heart.setWeight(2.5);
		
//		Update 3rd person
		
//		Person person = new Person();
//		person.setId(103);
//		person.setName("Amit Kumar");
//		person.setAddress("Hyd");
//		person.setMobile(9876543034L);
//		
//		Heart heart = new Heart();
//		heart.setId(1003);
//		heart.setBitsPerMinute(75);
//		heart.setWeight(2.8);
		
//		Insert 4th person
		
//		Person person = new Person();
//		person.setId(104);
//		person.setName("Sheela");
//		person.setAddress("Hyd");
//		person.setMobile(9876543089L);
//		
//		Heart heart = new Heart();
//		heart.setId(1004);
//		heart.setBitsPerMinute(85);
//		heart.setWeight(2.5);
		
//		Update 4th person
		
//		Person person = new Person();
//		person.setId(104);
//		person.setName("Sheela Sah");
//		person.setAddress("Hyderabad");
//		person.setMobile(9876543098L);
//		
//		Heart heart = new Heart();
//		heart.setId(1004);
//		heart.setBitsPerMinute(80);
//		heart.setWeight(2.0);
		
		
//		Update 1st heart
		
//		Heart heart = new Heart();
//		heart.setId(1001);
//		heart.setBitsPerMinute(90);
//		heart.setWeight(2.5);
		
//		Update 2nd heart
		
//		Heart heart = new Heart();
//		heart.setId(1002);
//		heart.setBitsPerMinute(90);
//		heart.setWeight(1.5);
		
//		Update 3rd heart
		
//		Heart heart = new Heart();
//		heart.setId(1003);
//		heart.setBitsPerMinute(70);
//		heart.setWeight(2.5);
		
//		Update 4th heart
		
//		Heart heart = new Heart();
//		heart.setId(1004);
//		heart.setBitsPerMinute(85);
//		heart.setWeight(2.5);


		PersonHeartDao dao = new PersonHeartDao();
		
//		Case-1
//		Person has Heart as well as Heart has Person
//		person.setHeart(heart);
//		heart.setPerson(person);
//		dao.savePerson(person);
		
//		Case-2
//		Heart has Person as weell as Person has Heart
//		heart.setPerson(person);
//		person.setHeart(heart);
//		dao.saveHeart(heart);
		
//		Case-3
//		Person has Heart but Heart does not have Person
//		person.setHeart(heart);
//		dao.savePerson(person);
		
//		Case-4
//		Heart has Person but Person does not have Heart
//		heart.setPerson(person);
//		dao.saveHeart(heart);
		
//		Updation
		
//		Case-1
//		Update 1st person
//		heart.setPerson(person);
//		person.setHeart(heart);
//		dao.updatePersonById(person);
		
//		Case-2
//		Update 2nd person
//		heart.setPerson(person);
//		person.setHeart(heart);
//		dao.updateHeartById(heart);
		
//		Case-3
//		Update 3rd person
//		person.setHeart(heart);
//		dao.updatePersonById(person);

//		Case-4
//		Update 4th person
//		heart.setPerson(person);
//		dao.updateHeartById(heart);
		
//		Updating only heart, person will not get affected
//		dao.updateHeartById(heart);
		
//		Finding person by id
//		dao.findPersonById(101);
//		dao.findPersonById(102);
//		dao.findPersonById(103);
//		dao.findPersonById(104);
//		dao.findPersonById(105);
		
//		Finding heart by id
//		dao.findHeartById(1001);
//		dao.findHeartById(1002);
//		dao.findHeartById(1003);
//		dao.findHeartById(1004);
//		dao.findHeartById(1005);
		
//		Deleting person by id (Both the person and heart will be deleted)
//		dao.deletePersonById(101);
		
//		Deleting heart by id (Both the heart and person will be deleted)
//		dao.deleteHeartById(1002);
		
//		Fetching all the Persons
		dao.fetchAllPersons();
		
//		Fetching all the Hearts
		dao.fetchAllHearts();
	}
}