package methods_03.oct_08;

public class AlternatePrime02 {

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
		int n = 50;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (prime(i)) {
				count++;
				if (count % 2 == 1)
					System.out.println(i);
			}
		}
	}
}
