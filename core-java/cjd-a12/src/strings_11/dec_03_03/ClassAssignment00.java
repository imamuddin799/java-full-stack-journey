package strings_11.dec_03_03;

public class ClassAssignment00 {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "abcdefgh";

		// 1. acegbdfh
		String res = "";
		String s1 = "", s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				s1 += s.charAt(i);
			} else {
				s2 += s.charAt(i);
			}
		}
		res = s1 + s2;
		System.out.println(res);

		// 2. efghabcd
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() / 2) {
				s2 += s.charAt(i);
			} else {
				s1 += s.charAt(i);
			}
		}
		res = s1 + s2;
		System.out.println(res);

		// 3. cdfhabeg
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (isPrime(i)) {
				s1 += s.charAt(i);
			} else {
				s2 += s.charAt(i);
			}
		}
		res = s1 + s2;
		System.out.println(res);

		// 4. dcbahgfe
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() / 2) {
				s1 = s.charAt(i) + s1;
			} else {
				s2 = s.charAt(i) + s2;
			}
		}
		res = s1 + s2;
		System.out.println(res);

		// 5. hgfe
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = s.length() / 2; i < s.length(); i++) {
			res = s.charAt(i) + res;
		}
		System.out.println(res);

		// 6. hgfeabcd
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() / 2) {
				s1 += s.charAt(i);
			} else {
				s2 = s.charAt(i) + s2;
			}
		}
		res = s2 + s1;
		System.out.println(res);

		// 7. ahbgcfed
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			res = res + s.charAt(i) + s.charAt(j);
		}
		System.out.println(res);

		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (i < s.length() / 2 - 1)
				res = res + s.charAt(i) + s.charAt(j);
			else
				res = res + s.charAt(j) + s.charAt(i);
		}
		System.out.println(res);

		// 8.
		s = "abcdefgh";
		res = "";
		s1 = "";
		s2 = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				s1 += s.charAt(i);
			} else {
				s2 += s.charAt(i);
			}
		}
		res = s1 + s2;
		System.out.println(res);
	}
}
