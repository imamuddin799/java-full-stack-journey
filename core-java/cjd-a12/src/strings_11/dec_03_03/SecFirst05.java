package strings_11.dec_03_03;

public class SecFirst05 {

	public static String secFirst(String s) {
		String f = "", sec = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() / 2)
				f += s.charAt(i);
			else
				sec = s.charAt(i) + sec;
		}
		return sec + f;
	}

	public static void main(String[] args) {
		String s = "abcdefgh";
		System.out.println(secFirst(s));
	}
}
