package collection_13.list_01.arraylist_01.sorting.dec_23;

public class Car01 implements Comparable<Car01> {

	public String brand;
	public double cost;
	public int topSpeed;

	public Car01(String brand, double cost, int topSpeed) {
		this.brand = brand;
		this.cost = cost;
		this.topSpeed = topSpeed;
	}

	public String toString() {
		return "\nCar [brand=" + brand + ", cost=" + cost + ", topSpeed=" + topSpeed + "]";
	}

	public int compareTo(Car01 o) {
		if (o.cost > this.cost)
			return 1;
		if (o.cost < this.cost)
			return -1;
		return 0;
	}
}