package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Product {

	public static int product(long n) {
		int p = 1;
		while (n != 0) {
			long r = n % 10;
			p = p * (int) r;
			n /= 10;
		}
		return p;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find product of each digit : ");
		long num = sc.nextLong();
		int p = product(num);
		System.out.println("\nThe product of each digit of the given number is : " + p);
	}
}