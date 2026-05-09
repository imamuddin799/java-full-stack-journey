package com.tcs.onetoone_uni.controller;

import com.tcs.onetoone_uni.dao.CountryCapitalDao;
import com.tcs.onetoone_uni.dto.Capital;
import com.tcs.onetoone_uni.dto.Country;

public class CountryCapitalController {

	public static void main(String[] args) {
		Capital capital = new Capital();
		capital.setId(1010);
		capital.setName("Canberra");
		
		Country country = new Country();
		country.setCid(10);
		country.setName("Australia");
		country.setCode(61);
		country.setCapital(capital);	//Country has Capital
		
		CountryCapitalDao dao = new CountryCapitalDao();
//		dao.saveCountry(country);
		
//		dao.saveOnlyCapital(capital);
		
//		dao.saveOnlyCountry(country);
		
//		dao.updateCountryById(country);
		
//		dao.updateCapitalById(capital);
		
//		System.out.println(dao.findCountryById(10));
//		System.out.println(dao.findCapitalById(1010));

//		dao.deleteCountryById(7);
		
//		dao.deleteCapitalById(1010);	//This line of code is giving error	(Cannot delete or update a parent row: a foreign key constraint fails (`onetoone_uni`.`country`, CONSTRAINT `FKq3g3cae5vuqhcib862mx6o9oh` FOREIGN KEY (`capital_id`) REFERENCES `capital` (`id`)))
		
		dao.displayAllCountries();
		
		dao.displayAllCapitals();
	}
}