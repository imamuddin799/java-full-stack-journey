package arrays_10;

public class Fibonacci06 {

	public static boolean isFibonacci(int n) {
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

	public static int[] fib(int a[]) {
		int occ[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			if (isFibonacci(a[i])) {
				occ[i] = 1;
			}
		}
		return occ;
	}

	public static void main(String[] args) {
		int a[] = { 8, 7, 3, 5, 6, 1, 2, 9, 13 };
		int fibArray[] = fib(a);
		if (fibArray.length != 0) {
			for (int i : fibArray) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("The array has not a fib element");
		}
	}
}
