package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class SumOfDigitsOddOrEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Check Sum of Digits is Odd or Even : ");
		long n = sc.nextLong(), sum = 0, t = n;
		while (n != 0) {
			long remainder = n % 10;
			sum += remainder;
			n /= 10;
		}
		if (sum % 2 == 0)
			System.out.println("Sum of Digits of Given Number " + t + " is Even");
		else
			System.out.println("Sum of Digits of Given Number " + t + " is Odd");
	}
}