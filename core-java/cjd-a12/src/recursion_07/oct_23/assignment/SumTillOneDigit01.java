package recursion_07.oct_23.assignment;

import java.util.Scanner;

public class SumTillOneDigit01 {

	public static int oneDigit(int n) {
		if (n > 9) {
			return oneDigit(sum(n, 0));
		}
		return n;
	}

	public static int sum(int n, int sum) {
		if (n != 0) {
			sum = sum + n % 10;
			return sum(n / 10, sum);
		} else {
			return sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find its sum until we get single digit : ");
		int n = sc.nextInt();
		System.out.println(oneDigit(n));
		sc.close();
	}
}
