package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class PerfectMtoN {

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a range to find perfect numbers : ");
		System.out.print("Enter starting range : ");
		int m = sc.nextInt();
		System.out.print("Enter ending range : ");
		int n = sc.nextInt();
		for (int i = m; i <= n; i++) {
			if (isPerfect(i)) {
				System.out.println(i);
			}
		}
	}
}
