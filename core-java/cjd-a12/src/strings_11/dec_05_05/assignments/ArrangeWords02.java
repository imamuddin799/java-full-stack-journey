package strings_11.dec_05_05.assignments;

public class ArrangeWords02 {

	public static void main(String[] args) {
		String s = "HTML5 CSS3 Java1 Python4 C2";
		String s1[] = s.split(" ");
		String s2[] = new String[s1.length];
		String res = "";
		for (String s3 : s1) {
			char ch = s3.charAt(s3.length() - 1);
			ch -= 1;
			s2[Integer.parseInt(ch + "")] = s3;
		}
		for (String s3 : s2) {
			res += s3.substring(0, s3.length() - 1) + " ";
		}
		System.out.println(res);
	}
}
