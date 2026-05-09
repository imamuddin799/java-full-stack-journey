package controlflow_02.loops_03.do_while_02;

public class SepTwenty01 {

	public static void main(String[] args) {

		// DATE-20/09/2024

		// TABLE OF 10 FROM 11 TO 20

		int i = 10;
		int n = 11;
		int m = 20;
		do {
			System.out.println(i + " * " + n + " = " + (n * i));
			n++;
		} while (n <= m);
	}
}
