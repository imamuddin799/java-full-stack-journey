package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Factorial {

	public static long factorial(int n) {
		if (n != 0) {
			long factorial = 1;
			for (int i = 2; i <= n; i++) {
				factorial *= i;
			}
			return factorial;
		} else
			return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find factorial : ");
		int n = sc.nextInt();
		long factorial = factorial(n);
		System.out.println("\nThe factorial is : " + factorial);
		sc.close();
	}
}