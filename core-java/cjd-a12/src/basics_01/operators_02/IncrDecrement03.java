package basics_01.operators_02;

public class IncrDecrement03 {

	public static void main(String[] args) {
		// DATE-10/09/2024

		int a = 10;
		int b = a++ + ++a + a + ++a + a++;
		System.out.println(a);
		System.out.println(b);

		int a1 = 5;
		int b1 = a1++ + ++a1 + ++a1 + a1++ + a1 + a1++ + ++a1;
		System.out.println(a1);
		System.out.println(b1);

		int a2 = 10;
		int b2 = a2-- + --a2 + --a2 + a2 + a2-- + --a2;
		System.out.println(a2);
		System.out.println(b2);

		int a3 = 1;
		int b3 = a3-- + --a3 + a3-- - a3-- - a3 + a3--;
		System.out.println(a3);
		System.out.println(b3);

		int a4 = 5;
		int b4 = --a4 + a4++ + ++a4 - --a4 - a4-- + ++a4 - a4-- - --a4;
		System.out.println(a4);
		System.out.println(b4);
	}
}
