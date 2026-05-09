package collection_13.set_02.tree_set_02.dec_31;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Garden03 {

	public static void main(String[] args) {
		ArrayList<Flower02> al = new ArrayList<Flower02>();
		al.add(new Flower02("Rose", "Pink", 300));
		al.add(new Flower02("Lily", "White", 400));
		al.add(new Flower02("Lotus", "HotPink", 500));
		al.add(new Flower02("Sun Flower", "Yellow", 200));
		al.add(new Flower02("Marygold", "Yellow", 300));
		al.add(new Flower02("Bluebell", "Blue", 100));
		al.add(new Flower02("Jasmin", "Green", 200));
		al.add(new Flower02("Calendula", "Yellowgreen", 400));
		al.add(new Flower02("Dahlia", "Red", 500));
		al.add(new Flower02("Iris", "Violet", 600));
		al.add(new Flower02("Poppy", "Red", 900));

		System.out.println(al);

//		ArrayList<String> row = new ArrayList<String>();
//		
//		for(Flower02 s : al) {
//			System.out.println(s.toTable());
//			row.add(s.toTable());
//		}
//		System.out.println(row);
//		for(String s : row) {
//			System.out.printf("%-20s%-20s%-20s",s.substring(0,s.indexOf(",")),s.substring(s.indexOf(",")+1,s.lastIndexOf(",")), s.substring(s.lastIndexOf(",")+1));
//			System.out.println();
//		}

//		String header[] = {"Name","Color","Cost"};

		Scanner sc = new Scanner(System.in);

		Comparator<Flower02> nameAsc = (Flower02 f1, Flower02 f2) -> {
			return f1.name.compareTo(f2.name);
		};
		Comparator<Flower02> nameDesc = (Flower02 f1, Flower02 f2) -> {
			return f2.name.compareTo(f1.name);
		};
		Comparator<Flower02> colorAsc = (Flower02 f1, Flower02 f2) -> {
			return f1.color.compareTo(f2.color);
		};
		Comparator<Flower02> colorDesc = (Flower02 f1, Flower02 f2) -> {
			return f2.color.compareTo(f1.color);
		};
		Comparator<Flower02> costAsc = (Flower02 f1, Flower02 f2) -> {
			if (f1.cost > f2.cost)
				return 1;
			else
				return -1;
		};
		Comparator<Flower02> costDesc = (Flower02 f1, Flower02 f2) -> {
			if (f1.cost < f2.cost)
				return 1;
			else
				return -1;
//			if (f1.cost > f2.cost)
//				return -1;
//			if (f1.cost < f2.cost)
//				return 1;
//			return 0;
		};

		System.out.println("Choose the following");
		System.out.println("1:Name Ascending\n2:Name Descending");
		System.out.println("3:Color Ascending\n4:Color Descending");
		System.out.println("5:Cost Ascending\n6:Cost Descending");
		int op = sc.nextInt();
		Comparator<Flower02> com = nameAsc;
		switch (op) {
		case 2:
			com = nameDesc;
			break;
		case 3:
			com = colorAsc;
			break;
		case 4:
			com = colorDesc;
			break;
		case 5:
			com = costAsc;
			break;
		case 6:
			com = costDesc;
			break;
		}
		TreeSet<Flower02> ts = new TreeSet<Flower02>(com);
//		System.out.println(ts);
		ts.addAll(al);
//		System.out.println(ts);
		System.out.println("\n\n\n");
		ArrayList<String> row = new ArrayList<String>();

		for (Flower02 s : ts) {
//			System.out.println(s.toTable());
			row.add(s.toTable());
		}
//		System.out.println(row);
		for (String s : row) {
			System.out.printf("%-20s%-20s%-20s", s.substring(0, s.indexOf(",")),
					s.substring(s.indexOf(",") + 1, s.lastIndexOf(",")), s.substring(s.lastIndexOf(",") + 1));
			System.out.println();
		}
//		System.out.println("\n\n"+ ts.comparator());
	}
}