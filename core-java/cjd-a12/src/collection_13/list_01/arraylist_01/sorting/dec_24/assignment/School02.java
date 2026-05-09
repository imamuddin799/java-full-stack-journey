package collection_13.list_01.arraylist_01.sorting.dec_24.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class School02 {

	public static void main(String[] args) {
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

		Collections.sort(s);

		System.out.println(s);

		int rank = 1;
		for (Student01 s1 : s) {
			s1.rank = rank++;
		}
		System.out.println(s);
	}
}