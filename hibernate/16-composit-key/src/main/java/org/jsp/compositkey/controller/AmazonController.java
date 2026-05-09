package org.jsp.compositkey.controller;

import org.jsp.compositkey.dao.AmazonDao;
import org.jsp.compositkey.dto.Amazon;
import org.jsp.compositkey.dto.AmazonId;

public class AmazonController {

	public static void main(String[] args) {
//		Amazon amazon = new Amazon();
//		amazon.setName("Ramu");
//		amazon.setAddress("Bihar");
//		amazon.setPassword("Ramu@123");
//		
//		AmazonId amazonId = new AmazonId();
//		amazonId.setEmail("Ramu1@gmail.com");
//		amazonId.setMno(9876543201L);
//	
//		amazon.setAmazonId(amazonId);
		
		AmazonDao dao = new AmazonDao();
//		dao.saveAmazon(amazon);
		dao.fetchAllAmazon();
	}
}