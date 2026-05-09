package collection_13.list_01.arraylist_01.dec_19.assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveAlternate02 {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(7);
		System.out.println(al);
		Iterator itr = al.iterator();
		int count = 0;
		while (itr.hasNext()) {
			count++;
			if (count % 2 == 0) {
				itr.next();
				itr.remove();
			} else {
				itr.next();
			}
		}
		System.out.println(al);
	}
}
