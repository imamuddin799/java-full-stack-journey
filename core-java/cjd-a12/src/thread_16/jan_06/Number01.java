package thread_16.jan_06;

public class Number01 {

	public int fact(int n) {
		int fact = 1;
		for (int i = n; i >= 1; i--) {
			fact *= i;
		}
		return fact;
	}

	public boolean isStrong(int n) {
		int sum = 0;
		int on = n;
		while (n != 0) {
			int r = n % 10;
			sum += fact(r);
			n /= 10;
		}
		return sum == on;
	}

	public boolean isArmStrong(int n) {
		int sum = 0;
		int on = n;
		while (n != 0) {
			int r = n % 10;
			sum += r * r * r;
			n /= 10;
		}
		return sum == on;
	}
}
