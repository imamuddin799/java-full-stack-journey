package recursion_07.oct_21.assignments;

import java.util.Scanner;

public class SumOfDigits04 {

	public static long sumOfDigits(long n) {
		if (n != 0) {
			return n % 10 + sumOfDigits(n / 10);
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find sum of digits : ");
		long n = sc.nextLong();
		System.out.println("The sum of digits present in the given number " + n + " is : " + sumOfDigits(n));
		sc.close();
	}
}
