package collection_13.list_01.arraylist_01.dec_20.assignment;

import java.util.ArrayList;
import java.util.List;

public class StringSorting01 {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
		al.add("India");
		al.add("Pakistan");
		al.add("America");
		al.add("Alabama");
		al.add("Canada");
		al.add("Indonesia");
		System.out.println(al);

		for (int i = 0; i < al.size() - 1; i++) {
			for (int j = i + 1; j < al.size(); j++) {
				if (al.get(i).compareTo(al.get(j)) > 0) {
					String s = al.get(i);
					al.set(i, al.get(j));
					al.set(j, s);
				}
			}
		}
		System.out.println(al);
	}
}