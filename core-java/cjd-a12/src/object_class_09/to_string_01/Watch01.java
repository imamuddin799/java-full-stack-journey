package object_class_09.to_string_01;

public class Watch01 {

	String brand;
	double cost;
	String color;
	String type;

	Watch01(String brand, double cost, String color, String type) {
		this.brand = brand;
		this.cost = cost;
		this.color = color;
		this.type = type;
	}

	public String toString() {
		return "The watch brand is " + brand + " and its cost is " + cost + ";\nThe color and type of the watch are "
				+ color + ", " + type + " respectively;";
	}
}
