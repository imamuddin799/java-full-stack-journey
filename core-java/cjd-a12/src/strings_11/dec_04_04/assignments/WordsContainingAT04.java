package strings_11.dec_04_04.assignments;

public class WordsContainingAT04 {

	public static void main(String[] args) {
		String s = "art great meat get sat attribute";
		String s1[] = s.split(" ");
		String s2 = "at";
		String res = "";
		for (String s3 : s1) {
			if (s3.contains(s2)) {
				res += (s3.charAt(0) + "").toUpperCase() + s3.substring(1, s3.length()) + " ";
			} else {
				res += s3 + " ";
			}
		}
		System.out.println(res);
	}
}
