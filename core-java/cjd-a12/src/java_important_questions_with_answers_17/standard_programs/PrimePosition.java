package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class PrimePosition {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void primePos(int n) {
		while (n != 0) {
			int r = n % 10;
			if (isPrime(r)) {
				System.out.println(r);
			}
			n /= 10;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to print prime digits present in it : ");
		int n = sc.nextInt();
		System.out.println("The prime digits present in it :");
		primePos(n);
	}
}