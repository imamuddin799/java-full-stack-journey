package recursion_07.oct_23;

import java.util.Scanner;

public class Prime01 {

	public static boolean prime(int n, int i) {
		if (n < 2)
			return false;
		if (i > n / 2)
			return true;
		if (n % i == 0)
			return false;
		return prime(n, ++i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to check given number is prime or not : ");
		int n = sc.nextInt();
		if (prime(n, 2))
			System.out.println("Given number is Prime");
		else
			System.out.println("Given number is not Prime");
		sc.close();
	}
}
