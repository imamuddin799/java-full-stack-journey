package map_15.treemap_02.jan04.assignments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class School02 {

	public static void main(String[] args) {
		ArrayList<Student01> al = new ArrayList<Student01>();
		al.add(new Student01(1, "Raj Kumar", 75));
		al.add(new Student01(220, "Pavan Sai", 78));
		al.add(new Student01(110, "Hari", 55));
		al.add(new Student01(520, "Keerthi", 65));
		al.add(new Student01(407, "Roja", 81));
		al.add(new Student01(207, "Tejasree", 45));
		al.add(new Student01(344, "Ashutosh", 85));
		al.add(new Student01(456, "Pravash", 61));
		al.add(new Student01(235, "Salman", 35));
		al.add(new Student01(459, "Amir", 63));
		al.add(new Student01(234, "Shahrukh Khan", 45));
		System.out.println(al);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the following");
		System.out.println("1:ID Ascending\n2:ID Descending");
		int op = sc.nextInt();
		Comparator<Integer> com = (o1,o2)-> o1-o2;
		switch(op) {
		case 2: com = (o1, o2) -> o2-o1;
		}
		
		TreeMap<Integer, Student01> tm = new TreeMap<Integer, Student01>(com);
		for(Student01 s : al) {
			tm.put(s.id, s);
		}
		
		Set<Entry<Integer, Student01>> entries = tm.entrySet();
		Iterator<Entry<Integer, Student01>> itr = entries.iterator();
		while (itr.hasNext()) {
			Entry<Integer, Student01> entry = itr.next();
			System.out.println(entry.getKey() +" -> "+ entry.getValue().toString().substring(1,entry.getValue().toString().length()-9));
		}
	}
}