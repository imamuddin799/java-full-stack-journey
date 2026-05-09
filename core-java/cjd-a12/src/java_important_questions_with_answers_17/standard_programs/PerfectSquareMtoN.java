package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class PerfectSquareMtoN {

	public static boolean isPerfectSquare(long n) {
		for (long i = 0; i * i <= n; i++) {
			if (i * i == n)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a range to find perfect squares : ");
		System.out.print("Enter starting range : ");
		long m = sc.nextLong();
		System.out.print("Enter ending range : ");
		long n = sc.nextLong();
		for (long i = m; i <= n; i++) {
			if (isPerfectSquare(i)) {
				System.out.println(i);
			}
		}
	}
}
