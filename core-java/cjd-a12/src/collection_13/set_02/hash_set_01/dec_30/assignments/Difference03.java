package collection_13.set_02.hash_set_01.dec_30.assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Difference03 {

	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		al.add(40);
		al.add(30);
		al.add(20);
		al.add(10);
		al.add("Imamuddin");

		ArrayList<Object> al2 = new ArrayList<Object>();
		al2.add(60);
		al2.add(70);
		al2.add(80);
		al2.add(90);
		al2.add(50);
		al2.add(30);
		al2.add(10);
		al2.add("Imamuddin");

		Set s = new HashSet();
		s.addAll(al);
		s.removeAll(al2);
		System.out.println(s); // [20, 40]

//		Set s = new HashSet();
//		s.addAll(al);
//		s.retainAll(al2);
//		System.out.println(s);
//
//		Set s2 = new HashSet();
//		s2.addAll(al2);
//		s2.addAll(al);
//		s2.removeAll(s);
//		System.out.println(s2);
//
//		Set s3 = new HashSet();
//		s3.addAll(al);
//		Iterator itr = al2.iterator();
//		while (itr.hasNext()) {
//			Object o = itr.next();
//			if (s3.contains(o)) {
//				s3.remove(o);
//			} else {
//				s3.add(o);
//			}
//		}
//		System.out.println(s3);
	}
}