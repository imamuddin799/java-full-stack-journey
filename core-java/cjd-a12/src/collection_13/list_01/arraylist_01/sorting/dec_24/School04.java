package collection_13.list_01.arraylist_01.sorting.dec_24;

import java.util.ArrayList;
import java.util.Collections;

public class School04 {

	public static void main(String[] args) {
//		ArrayList<Students03> s = new ArrayList<Students03>();
//		s.add(new Students03(1, "ABC", 50));
//		s.add(new Students03(2, "DEF", 55));
//		s.add(new Students03(3, "GHI", 70));
//		s.add(new Students03(4, "MNO", 90));
//		s.add(new Students03(5, "PQR", 40));
//		s.add(new Students03(6, "RST", 80));
//		s.add(new Students03(7, "XYZ", 65));
//		
//		System.out.println(s);
//		Collections.sort(s);
//		System.out.println(s);
//		
//		int rank = 1;
//		for(Students03 s1 : s) {
//			s1.rank = rank++;
//		}
//		System.out.println(s);

		ArrayList<Students03> s = new ArrayList<Students03>();
		s.add(new Students03(420, "Imamuddin", 55));
		s.add(new Students03(220, "Raj Kumar", 41));
		s.add(new Students03(407, "Hari", 97));
		s.add(new Students03(107, "Nikithia", 61));
		s.add(new Students03(144, "Akhila", 50));
		s.add(new Students03(421, "Vasantha", 99));
		s.add(new Students03(221, "Jhansi", 100));

		System.out.println(s);
		Collections.sort(s);

		int rank = 1;
		for (Students03 s1 : s) {
			s1.rank = rank++;
		}
		System.out.println(s);
	}
}