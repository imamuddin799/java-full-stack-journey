package arrays_10;

import java.util.Scanner;

public class GCD_Of_N29 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array size");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the elements ");
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter " + i + " index value : ");
			a[i] = sc.nextInt();
		}

		int min = a[0];
		for (int i : a) {
			if (i < min)
				min = i;
		}
		boolean b = true;
		for (int i = min; i >= 1; i--) {
			b = true;
			for (int j = 0; j < a.length; j++) {
				if (a[j] % i != 0) {
					b = false;
					break;
				}
			}
			if (b) {
				System.out.println(i);
				break;
			}
		}
		sc.close();
	}
}
