package map_15.hashmap_01.jan04;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class IterateMaps03 {

	public static void main(String[] args) {
		TreeMap<Integer, String> hm = new TreeMap<Integer, String>();
		hm.put(420, "Rajkumar");
		hm.put(220, "Pavan Sai");
		hm.put(110, "Hari");
		hm.put(520, "Keerthi");
		hm.put(407, "Roja");
		hm.put(207, "Tejasree");

		System.out.println(hm);

		Set<Integer> keys = hm.keySet();
		for (int k : keys)
			System.out.println(k + " -> " + hm.get(k));

		System.out.println("****************************");

		Iterator<Integer> itr = keys.iterator();
		while (itr.hasNext()) {
			int i = itr.next();
			System.out.println(i + " : " + hm.get(i));
		}

		System.out.println("******************************");
		Collection<String> values = hm.values();
		for (String s : values) {
			System.out.print(s + "  ");
		}
		System.out.println("\n******************************");
		Iterator<String> itr2 = values.iterator();
		while (itr2.hasNext()) {
			System.out.print(itr2.next() + "  ");
		}
		System.out.println("\n*****************");
		Set entries = hm.entrySet();
		for (Object o : entries) {
			System.out.println(o);
		}
		System.out.println("\n********************");
		Iterator itr3 = entries.iterator();
		while (itr3.hasNext())
			System.out.println(itr3.next());

		System.out.println("\n********************");
		Set<Entry<Integer, String>> entries2 = hm.entrySet();
		for (Entry<Integer, String> e : entries2)
			System.out.println(e);
		System.out.println("\n**********************");
		for (Entry<Integer, String> e : entries2)
			System.out.println(e.getKey() + " " + e.getValue());

		System.out.println("\n*******************************");
		Iterator<Entry<Integer, String>> itr4 = entries2.iterator();
		while (itr4.hasNext()) {
			System.out.println(itr4.next());
		}

		System.out.println("\n*********************");
		Iterator<Entry<Integer, String>> itr5 = entries2.iterator();
		while (itr5.hasNext()) {
			Entry<Integer, String> entry = itr5.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}