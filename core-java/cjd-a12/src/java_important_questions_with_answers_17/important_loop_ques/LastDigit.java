package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class LastDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Print Last Digits : ");
		long n = sc.nextLong();
		System.out.print("Printing Last Digits for the given number " + n + " is : ");
		long remainder = n % 10;
		System.out.println(remainder);
	}
}