package object_class_09.equals_02;

public class Car01 {

	String brand;
	double cost;
	String color;

	public Car01(String brand, double cost, String color) {
		this.brand = brand;
		this.cost = cost;
		this.color = color;
	}

	public String toString() {
		return "Car [brand=" + brand + ", cost=" + cost + ", color=" + color + "]";
	}

	public boolean equals(Object o) {
		Car01 ob = (Car01) o;
//		System.out.println(this.brand +", "+ this.cost +", "+ this.color +"\n"+ ob.brand +", "+ ob.cost +", "+ ob.color);
		return this.brand == ob.brand && this.cost == ob.cost && this.color == ob.color;
	}
}
