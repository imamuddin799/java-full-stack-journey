package strings_11.dec_04_04;

public class StartWithConsonants01 {

//	public static boolean isConsonant(String s) {
//	String vow = "aeiouAEIOU";
//	if(vow.contains(s)) return false;
//	else return true;
//}
//
//public static String upper(String s) {
//	String res = "";
//	for(int i = 0; i < s.length(); i++) {
//		if(i == s.length()-1) {
//			String up = s.charAt(i)+"";
//			res += up.toUpperCase(); 
//		}
//		else {
//			res += s.charAt(i);
//		}
//	}
//	return res;
//}
//
//public static void main(String[] args) {
//	String s = "This is a java mock";
//	String s1[] = s.split(" ");
//	String res = "";
//	for(int i = 0; i < s1.length; i++) {
//		char ch = s1[i].charAt(0);
//		if(isConsonant(ch+"")) {
//			res += upper(s1[i]) + " ";
//		}
//		else {
//			res += s1[i] + " ";
//		}
//	}
//	System.out.println(res);	
//}

	public static void main(String[] args) {
		String s = "This is a java mock";
		String s1[] = s.split(" ");
		String v = "aeiouAEIOU";
		String res = "";
		for (String s2 : s1) {
			char ch = s2.charAt(0);
			int l = s2.length();
			if (!v.contains(ch + "")) {
				res = res + s2.substring(0, l - 1) + (s2.charAt(l - 1) + "").toUpperCase() + " ";
			} else {
				res += s2 + " ";
			}
		}
		System.out.println(res);
	}
}
