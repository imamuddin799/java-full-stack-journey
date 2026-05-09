package arrays_10;

import java.util.Scanner;

public class LCM_Of_N_ByMe30 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array size : ");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("\nEnter array elements \n");
		for (int i = 0; i < a.length; i++) {
			System.out.print("Enter " + i + " index value : ");
			a[i] = sc.nextInt();
		}
//		int max = a[0];
//		for(int i = 0; i < a.length; i++) {
//			if(a[i] > max) max = a[i];
//		}
//		boolean c = true;
//		while(true) {
//			c = true;
//			for(int i = 0; i < a.length; i++) {
//				if(max % a[i] != 0) {
//					c = false;
//					break;
//				}
//			}
//			if(c)
//				break;
//			else
//				max++;
//		}
//		System.out.println("The LCM is : "+ max);

		int max = a[0];
		for (int i : a) {
			if (i > max)
				max = i;
		}
		int lcm = max, k = 2;
		while (true) {
			boolean b = true;
			for (int i : a) {
				if (lcm % i != 0) {
					b = false;
					break;
				}
			}
			if (b) {
				System.out.println(lcm);
				break;
			}
			lcm = max * k++;
		}
		sc.close();
	}
}
