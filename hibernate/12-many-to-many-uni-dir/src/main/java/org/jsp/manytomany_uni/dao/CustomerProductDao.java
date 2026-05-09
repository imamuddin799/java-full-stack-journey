package org.jsp.manytomany_uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomany_uni.dto.Customer;
import org.jsp.manytomany_uni.dto.Product;

public class CustomerProductDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
	
	public void saveCustomer(Customer customer) {
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		System.out.println("\nCustomer Saved...\n");
	}
	
	public void saveProduct(Product product) {
		transaction.begin();
		manager.persist(product);
		transaction.commit();
		System.out.println("\nProduct saved...\n");
	}
	
	public void findCustomerById(int customerId) {
		Customer customer = manager.find(Customer.class, customerId);
		if(customer != null) {
			System.out.println(customer);
		}
		else {
			System.out.println("\nCustomer not found...\n");
		}
	}
	
	public void findProductById(int produactId) {
		Product product = manager.find(Product.class, produactId);
		if(product != null) {
			System.out.println(product);
		}
		else {
			System.out.println("\nCustomer not found...\n");
		}
	}
	
	public void displayAllCustomers() {
		Query query = manager.createQuery("select customer from Customer customer");
		List<Customer> customers = query.getResultList();
		if(!customers.isEmpty()) {
			for(Customer customer : customers) {
				System.out.println(customer);
			}
		}
		else {
			System.out.println("\nThere is no customer added yet...\n");
		}
	}
	
	public void displayAllProducts() {
		Query query = manager.createQuery("select product from Product product");
		List<Product> products = query.getResultList();
		if(!products.isEmpty()) {
			for(Product product : products) {
				System.out.println(product);
			}
		}
		else {
			System.out.println("\nThere is no product added yet...");
		}
	}
	
	public void updateProductByid(Product product) {
		transaction.begin();
		manager.merge(product);
		transaction.commit();
		System.out.println("\nProduct updated...\n");
	}
	
	public void updateCustomerById(Customer customer) {
		transaction.begin();
		manager.merge(customer);
		transaction.commit();
		System.out.println("\nCustomer updated\n");
	}
	
	public void deleteCustomerById(int cid) {
		Customer customer = manager.find(Customer.class, cid);
		customer.setProducts(null);
		transaction.begin();
		manager.remove(customer);
		transaction.commit();
		System.out.println("\nCustomer deleted...\n");
	}
	
	public void deleteProductById(int pid) {
		Product product = manager.find(Product.class, pid);
		Query query = manager.createQuery("select customer from Customer customer");
		List<Customer> customers = query.getResultList();
		for(Customer customer : customers) {
			List<Product> products = customer.getProducts();
			List<Product> productToRemove = new ArrayList<Product>();
			for(Product product2 : products) {
				if(product2.getPid() == pid) {
					productToRemove.add(product2);
				}
			}
			products.removeAll(productToRemove);
			customer.setProducts(products);
		}
		transaction.begin();
		manager.remove(product);
		transaction.commit();
		System.out.println(product);
	}
	
	public void assignProductToCustomer(int customerId, int productId) {
		Customer customer = manager.find(Customer.class, customerId);
		Product product = manager.find(Product.class, productId);
		if(customer != null && product != null) {
			List<Product> products = customer.getProducts();
			if(!products.contains(product)) {
				products.add(product);
				customer.setProducts(products);
				transaction.begin();
				manager.merge(customer);
				transaction.commit();
				System.out.println("\nProduct assigned to customer...\n");
			}
			else {
				System.out.println("\nProduct already assinged...\n");
			}
		}
		else {
			System.out.println("\nProduct or Customer not available...\n");
		}
	}
	
	public void unassignProcuctFromCustomer(int customerId, int productId) {
		Customer customer = manager.find(Customer.class, customerId);
		Product product = manager.find(Product.class, productId);
		if(customer != null && product != null) {
			List<Product> products = customer.getProducts();
			products.remove(product);
			customer.setProducts(products);
			transaction.begin();
			manager.merge(customer);
			transaction.commit();
			System.out.println("\nProduct unassigned from customer...\n");
		}
		else {
			System.out.println("\nEither Product or Customer not available...\n");
		}
	}
}