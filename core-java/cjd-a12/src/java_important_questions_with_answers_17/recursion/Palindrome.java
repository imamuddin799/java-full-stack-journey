package java_important_questions_with_answers_17.recursion;

import java.util.Scanner;

public class Palindrome {

	public static long reverse(long n, long rev) {
		if (n != 0) {
			int r = (int) (n % 10);
			rev = rev * 10 + r;
			return reverse(n / 10, rev);
		}
		return rev;
	}

	public static long rev(long n) {
		// System.out.println(reverse(n, 0));
		return reverse(n, 0);
	}

	public static boolean isPalindrome(long n) {
		return rev(n) == n;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a to check palindrome or not : ");
		long n = sc.nextLong();
		if (isPalindrome(n)) {
			System.out.println("\nThe given number is palindrome");
		} else {
			System.out.println("\nThe given number is not palindrome");
		}
	}
}