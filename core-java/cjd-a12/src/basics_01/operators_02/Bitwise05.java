package basics_01.operators_02;

public class Bitwise05 {

	public static void main(String[] args) {

		// DATE-11/09/2024

		// BITWISE AND
		System.out.println("BITWISE AND (&)");
		int a = 11, b = 17;
		System.out.println(a & b);

		int a1 = 25, b1 = 31;
		System.out.println(a1 & b1);

		a = 38;
		b = 47;
		System.out.println(a & b);

		a = 7;
		b = 29;
		System.out.println(a & b);

		a = 43;
		b = 22;
		System.out.println(a & b);

		a = 15;
		b = 30;
		System.out.println(a & b);

		// BITWISE OR
		System.out.println("BITWISE OR (|)");
		a = 25;
		b = 31;
		System.out.println(a | b);

		a = 11;
		b = 17;
		System.out.println(a | b);

		a = 38;
		b = 47;
		System.out.println(a | b);

		a = 7;
		b = 29;
		System.out.println(a | b);

		a = 43;
		b = 22;
		System.out.println(a | b);

		a = 15;
		b = 30;
		System.out.println(a | b);

		// BITWISE EXCLUSIVE OR (^)
		System.out.println("BITWISE EXCLUSIVE OR (^)");
		a = 25;
		b = 31;
		System.out.println(a ^ b);

		a = 11;
		b = 17;
		System.out.println(a ^ b);

		a = 38;
		b = 47;
		System.out.println(a ^ b);

		a = 7;
		b = 29;
		System.out.println(a ^ b);

		a = 43;
		b = 22;
		System.out.println(a ^ b);

		a = 15;
		b = 30;
		System.out.println(a ^ b);

		// QUESTIONS
		System.out.println("QUESTION 1");
		int c, d, e, f, g;
		a = 27;
		b = 12;
		c = a & b;
		System.out.println("C : " + c);
		d = a | b;
		System.out.println("D : " + d);
		e = c ^ d;
		System.out.println("E : " + e);
		f = a & (c | e);
		System.out.println("F : " + f);
		g = (a & b) ^ (a | b);
		System.out.println("G : " + g);

		System.out.println("QUESTION 2");
		a = 11;
		b = 23;
		c = 37;
		d = (a & b) & c;
		System.out.println("D : " + d);
		e = (a & d) ^ (a | c);
		System.out.println("E : " + e);
		f = (a ^ b) & (b ^ c);
		System.out.println("F : " + f);
		g = (a & b) | (e & f);
		System.out.println("G : " + g);

		// DATE-12/09/2024

		// BITWISE LEFT AND RIGHT SHIFT OPERATOR
		System.out.println("BITWISE LEFT AND RIGHT SHIFT (<< AND >>)");
		a = 18;
		b = 3;
		c = (a & b) | a;
		System.out.println("C : " + c);
		d = c ^ (a | b);
		System.out.println("D : " + d);
		e = c >> b;
		System.out.println("E : " + e);
		f = d << b;
		System.out.println("F : " + f);
		g = (a & 3) >> 2;
		System.out.println("G : " + g);
	}
}
