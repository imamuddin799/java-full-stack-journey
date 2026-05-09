package collection_13.list_01.arraylist_01.sorting.dec_25;

import java.util.Comparator;

public class IDComparator02 implements Comparator<Student01> {

	public int compare(Student01 o1, Student01 o2) {
		return o1.id - o2.id;
	}
}