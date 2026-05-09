package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class PalindromeOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Check Palindrome or Not : ");
		long n = sc.nextLong(), sum = 0;
		long t = n, reverse = 0;
		while (n != 0) {
			long remainder = n % 10;
			reverse = reverse * 10 + remainder;
			n /= 10;
		}
		if (reverse == t)
			System.out.println("Given Numbers " + t + " is a Palindrome Number");
		else
			System.out.println("Given Numbers " + t + " is not a Palindrome Number");
	}
}