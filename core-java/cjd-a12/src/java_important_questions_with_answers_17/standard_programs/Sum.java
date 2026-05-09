package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Sum {

	public static int sum(long n) {
		int sum = 0;
		while (n != 0) {
			long r = n % 10;
			sum += (int) r;
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find sum of each digit : ");
		long num = sc.nextLong();
		int sum = sum(num);
		System.out.println("\nThe sum of each digit of the given number is : " + sum);
	}
}