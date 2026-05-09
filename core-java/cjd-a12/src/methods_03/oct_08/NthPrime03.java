package methods_03.oct_08;

public class NthPrime03 {

	// DATE-08-10-2024

	public static boolean prime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int nthPrime = 10000;
		int i = 1;
		int c = 0;
		while (true) {
			if (prime(i)) {
				c++;
				if (c == nthPrime) {
					System.out.println(i);
					break;
				}
			}
			i++;
		}
	}
}
