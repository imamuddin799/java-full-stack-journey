package recursion_07.oct_22;

import java.util.Scanner;

public class Reverse03 {

	public static long reverse(long n, long rev) {
		if (n != 0) {
			rev = rev * 10 + (n % 10);
			return reverse(n / 10, rev);
		} else {
			return rev;
		}
	}

	public static long rev(long n) {
		return reverse(n, 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to reverse it : ");
		long n = sc.nextLong();
		System.out.println(rev(n));
		sc.close();
	}
}
