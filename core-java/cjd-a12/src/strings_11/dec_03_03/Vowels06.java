package strings_11.dec_03_03;

public class Vowels06 {

	public static String vowel(String s) {
		String vowel = "", consonant = "";
		String vow = "aeiouAEIOU";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (vow.contains(ch + "")) {
				vowel += ch;
			} else {
				consonant += ch;
			}
		}
		return vowel + consonant;
	}

	public static void main(String[] args) {
		String s = "abcdefgh";
		System.out.println(vowel(s));
	}
}
