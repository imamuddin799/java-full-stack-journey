package collection_13.set_02.hash_set_01.dec_30.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Union01 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		al.add(40);
		al.add(30);
		al.add(20);
		al.add(10);

		ArrayList al2 = new ArrayList();
		al2.add(60);
		al2.add(70);
		al2.add(80);
		al2.add(90);
		al2.add(50);
		al2.add(30);
		al2.add(10);

		Set s = new HashSet();
		s.addAll(al);
		s.addAll(al2);
		System.out.println(al);
		System.out.println(al2);
		System.out.println(s);
	}
}