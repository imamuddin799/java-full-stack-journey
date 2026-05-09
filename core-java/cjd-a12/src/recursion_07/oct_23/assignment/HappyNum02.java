package recursion_07.oct_23.assignment;

import java.util.Scanner;

public class HappyNum02 {

	public static int happyNum(int n) {
		if (n != 1 && n != 4) {
			return happyNum(sum(n, 0));
		}
		return n;
	}

	public static int sum(int n, int sum) {
		if (n != 0) {
			int r = n % 10;
			sum = sum + r * r;
			return sum(n / 10, sum);
		} else {
			return sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check happy number or not : ");
		int n = sc.nextInt();
		if (happyNum(n) == 1)
			System.out.println("Happy Number");
		else
			System.out.println("Not a Happy Number");
		sc.close();
	}
}
