package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class NumOfDigitsInNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Count Number of Digits Present in it : ");
		long n = sc.nextLong(), t = n, count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		System.out.print("Number of Digits Present in the given number " + t + " is : " + count);
	}
}
