package org.jsp.spring_ioc_container2.constructor_injection;

public class Engine {

	private String material;                   // e.g., Aluminum, Cast Iron
    private double size;                       // in cc or cubic inches
    private double weight;                     // in kilograms
    
	public Engine(String material, double size, double weight) {
		this.material = material;
		this.size = size;
		this.weight = weight;
	}
	
	public String engineDetails() {
		return "Engine [material=" + material + ", size=" + size + ", weight=" + weight + "]";
	}

	@Override
	public String toString() {
		return "Engine [material=" + material + ", size=" + size + ", weight=" + weight + "]";
	}
}