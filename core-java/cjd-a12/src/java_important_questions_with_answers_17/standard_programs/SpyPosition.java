package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class SpyPosition {
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

	public static void spyPos(int n) {
		while (n != 0) {
			int r = n % 10;
			if (isSpy(r)) {
				System.out.println(r);
			}
			n /= 10;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check spy digits in it : ");
		int num = sc.nextInt();
		System.out.println("\nThe spy digits present in it :");
		spyPos(num);
	}
}