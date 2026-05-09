package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class PerfectSquare {

	public static boolean isPerfectSquare(int n) {
		for (int i = 1; i * i <= n; i++) {
			if (i * i == n)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check perfect square or not : ");
		int n = sc.nextInt();
		if (isPerfectSquare(n))
			System.out.println("\nThe given number is a perfect square");
		else
			System.out.println("\nThe given number is not a perfect square");
	}
}