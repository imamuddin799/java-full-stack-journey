package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Prime {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check prime or not : ");
		int n = sc.nextInt();
		if (isPrime(n))
			System.out.println("\nThe given number is a prime number");
		else
			System.out.println("\nThe given number is not a prime number");
	}
}