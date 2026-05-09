package collection_13.list_01.arraylist_01.sorting.dec_23;

import java.util.ArrayList;
import java.util.Collections;

public class CarShowroom02 {

	public static void main(String[] args) {
		ArrayList<Car01> cars = new ArrayList<Car01>();
		cars.add(new Car01("RollsRoyec", 40000000, 340));
		cars.add(new Car01("Lamborghini", 80000000, 240));
		cars.add(new Car01("Thar", 2500000, 200));
		cars.add(new Car01("Alto", 500000, 140));
		cars.add(new Car01("RangeRover", 8000000, 220));
		System.out.println(cars);
		double sum = 0;
		for (Car01 c : cars) {
			sum += c.cost;
		}
		double avg = sum / cars.size();
		System.out.println("\n" + avg);
		Collections.sort(cars);
		for (Car01 c : cars) {
			if (c.cost < avg) {
				System.out.print(c);
			}
		}
	}
}