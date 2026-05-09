package strings_11.dec_03_03;

public class PrimeAndNonPrime07 {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static String PNP(String s) {
		String prime = "", nonPrime = "";
		for (int i = 0; i < s.length(); i++) {
			if (isPrime(i)) {
				prime += s.charAt(i);
			} else {
				nonPrime += s.charAt(i);
			}
		}
		return prime + nonPrime;
	}

	public static void main(String[] args) {
		String s = "abcdefgh";
		System.out.println(PNP(s));
	}
}
