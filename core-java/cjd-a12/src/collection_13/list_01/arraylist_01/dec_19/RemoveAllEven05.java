package collection_13.list_01.arraylist_01.dec_19;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllEven05 {
	public static void main(String[] arhs) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 != 0) {
				list.remove(i);
			}
		}
		System.out.println(list);
	}
}