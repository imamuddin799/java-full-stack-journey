package java_important_questions_with_answers_17.loops;

import java.util.Scanner;

public class SumOfDivisibleBy5MToN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any range of numbers to find sum of numbers divisible by 5");
		System.out.print("Enter First Number : ");
		int m = sc.nextInt();
		System.out.print("Enter Second Number : ");
		int n = sc.nextInt();
		int min = m < n ? m : n;
		int max = m > n ? m : n;
		int sum = 0;
		for (int i = min; i <= max; i++) {
			if (i % 5 == 0) {
				sum += i;
				i += 4;
			}
		}
		System.out.print("The Sum of Numbers Divisible by 5 between " + m + " and " + n + " is : " + sum);
	}
}