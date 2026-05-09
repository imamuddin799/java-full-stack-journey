package java_important_questions_with_answers_17.recursion;

import java.util.Scanner;

public class Factorial {
	public static int factorial(int n) {
		if (n != 0) {
			return n * factorial(n - 1);
		} else
			return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find its factorial : ");
		int n = sc.nextInt();
		int fact = factorial(n);
		System.out.println("\nThe factorial of given number is : " + fact);
	}
}