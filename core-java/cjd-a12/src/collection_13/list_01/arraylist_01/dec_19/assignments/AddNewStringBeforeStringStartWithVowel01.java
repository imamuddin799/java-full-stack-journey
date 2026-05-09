package collection_13.list_01.arraylist_01.dec_19.assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddNewStringBeforeStringStartWithVowel01 {

	public static void main(String[] args) {
//		List<String> al = new ArrayList<String>();
//		al.add("India");
//		al.add("Pakistan");
//		al.add("America");
//		al.add("Alabama");
//		al.add("Canada");
//		System.out.println(al);
//		List<String> temp = new ArrayList<String>();
//		System.out.println(temp);
////		for(int i = 0; i < al.size(); i++) {
////			String s = al.get(i);
////			String v = "aeiouAEIOU";
////			if(v.contains(s.charAt(0)+"")) {
////				char ch = s.charAt(0);
////				ch++;
////				String s1 = ch + s.substring(1);
////				temp.add(s1);
////				temp.add(s);
////			}
////			else {
////				temp.add(s);
////			}
////		}
//		
//		Iterator itr = al.iterator();
//		while(itr.hasNext()) {
//			String s = (String) itr.next();
//			String v = "aeiouAEIOU";
//			if(v.contains(s.charAt(0)+"")) {
//				char ch = s.charAt(0);
//				ch++;
//				String s1 = ch + s.substring(1);
//				temp.add(s1);
//				temp.add(s);
//			}
//			else {
//				temp.add(s);
//			}
//		}
//		System.out.println(temp);
//		al = temp;
//		System.out.println(al);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String s = sc.nextLine();
		String s1[] = s.split(" ");
		ArrayList<String> al = new ArrayList<String>();

		for (String s2 : s1)
			al.add(s2);
		String vowel = "aeiouAEIOU";
		for (int i = 0; i < al.size(); i++) {
			String s2 = al.get(i);
			char ch = s2.charAt(0);
			if (vowel.contains(ch + "")) {
				ch++;
				String k = ch + s2.substring(1);
				al.add(i, k);
				i++;
			}
		}
		System.out.println(al);
	}
}