package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class Armstrong {

	public static boolean isArmstrong(long n) {
		long sum = 0, count = count(n), originalNumber = n;
		for (int i = 1; i <= count; i++) {
			long remainder = n % 10;
			sum += power((int) remainder, (int) count);
			n /= 10;
		}
		return originalNumber == sum;
	}

	public static long power(int a, int b) {
		int power = 1;
		for (int i = 1; i <= b; i++) {
			power *= a;
		}
		return power;
	}

	public static int count(long n) {
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check armstrong or not : ");
		int num = sc.nextInt();
		if (isArmstrong(num)) {
			System.out.println("\nThe given number is a armstrong number");
		} else {
			System.out.println("\nThe given number is not a armstrong number");
		}
	}
}