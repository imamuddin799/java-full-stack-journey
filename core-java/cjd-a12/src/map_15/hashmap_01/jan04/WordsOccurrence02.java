package map_15.hashmap_01.jan04;

import java.util.HashMap;

public class WordsOccurrence02 {

	public static void main(String[] args) {
		String s = "this is a class and this class is for java";
		String[] s1 = s.split(" ");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (String s2 : s1) {
			if (hm.containsKey(s2)) {
				hm.replace(s2, hm.get(s2) + 1);
			} else {
				hm.put(s2, 1);
			}
		}
		System.out.println(hm);
	}
}