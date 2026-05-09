package strings_11.dec_06_06;

import java.util.Arrays;

public class ArrangeString02 {

	public static void main(String[] args) {
		String s = "HTML5 CSS3 Java1 Python4 C2";
		String s1[] = s.split(" ");
		String sr[] = new String[s1.length];
		for (String s2 : s1) {
			int l = s2.length();
			int n = Integer.parseInt(s2.charAt(l - 1) + "");
			sr[n - 1] = s2.substring(0, l - 1);
		}
		System.out.println(Arrays.toString(sr));
	}
}
