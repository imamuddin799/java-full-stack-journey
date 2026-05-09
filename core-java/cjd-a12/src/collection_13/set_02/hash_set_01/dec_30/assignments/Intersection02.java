package collection_13.set_02.hash_set_01.dec_30.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Intersection02 {

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
		s.retainAll(al2);
		System.out.println(s);

		Set s2 = new HashSet();
		s2.addAll(al2);
		s2.retainAll(al);
		System.out.println(s2);
	}
}