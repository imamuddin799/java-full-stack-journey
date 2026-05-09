package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Print Sum of Digits : ");
		long n = sc.nextLong(), sum = 0;
		System.out.print("Printing Sum of Digits for the given number " + n + " is : ");
		while (n != 0) {
			long remainder = n % 10;
			sum += remainder;
			n /= 10;
		}
		System.out.println(sum);
	}
}