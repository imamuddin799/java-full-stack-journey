package controlflow_02.conditionals_01;

public class SepSixteen09 {

	public static void main(String[] args) {

		// DATE-16/09/2024

		// MAX OF 3 NUMBERS USING SIMPLE IF.

		int a = 10, b = 20, c = 30;
		System.out.println("Values of integers a=" + a + ", b=" + b + ", c=" + c);
		int m = a;
		if (b > m)
			m = b;
		if (c > m)
			m = c;
		System.out.println(m + " is Maximum");

		// OR

		if (a > b && a > c)
			System.out.println(a + " is Maximum");
		if (b > a && b > c)
			System.out.println(b + " is Maximum");
		if (c > a && c > b)
			System.out.println(c + " is Maximum");

		// SECOND MAX AMONG THE THREE NUMBERS

		if ((a > b && a < c) || (a > c && a < b))
			System.out.println(a + " is Second Maximum");
		else if ((b > a && b < c) || (b > c && b < a))
			System.out.println(b + " is Second Maximum");
		else
			System.out.println(c + " is Second Maximum");

		// SORTING VALUES IF 3 NUMBERS ARE GIVEN

		int min, max, sec;
		if (a > b && a > c)
			max = a;
		else if (b > c)
			max = b;
		else
			max = c;

		min = (a < b && a < c) ? a : ((b > c) ? b : c);

		sec = (a + b + c) - (min + max);

		System.out.println("Ascending");
		System.out.println(min);
		System.out.println(sec);
		System.out.println(max);

		System.out.println("Descending");
		System.out.println(max);
		System.out.println(sec);
		System.out.println(min);

		// SWAPPING

		int temp;
		System.out.println("Before Swapping a=" + a + ", b=" + b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("After Swapping a=" + a + ", b=" + b);

		// Second Way

		System.out.println("Second Way Before Swapping a=" + a + ", b=" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After Swapping a=" + a + ", b=" + b);

		// Third Way

		System.out.println("Third Way Before Swapping a=" + a + ", b=" + b);
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("After Swapping a=" + a + ", b=" + b);
	}
}
