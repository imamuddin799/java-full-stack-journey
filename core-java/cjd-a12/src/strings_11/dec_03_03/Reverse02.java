package strings_11.dec_03_03;

public class Reverse02 {

	public static void main(String[] args) {
		String s = "Hello";
		String rev = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);

		rev = "";
		for (int i = 0; i < s.length(); i++) {
			rev = s.charAt(i) + rev;
		}
		System.out.println(rev);
	}
}
