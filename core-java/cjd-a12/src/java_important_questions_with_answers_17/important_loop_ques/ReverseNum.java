package java_important_questions_with_answers_17.important_loop_ques;

import java.util.Scanner;

public class ReverseNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number to Reverse : ");
		long n = sc.nextLong(), t = n, reverse = 0;
		while (n != 0) {
			long remainder = n % 10;
			reverse = reverse * 10 + remainder;
			n /= 10;
		}
		System.out.print("Reversed Number for the given number " + t + " is : " + reverse);
	}
}