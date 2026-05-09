package org.jsp.manytomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.manytomany_uni.dao.CustomerProductDao;
import org.jsp.manytomany_uni.dto.Customer;
import org.jsp.manytomany_uni.dto.Product;

public class CustomerProductController {

	public static void main(String[] args) {
		
        Customer c1 = new Customer();
        c1.setName("John Doe");
        c1.setAddress("New York");

        Customer c2 = new Customer();
        c2.setName("Emma Watson");
        c2.setAddress("Britain");

        Customer c3 = new Customer();
        c3.setName("David Brown");
        c3.setAddress("California");

        Customer c4 = new Customer();
        c4.setName("Sophia Martinez");
        c4.setAddress("Texas");

        Customer c5 = new Customer();
        c5.setName("Michael Johnson");
        c5.setAddress("Chicago");
        
		Product p1 = new Product();
        p1.setName("Laptop");
        p1.setQuantity(10);
        p1.setPrice(75000.00);

        Product p2 = new Product();
        p2.setName("Smartphone");
        p2.setQuantity(15);
        p2.setPrice(45000.00);

        Product p3 = new Product();
        p3.setName("Headphones");
        p3.setQuantity(30);
        p3.setPrice(2500.00);

        Product p4 = new Product();
        p4.setName("Smartwatch");
        p4.setQuantity(20);
        p4.setPrice(12000.00);

        Product p5 = new Product();
        p5.setName("Tablet");
        p5.setQuantity(8);
        p5.setPrice(30000.00);
        
        Product p6 = new Product();
        p6.setName("Purse");
        p6.setQuantity(8);
        p6.setPrice(30000.00);
        
        List<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        
        CustomerProductDao dao = new CustomerProductDao();
//        c1.setProducts(products);
//        c2.setProducts(products);
//        c3.setProducts(products);
//        c4.setProducts(products);
//        c5.setProducts(products);
//        
//        dao.saveCustomer(c1);
//        dao.saveCustomer(c2);
//        dao.saveCustomer(c3);
//        dao.saveCustomer(c4);
//        dao.saveCustomer(c5);
        
//        dao.saveProduct(p6);
        
//        Here setting Pid is mandatory
//        p6.setPid(11);
//        dao.updateProductByid(p6);
        
//        Here setting Cid is mandatory
//        c5.setCid(7);
//        dao.updateCustomerById(c5);
        
//        Here we have to provide Cid which is already present in the database
//        dao.deleteCustomerById(10);
        
//        Here we have to provide Pid which is already present in the database
//        dao.deleteProductById(2);
        
//        dao.unassignProcuctFromCustomer(8, 3);
//        dao.assignProductToCustomer(7, 7);
        
        dao.displayAllCustomers();
        dao.displayAllProducts();
	}
}