package controlflow_02.conditionals_01;

public class IfElseLadderAssignment08 {

	public static void main(String[] args) {

		// DATE-14/09/2024

		int n = 23;
		if (n % 3 == 0 && n % 5 == 0) {
			System.out.println("Good Evening.!!!");
		} else if (n % 3 == 0) {
			System.out.println("Good Morning.!!!");
		} else if (n % 5 == 0) {
			System.out.println("Good Afternoon.!!!");
		} else {
			System.out.println("Good Night.!!!");
		}

		// FIND MINMUM OF 5 NUMBERS

		int a = 35, b = 40, c = 30, d = 45, e = 25, f = 50, g = 20;
		if (a < b && a < c && a < d && a < e) {
			System.out.println(a + " is Minimum");
		} else if (b < c && b < d && b < e) {
			System.out.println(b + " is Minimum");
		} else if (c < d && c < e) {
			System.out.println(e + " is Minimum");
		} else if (d < e) {
			System.out.println(d + " is Minimum");
		} else {
			System.out.println(e + " is Minimum");
		}

		// FIND THE MAXIMUM OF 7

		if (a > b && a > c && a > d && a > e && a > f && a > g) {
			System.out.println(a + " is Maximum");
		} else if (b > c && b > d && b > e && b > f && b > g) {
			System.out.println(b + " is Maximum");
		} else if (c > d && c > e && c > f && c > g) {
			System.out.println(c + " is Maximum");
		} else if (d > e && d > f && d > g) {
			System.out.println(d + " is Maximum");
		} else if (e > f && e > g) {
			System.out.println(e + " is Maximum");
		} else if (f > g) {
			System.out.println(f + " is Maximum");
		} else {
			System.out.println(g + " is Maximum");
		}
	}
}
