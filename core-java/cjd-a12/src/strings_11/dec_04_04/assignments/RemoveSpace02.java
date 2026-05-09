package strings_11.dec_04_04.assignments;

public class RemoveSpace02 {

//	public static void main(String[] args) {
//	String s = "ab cd e f k";
//	String res = "";
//	for(int i = 0; i < s.length(); i++) {
//		char ch = s.charAt(i);
//		if(!(ch+"").equals(" ")) {
//			res += ch+"";
//		}
//	}
//	System.out.println(res);
//}

	public static void main(String[] args) {

		String s = "ab hsb jsh js d";
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch != ' ') {
				res += ch;
			}
		}
		System.out.println(res);
	}
}
