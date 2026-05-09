package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class DigitsVertically {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Print Digits Vertically : ");
		long n = sc.nextLong();// 46546
		long t = n, reverse = 0;
		while (n != 0) {
			long remainder = n % 10;
			reverse = reverse * 10 + remainder;
			n /= 10;
		}
		System.out.println("Printing Digits in Vertical for the given number " + t + " is : ");
		while (reverse != 0) {
			long remainder = reverse % 10;
			System.out.println(remainder);
			reverse /= 10;
		}
	}
}