package collection_13.list_01.arraylist_01.dec_19;

import java.util.ArrayList;
import java.util.List;

public class DistinctObject03 {
	public static void main(String[] arhs) {
		List list = new ArrayList();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add("Imamuddin Ansari");
		list.add(6);
		list.add("Imamuddin Ansari");
		list.add(2);
		list.add(2);
		System.out.println(list);
		List distinctObject = new ArrayList(list.size());
		for (int i = 0; i < list.size(); i++) {
			if (!distinctObject.contains(list.get(i))) {
				distinctObject.add(list.get(i));
			}
		}
		System.out.println(distinctObject);
	}
}