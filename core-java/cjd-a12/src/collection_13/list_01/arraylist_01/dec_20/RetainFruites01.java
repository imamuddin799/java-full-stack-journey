package collection_13.list_01.arraylist_01.dec_20;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RetainFruites01 {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		al.add("Mango");
		al.add("Orange");
		al.add("Banana");
		al.add("Tomato");
		al.add("Chilli");
		al.add("Apple");
		al.add("Guava");
		System.out.println(al);

		ListIterator<String> itr = al.listIterator();

		while (itr.hasNext()) {
			String s = itr.next();
			if (itr.nextIndex() == 1) {
				itr.add("Papaya");
			}
			if (s.equals("Tomato")) {
				itr.set("PineApple");
			}
			if (s.equals("Chilli")) {
				itr.remove();
			}
		}
		System.out.println(al);
	}
}