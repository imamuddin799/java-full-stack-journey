package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Strong {

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

	public static int sum(int n) {
		int sum = 0;
		if (n != 0) {
			while (n != 0) {
				int r = n % 10;
				sum += factorial(r);
				n /= 10;
			}
			return sum;
		} else
			return factorial(n);
	}

	public static boolean isStrong(int n) {
		if (sum(n) == n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check strong or not : ");
		int n = sc.nextInt();
		if (isStrong(n))
			System.out.println("\nThe given number is a Strong number");
		else
			System.out.println("\nThe given number is not a Strong number");
	}
}