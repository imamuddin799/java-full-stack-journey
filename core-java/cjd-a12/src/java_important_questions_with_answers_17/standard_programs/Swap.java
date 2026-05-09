package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Swap {
	public static void swap(int a, int b) {
		System.out.println("\nNumbers before swapping");
		System.out.println("First number : " + a);
		System.out.println("Second number : " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("\nNumbers after swapping");
		System.out.println("First number : " + a);
		System.out.println("Second number : " + b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any two numbers two swap");
		System.out.print("First number : ");
		int num1 = sc.nextInt();
		System.out.print("Second number : ");
		int num2 = sc.nextInt();
		swap(num1, num2);
	}
}