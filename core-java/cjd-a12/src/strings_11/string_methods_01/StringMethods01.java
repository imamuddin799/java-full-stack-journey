package strings_11.string_methods_01;

//import java.lang.reflect.Array;

//import java.util.Arrays;
//
//public class StringMethods {
//
//	public static void main(String[] args) {
//		String s = "this is his class";
//		System.out.println(s.length());//17
//		System.out.println(s.charAt(3));//s
////		System.out.println(s.charAt(98));
////		StringIndexOutOfBoundsException
//		
//		System.out.println(s.indexOf('s'));//3
//		System.out.println(s.indexOf("is"));//2
//		System.out.println(s.indexOf('s', 7));//10
//		System.out.println(s.indexOf("is", 5));//5
//		
//		System.out.println(s.lastIndexOf('s'));//16
//		System.out.println(s.lastIndexOf("is"));//9
//		
//		System.out.println(s.substring(5,9));//is h
//		
//		String s1 = "     world       of           java          ";
//		System.out.println(s1.trim());
////		world       of           java
//		
//		String s2 = "jalsdfjMMmNkjnj";
//		System.out.println(s2.toUpperCase());
////		JALSDFJMMMNKJNJ
//		System.out.println(s2.toLowerCase());
////		jalsdfjmmmnkjnj
//		
//		String s3 = "Hi";
//		String s4 = "hi";
//		String s5 = "Hi";
//		String s6 = "Hey";
//		String s7 = new String("hi");
//		String s8 = new String("Hi");
//		String s9 = new String("Hey");
//		String s10 = new String("Hi");
//		
//		System.out.println(s3==s5);
//		System.out.println(s8==s10);
//		System.out.println(s3.equals(s5));
//		System.out.println(s8.equals(s10));
//		System.out.println(s3.equals(s10));
//		System.out.println(s3.equalsIgnoreCase(s4));
//		
//		s=s.replace('s', '$');
//		System.out.println(s);
//		
//		s=s.replaceAll("is", "hi");
//		System.out.println(s);
//		
//		s3 = s3.concat(" bye");
//		System.out.println(s3);
//		s ="this is his class";
//		System.out.println(s.startsWith("th"));
//		System.out.println(s.endsWith("class"));
//		
//		s="Hello";
//		System.out.println(s.toCharArray());
//		
//		s="This is his class";
////		System.out.println(s.split(" "));
////		System.out.println(s.split("is"));
////		System.out.println(s.split(""));
//		
//		System.out.println(Arrays.toString(s.split(" ")));
//	}
//}

import java.util.Arrays;

public class StringMethods01 {

	public static void main(String[] args) {

		String s = "this is his class";
		System.out.println(s.length()); // 17
		System.out.println(s.charAt(3)); // s
		// System.out.println(s.charAt(98)); //
		// java.lang.StringIndexOutOfBoundsException:

		System.out.println();

		System.out.println(s.indexOf('s')); // 3
		System.out.println(s.indexOf("is")); // 2
		System.out.println(s.indexOf('s', 7)); // 10
		System.out.println(s.indexOf("is", 5)); // 5

		System.out.println();

		System.out.println(s.lastIndexOf('s')); // 16
		System.out.println(s.lastIndexOf("is")); // 9

		System.out.println();

		System.out.println(s.contains("is")); // true

		System.out.println();

		System.out.println(s.substring(5, 9));// is h
		System.out.println(s.substring(10));// s classs
		// System.out.println(s.substring(20)); // StringIndexOutOfBoundsException

		System.out.println();

		String s1 = "    world,  of    java    ";
		System.out.println(s1.trim()); // world, of java

		System.out.println();

		String s2 = "jhNJnjNjNJ";
		System.out.println(s2.toUpperCase()); // JHNJNJNJNJ
		System.out.println(s2.toLowerCase()); // jhnjnjnjnj

		System.out.println();

		String s3 = "Hi";
		String s4 = "hi";
		String s5 = "Hi";
		String s6 = "hey";
//      String s7 = new String("hi");
		String s8 = new String("Hi");
//      String s9 = new String("Hey");
		String s10 = new String("Hi");
		System.out.println(s3 == s5); // true
		System.out.println(s8 == s10); // false
		System.out.println(s3.equals(s5)); // true
		System.out.println(s8.equals(s10)); // true
		System.out.println(s3.equals(s10)); // true
		System.out.println(s3.equals(s5)); // true
		System.out.println(s3.equalsIgnoreCase(s4)); // true

		System.out.println();

		System.out.println(s3.compareTo(s4)); // -32
		System.out.println(s3.compareTo(s6)); // -32
		System.out.println(s3.compareTo(s5)); // 0
		System.out.println(s3.compareToIgnoreCase(s4)); // 0

		System.out.println();

		s = s.replace('s', '$');
		System.out.println(s); // thi$ i$ hi$ cla$$

		System.out.println();

		s = s.replaceAll("is", "hi");
		System.out.println(s); // thi$ i$ hi$ cla$$

		s3 = s3.concat(" bye");
		System.out.println(s3);// hi bye

		System.out.println();

		s = "this is his class";
		System.out.println(s.startsWith("th")); // true
		System.out.println(s.endsWith("class")); // true

		System.out.println();

		System.out.println(s.toCharArray());
		String s11[] = s.split(" ");
		System.out.println(Arrays.toString(s11));

	}
}