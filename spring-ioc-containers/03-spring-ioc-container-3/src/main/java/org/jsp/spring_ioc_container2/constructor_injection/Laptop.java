package org.jsp.spring_ioc_container2.constructor_injection;

public class Laptop {

	private String brand;
    private String model;
    private int ramGB;
    private Mouse mouse; // Composition

    public Laptop(String brand, String model, int ramGB, Mouse mouse) {
        this.brand = brand;
        this.model = model;
        this.ramGB = ramGB;
        this.mouse = mouse;
    }
    
    public void laptopDetails() {
    	System.out.println("Brand : "+ brand +" , Model : "+ model +" , RamGB : "+ ramGB + " , Mouse : "+ mouse.mouseDetails());
    }
}