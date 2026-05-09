package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Fibonacci {

	public static void fibonacciOfN(int n) {
		int a = 0, b = 1, c = a + b;
		for (int i = 1; i <= n; i++) {
			System.out.print(a + "\t");
			a = b;
			b = c;
			c = a + b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of fibonacci series to display : ");
		int n = sc.nextInt();
		fibonacciOfN(n);
	}
}