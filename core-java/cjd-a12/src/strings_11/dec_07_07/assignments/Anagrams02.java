package strings_11.dec_07_07.assignments;

public class Anagrams02 {

	public static String sort(char[] ch) {
		for (int i = 1; i < ch.length; i++) {
			char c = ch[i - 1];
			int min = i - 1;
			for (int j = i; j < ch.length; j++) {
				if (ch[j] < c) {
					c = ch[j];
					min = j;
				}
			}
			char t = ch[i - 1];
			ch[i - 1] = ch[min];
			ch[min] = t;

		}
//		System.out.println(Arrays.toString(ch));
		String s1 = new String(ch);
		return s1;
	}

	public static void main(String[] args) {
		String s1 = "listen";
		String s2 = "silent";
		if (s1.length() == s2.length()) {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			String s3 = sort(c1);
			String s4 = sort(c2);

			if (s3.equals(s4)) {
				System.out.println("The given string s1 " + s1 + " and s2 " + s2 + " is [Anagram]");
			} else {
				System.out.println("The given string s1 " + s1 + " and s2 " + s2 + " is [not Anagram]");
			}
		} else {
			System.out.println("The given string s1 " + s1 + " and s2 " + s2 + " is [not Anagram]");
		}
	}
}
