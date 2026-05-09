package strings_11.dec_04_04.assignments;

public class DistinctChar01 {

	public static void main(String[] args) {
//		String s = "Helloworld";
//		String res = "";
//		for(int i = 0; i < s.length(); i++) {
//			if(!res.contains(s.charAt(i)+"")) {
//				res += s.charAt(i);
//			}
//		}
//		System.out.println(res);

		String s = "Helloworld";
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!res.contains(ch + "")) {
				res += ch;
			}
		}
		System.out.println(res);
	}
}
