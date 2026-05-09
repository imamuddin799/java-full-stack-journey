package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class NumBwMToN6InIt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number M and N to Print and Count Number of 6 In It : ");
		System.out.print("Enter value of M :");
		long m = sc.nextLong();
		System.out.print("Enter value of N :");
		long n = sc.nextLong();
		long max = m > n ? m : n;
		long min = m < n ? m : n;
		for (long i = min; i <= max; i++) {
			long j = i, k = i;
			long remainder = 0;
			while (j != 0) {
				remainder = j % 10;
				if (remainder == 6) {
					break;
				}
				j /= 10;
			}
			if (remainder == 6)
				System.out.println(k);
		}
		int count = 0;
		for (long i = min; i <= max; i++) {
			long j = i;
			while (j != 0) {
				long remainder = j % 10;
				if (remainder == 6)
					count++;
				j /= 10;
			}
		}
		System.out.println("Count of Numbers in which 6 is present between " + m + " and " + n + " is : " + count);
	}
}