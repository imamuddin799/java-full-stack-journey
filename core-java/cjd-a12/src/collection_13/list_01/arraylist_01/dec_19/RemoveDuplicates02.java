package collection_13.list_01.arraylist_01.dec_19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicates02 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
//        list.add("Imamuddin Ansari");
		list.add(6);
//        list.add("Imamuddin Ansari");
		list.add(2);
		list.add(2);
		list.add(4);
		list.add(7);
		list.add(4);
		list.add(3);
		list.add(4);
		list.add(9);
		list.add(1);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			int c = 0, v = list.get(i);
			Iterator<Integer> itr = list.iterator();
			while (itr.hasNext()) {
				int k = itr.next();
				if (v == k) {
					c++;
					if (c > 1) {
						itr.remove();
					}
				}
			}
		}
		System.out.println(list);
	}
}