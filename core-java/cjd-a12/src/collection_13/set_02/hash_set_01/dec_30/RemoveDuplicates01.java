package collection_13.set_02.hash_set_01.dec_30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RemoveDuplicates01 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(true);
		al.add('$');
		al.add(null);
		al.add("Hi");
		al.add(98.4);
		al.add(10);
		al.add(null);
		al.add(true);
		al.add('$');

		Set s = new HashSet(al);
		System.out.println(al);
		System.out.println(s);
		System.out.println();

		Set s1 = new HashSet();
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			s1.add(itr.next());
		}
		System.out.println(al);
		System.out.println(s1);
		System.out.println();

		Set s2 = new HashSet();
		s2.addAll(al);
		System.out.println(al);
		System.out.println(s2);
	}
}