package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class PerfectPosition {

	public static int sumOfFactors(int n) {
		int sum = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static boolean isPerfect(int n) {
		if (sumOfFactors(n) == n && sumOfFactors(n) != 0)
			return true;
		else
			return false;
	}

	public static void perfectPos(int n) {
		while (n != 0) {
			int r = n % 10;
			if (isPerfect(r)) {
				System.out.println(r);
			}
			n /= 10;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check it is a perfect digits in it : ");
		int num = sc.nextInt();
		System.out.println("\nThe perfect digits present in it :");
		perfectPos(num);
	}
}
