package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class SpyMtoN {

	public static int sum(long n) {
		int sum = 0;
		while (n != 0) {
			long r = n % 10;
			sum += (int) r;
			n /= 10;
		}
		return sum;
	}

	public static int product(long n) {
		int p = 1;
		while (n != 0) {
			long r = n % 10;
			p = p * (int) r;
			n /= 10;
		}
		return p;
	}

	public static boolean isSpy(long n) {
		if (sum(n) == product(n))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a range to find spy numbers : ");
		System.out.print("Enter starting range : ");
		int m = sc.nextInt();
		System.out.print("Enter ending range : ");
		int n = sc.nextInt();
		for (int i = m; i <= n; i++) {
			if (isSpy(i)) {
				System.out.println(i);
			}
		}
	}
}
