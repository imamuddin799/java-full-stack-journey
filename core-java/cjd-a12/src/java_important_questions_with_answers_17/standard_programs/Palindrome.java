package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Palindrome {

	public static boolean isPalindrome(long n) {
		long res = 0, temp = n;
		while (n != 0) {
			long r = n % 10;
			res = res * 10 + (int) r;
			n /= 10;
		}
		if (temp == res)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check palindrome or not : ");
		long num = sc.nextLong();
		if (isPalindrome(num))
			System.out.println("\nThe given number is a palindrome number");
		else
			System.out.println("\nThe given number is not a palindrome number");
	}
}