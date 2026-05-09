package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class PrimeMtoN {

	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		for (long i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a range to find prime numbers : ");
		System.out.print("Enter starting range : ");
		long m = sc.nextLong();
		System.out.print("Enter ending range : ");
		long n = sc.nextLong();
		for (long i = m; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
}
