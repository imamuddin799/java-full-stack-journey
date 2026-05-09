package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Reverse {

	public static long reverse(long n) {
		long reverse = 0;
		while (n != 0) {
			long r = n % 10;
			reverse = reverse * 10 + r;
			n /= 10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to reverse : ");
		long num = sc.nextLong();
		long reverse = reverse(num);
		System.out.println("The reversed numbers is : " + reverse);
	}
}