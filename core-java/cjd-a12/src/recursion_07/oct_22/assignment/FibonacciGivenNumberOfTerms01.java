package recursion_07.oct_22.assignment;

import java.util.Scanner;

public class FibonacciGivenNumberOfTerms01 {

	public static long fib(long n, long a, long b, long c) {
		if (n != 0) {
			System.out.println(a);
			return fib(--n, a = b, b = c, c = a + b);
		}
		return 0;
	}

	public static void fibonacci(long n) {
		fib(n, 0, 1, 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of iteration of fibonacci : ");
		long n = sc.nextLong();
		fibonacci(n);
		sc.close();
	}
}
