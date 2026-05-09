package java_important_questions_with_answers_17.recursion;

import java.util.Scanner;

public class Prime {

	public static boolean isPrime(int n, int i) {
		if (n < 2)
			return false;
		if (i > n / 2)
			return true;
		if (n % i == 0)
			return false;
		return isPrime(n, ++i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check given number is prime or not : ");
		int n = sc.nextInt();
		if (isPrime(n, 2))
			System.out.println("Given number is Prime");
		else
			System.out.println("Given number is not Prime");
	}
}