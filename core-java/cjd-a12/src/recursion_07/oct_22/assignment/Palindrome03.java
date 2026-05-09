package recursion_07.oct_22.assignment;

import java.util.Scanner;

public class Palindrome03 {

	public static long rev(long n, long rev) {
		if (n != 0) {
			rev = rev * 10 + (n % 10);
			return rev(n / 10, rev);
		}
		return rev;
	}

	public static long reverse(long n) {
		return rev(n, 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check given number is a Palindrome number or not : ");
		long n = sc.nextLong();
		long rev = reverse(n);
		if (n == rev) {
			System.out.println("Given Number " + n + " is a Palindrome number.");
		} else {
			System.out.println("Given Number " + n + " is not a Palindrome number.");
		}
		sc.close();
	}
}
