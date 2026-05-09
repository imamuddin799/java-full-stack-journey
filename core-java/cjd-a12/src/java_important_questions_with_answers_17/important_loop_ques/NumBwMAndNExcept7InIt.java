package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class NumBwMAndNExcept7InIt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number M and N to Print Numbers Except 7 In It : ");
		System.out.print("Enter value of M :");
		long m = sc.nextLong();
		System.out.print("Enter value of N :");
		long n = sc.nextLong();
		long max = m > n ? m : n;
		long min = m < n ? m : n;
		for (long i = min; i <= max; i++) {
			long j = i;
			long remainder = 0;
			while (j != 0) {
				remainder = j % 10;
				if (remainder == 7)
					break;
				j /= 10;
			}
			if (remainder != 7)
				System.out.println(i);
		}
	}
}