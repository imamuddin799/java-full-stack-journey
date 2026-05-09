package strings_11.dec_06_06.assignments;

public class RemoveOccurrenceOfs2 {

//	String res = "";
//	if (s.length() >= r.length()) {
//		int rlen = r.length() - 1; //rlen -> length of the String to be replaced - 1
//		for (int i = 0; i <= s.length() - rlen; i++) {
//			String check = "";
//			String check2 = "";
//			for (int j = i; j < s.length(); j++) {
//				check += s.charAt(j);
//				if (check.equals(r)) {
//					res += rs;
//					i += rlen;
//					check2 = check;
//				}
//			}
//			if (!check2.equals(r))
//				res += s.charAt(i);
//		}
//		for (int i = s.length() - rlen + 1; i < s.length(); i++) {
//			res += s.charAt(i);
//		}
//		return res;
//	} else {
//		return s;
//	}
//
//}
//
//public static void main(String[] args) {
//	String s1 = "This is his bliss class";
//	String s2 = "is";
//	String rstr = "  ";
//	System.out.println(replace(s1, s2, rstr));
//}

	public static void main(String[] args) {
		String s = "This is his bliss class";
		String s2 = "is";
		String res = "";
		for (int i = 0; i < s.length();) {
			if (i <= s.length() - s2.length() && s.substring(i, i + s2.length()).equals(s2)) {
				i += s2.length();
			} else {
				res += s.charAt(i++);
			}
		}
		System.out.println("Result: " + res);
	}
}
