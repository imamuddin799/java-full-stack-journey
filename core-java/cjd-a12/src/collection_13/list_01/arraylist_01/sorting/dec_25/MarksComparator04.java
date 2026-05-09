package collection_13.list_01.arraylist_01.sorting.dec_25;

import java.util.Comparator;

public class MarksComparator04 implements Comparator<Student01> {

	public int compare(Student01 o1, Student01 o2) {
		if (o1.marks > o2.marks)
			return -1;
		if (o1.marks < o2.marks)
			return 1;
		return 0;
	}
}