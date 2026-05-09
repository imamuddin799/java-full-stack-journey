package strings_11.dec_04_04.assignments;

public class PreviousCharNTime03 {

//	public static void main(String[] args) {
//	String s = "a3b2c2";
//	String res = "";
//	String num = "0123456789";
//	for(int i = 1; i < s.length(); i++) {
//		String previous = s.charAt(i-1)+"";
//		String currentString = s.charAt(i)+"";
//		if(num.contains(currentString)) {
//			for
//		}
//	}
//}

	public static void main(String[] args) {
		String s = "a3b2c2";
		String res = "";
		for (int i = 1; i < s.length(); i += 2) {
			char previous = s.charAt(i - 1);
			char current = s.charAt(i);
			for (char c = '1'; c <= current; c++) {
				res += previous;
			}
		}
		System.out.println(res);
	}
}
