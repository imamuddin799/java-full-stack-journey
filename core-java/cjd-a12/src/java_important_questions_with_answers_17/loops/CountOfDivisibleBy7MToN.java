package java_important_questions_with_answers_17.loops;

import java.util.Scanner;

public class CountOfDivisibleBy7MToN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any range of numbers to check that how many numbers are divisible by 7");
		System.out.print("Enter First Number : ");
		int m = sc.nextInt();
		System.out.print("Enter Second Number : ");
		int n = sc.nextInt();
		int min = m < n ? m : n;
		int max = m > n ? m : n;
		int count = 0;
		for (int i = min; i <= max; i++) {
			if (i % 7 == 0) {
				count++;
				i += 6;
			}
		}
		System.out.print("The Count of Numbers Divisible by 7 between " + m + " and " + n + " is : " + count);
	}
}