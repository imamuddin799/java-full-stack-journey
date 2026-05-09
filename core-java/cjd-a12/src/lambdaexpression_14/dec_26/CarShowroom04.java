package lambdaexpression_14.dec_26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CarShowroom04 {

	public static void main(String[] args) {
//		Comparator<Car03> brandAsc = (Car03 c1, Car03 c2)->{
//			return c1.brand.compareTo(c2.brand);
//		};
//		Comparator<Car03> brandDesc = (Car03 c1, Car03 c2)->{
//			return c2.brand.compareTo(c1.brand);
//		};
//		Comparator<Car03> costAsc = (Car03 c1, Car03 c2)->{
//			int c = (int) (c1.cost-c2.cost);
//			return c;
//		};
//		Comparator<Car03> costDesc = (Car03 c1, Car03 c2)->{
//			int c = (int) (c2.cost-c1.cost);
//			return c;
//		};
//		Comparator<Car03> speedAsc = (Car03 c1, Car03 c2)->{
//			return c1.topSpeed-c2.topSpeed;
//		};
//		Comparator<Car03> speedDesc = (Car03 c1, Car03 c2)->{
//			return c2.topSpeed-c1.topSpeed;
//		};
//		Comparator<Car03> allComp = (Car03 c1, Car03 c2)->{
//			if(c1.cost != c2.cost) {
//				int c = (int) (c2.cost-c1.cost);
//				return c;
//			}
//			if(c1.topSpeed != c2.topSpeed) {
//				return c2.topSpeed-c1.topSpeed;
//			}
//			if(c1.brand != c2.brand) {
//				return c1.brand.compareTo(c2.brand);
//			}
//			return 0;
//		};
//		
//		ArrayList<Car03> cars = new ArrayList<Car03>();
//		cars.add(new Car03("RollsRoyec", 40000000, 340));
//		cars.add(new Car03("Lamborghini1", 80000000, 242));
//		cars.add(new Car03("Lamborghini", 80000000, 242));
//		cars.add(new Car03("Thar", 2500000, 200));
//		cars.add(new Car03("Alto", 500000, 140));
//		cars.add(new Car03("RangeRover", 8000000, 220));
//		System.out.println(cars);
//		
//		Collections.sort(cars, brandAsc);
//		System.out.println(cars);
//		
//		Collections.sort(cars, brandDesc);
//		System.out.println(cars);
//		
//		Collections.sort(cars, costAsc);
//		System.out.println(cars);
//		
//		Collections.sort(cars, costDesc);
//		System.out.println(cars);
//		
//		Collections.sort(cars, speedAsc);
//		System.out.println(cars);
//		
//		Collections.sort(cars, speedDesc);
//		System.out.println(cars);
//		
//		Collections.sort(cars, allComp);
//		System.out.println(cars);
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the following");
		System.out.println("1:Brand-Ascending\n2:Brand-Descending");
		System.out.println("3:Cost-Ascending\n4:Cost-Descending");
		System.out.println("5:TopSpeed-Ascending\n6:TopSpeed-Descending");
		System.out.println("7:All");
		
		int op = sc.nextInt();
		Comparator<Car03> com = (o1,o2) -> o1.brand.compareTo(o2.brand);
		switch(op) {
		case 2: com = (o1,o2) -> o2.brand.compareTo(o1.brand);break;
		case 3: com = (o1,o2) -> {
			if(o1.cost > o2.cost)
				return 1;
			if(o1.cost < o2.cost)
				return -1;
			return 0;
		};break;
		case 4: com = (o1,o2) -> {
			if(o1.cost > o2.cost)
				return 1;
			if(o1.cost < o2.cost)
				return -1;
			return 0;
		};break;
		case 5: com = (o1,o2) -> o1.topSpeed - o2.topSpeed;break;
		case 6: com = (o1,o2) -> o2.topSpeed - o1.topSpeed;break;
		case 7:{
			com = (o1,o2) -> {
				if(o1.cost > o2.cost)
					return 1;
				if(o1.cost < o2.cost)
					return -1;
				int n = o1.topSpeed - o2.topSpeed;
				if(n==0)
					return o1.brand.compareTo(o2.brand);
				return n;
			};
		}
		}
		ArrayList<Car03> cars = new ArrayList<Car03>();
		cars.add(new Car03("RollsRoyce", 40000000, 240));
		cars.add(new Car03("Lamborghini", 40000000, 240));
		cars.add(new Car03("Alto", 500000, 140));
		cars.add(new Car03("RangeRover", 8000000, 240));
		cars.add(new Car03("Thar", 500000, 200));
		System.out.println(cars);
		Collections.sort(cars,com);
		System.out.println(cars);
	}
}