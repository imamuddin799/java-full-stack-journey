package map_15.hashmap_01.jan04;

import java.util.HashMap;

public class CharacterOccurrence01 {

	public static void main(String[] args) {
		String s = "Programming";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hm.containsKey(s.charAt(i)))
				hm.replace(s.charAt(i), hm.get(s.charAt(i)) + 1);
			else
				hm.put(s.charAt(i), 1);
		}
		System.out.println(hm);
	}
}