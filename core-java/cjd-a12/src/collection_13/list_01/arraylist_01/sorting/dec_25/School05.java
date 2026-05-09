package collection_13.list_01.arraylist_01.sorting.dec_25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class School05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the following");
		System.out.println("1:ID\n2:Name\n3:Marks");
		int option = sc.nextInt();
		Comparator<Student01> com = new IDComparator02();
		if (option == 2) {
			com = new NameComparator03();
		} else if (option == 3) {
			com = new MarksComparator04();
		}
		ArrayList<Student01> s = new ArrayList<Student01>();
		s.add(new Student01(1, "ABC", 50));
		s.add(new Student01(2, "DEF", 60));
		s.add(new Student01(3, "DEF", 60));
		s.add(new Student01(420, "Imamuddin", 55));
		s.add(new Student01(220, "Raj Kumar", 41));
		s.add(new Student01(407, "Hari", 97));
		s.add(new Student01(107, "Nikithia", 61));
		s.add(new Student01(144, "Akhila", 50));
		s.add(new Student01(421, "Vasantha", 99));
		s.add(new Student01(221, "Jhansi", 100));
		System.out.println(s);
		Collections.sort(s, com);
		System.out.println(s);
	}
}