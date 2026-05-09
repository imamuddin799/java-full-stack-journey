package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class FibonacciTillN {

	public static void fibonacciTillN(int n) {
		int a = 0, b = 1, c = a + b;
		while (a <= n) {
			System.out.print(a + "\t");
			a = b;
			b = c;
			c = a + b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number, till fibonacci series you want : ");
		int n = sc.nextInt();
		fibonacciTillN(n);
	}
}