package java_important_questions_with_answers_17.standard_programs;

import java.util.Scanner;

public class XPowerN {

	public static long xPowerN(int x, int n) {
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * x;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers to find x power n");
		System.out.print("Enter the value of x : ");
		int x = sc.nextInt();
		System.out.print("Enter the value of n : ");
		int n = sc.nextInt();
		long power = xPowerN(x, n);
		System.out.println("\nThe x power n is : " + power);
	}
}