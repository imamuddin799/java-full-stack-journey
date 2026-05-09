package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class StrongMtoN {

	public static int factorial(int n) {
		if (n != 0) {
			int factorial = 1;
			for (int i = 2; i <= n; i++) {
				factorial *= i;
			}
			return factorial;
		} else
			return 1;
	}

	public static long sum(long n) {
		long sum = 0;
		if (n != 0) {
			while (n != 0) {
				long r = n % 10;
				sum += factorial((int) r);
				n /= 10;
			}
			return sum;
		} else
			return factorial((int) n);
	}

	public static boolean isStrong(long n) {
		return sum(n) == n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a range to find strong numbers : ");
		System.out.print("Enter starting range : ");
		long m = sc.nextLong();
		System.out.print("Enter ending range : ");
		long n = sc.nextLong();
		for (long i = m; i <= n; i++) {
			if (isStrong(i)) {
				System.out.println(i);
			}
		}
	}
}
