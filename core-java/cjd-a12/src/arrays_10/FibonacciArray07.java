package arrays_10;

public class FibonacciArray07 {

	public static void main(String[] args) {
		int a[] = { 5, 7, 3, 6, 2, 8, 11, 13, 0, 4 };
		int c = 0;
		for (int i : a) {
			if (fib(i))
				c++;
		}
		int fib[] = new int[c];
		int j = 0;
		for (int i : a) {
			if (fib(i))
				fib[j++] = i;
		}
		for (int i : fib) {
			System.out.println(i);
		}
	}

	public static boolean fib(int n) {
		int a = 0, b = 1, c = a + b;
		while (a <= n) {
			if (a == n)
				return true;
			a = b;
			b = c;
			c = a + b;
		}
		return false;
	}
}
