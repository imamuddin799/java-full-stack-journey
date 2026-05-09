package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class ProductOfDigitsOddOrEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Check Product of Digits is Odd or Even : ");
		long n = sc.nextLong(), product = 1, t = n;
		while (n != 0) {
			long remainder = n % 10;
			product *= remainder;
			n /= 10;
		}
		if (product % 2 == 0)
			System.out.println("Poduct of Digits of Given Number " + t + " is Even");
		else
			System.out.println("Product of Digits of Given Number " + t + " is Odd");
	}
}