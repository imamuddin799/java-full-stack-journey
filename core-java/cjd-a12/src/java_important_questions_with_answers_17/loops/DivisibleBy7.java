package java_important_questions_with_answers_17.loops;

import java.util.Scanner;

public class DivisibleBy7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number to check that number is divisible by 7 or not : ");
		int n = sc.nextInt();
		if (n % 7 == 0)
			System.out.println("Given Number " + n + " is Divisible by 7");
		else
			System.out.println("Given Number " + n + " is not Divisible by 7");
	}
}