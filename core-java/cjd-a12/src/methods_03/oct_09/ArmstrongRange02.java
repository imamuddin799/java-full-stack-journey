package methods_03.oct_09;

public class ArmstrongRange02 {

	// DATE-09-10-2024

	public static boolean isArmstrong(int n) {
		int sum = 0, count = count(n), originalNumber = n;
		for (int i = 1; i <= count; i++) {
			int remainder = n % 10;
			sum += power(remainder, count);
			n /= 10;
		}
		return originalNumber == sum;
	}

	public static int power(int a, int b) {
		int power = 1;
		for (int i = 1; i <= b; i++) {
			power *= a;
		}
		return power;
	}

	public static int count(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		int m = 1, n = 100000000;
		for (int i = m; i <= n; i++) {
			if (isArmstrong(i))
				System.out.println(i);
		}
	}
}
