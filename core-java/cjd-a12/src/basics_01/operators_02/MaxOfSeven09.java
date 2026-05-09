package basics_01.operators_02;

public class MaxOfSeven09 {

	public static void main(String[] args) {
		int a = 5, b = 10, c = 15, d = 20, e = 25, f = 30, g = 35;

		int max = (a > b) ? ((a > c) ? ((a > d) ? ((a > e) ? ((a > f) ? ((a > g) ? a : g)
				: ((f > g) ? f : g))
				: ((e > f) ? ((e > g) ? e : g)
						: ((f > g) ? f : g)))
				: ((d > e) ? ((d > f) ? ((d > g) ? d : g)
						: ((f > g) ? f : g))
						: ((e > f) ? ((e > g) ? e : g)
								: ((f > g) ? f : g))))
				: ((c > d) ? ((c > e) ? ((c > f) ? ((c > g) ? c : g)
						: ((f > g) ? f : g))
						: ((e > f) ? ((e > g) ? e : g)
								: ((f > g) ? f : g)))
						: ((d > e) ? ((d > f) ? ((d > g) ? d : g)
								: ((f > g) ? f : g))
								: ((e > f) ? ((e > g) ? e : g)
										: ((f > g) ? f : g)))))
				: ((b > c) ? ((b > d) ? ((b > e) ? ((b > f) ? ((b > g) ? b : g)
						: ((f > g) ? f : g))
						: ((e > f) ? ((e > g) ? e : g)
								: ((f > g) ? f : g)))
						: ((d > e) ? ((d > f) ? ((d > g) ? d : g)
								: ((f > g) ? f : g))
								: ((e > f) ? ((e > g) ? e : g)
										: ((f > g) ? f : g))))
						: ((c > d) ? ((c > e) ? ((c > f) ? ((c > g) ? c : g)
								: ((f > g) ? f : g))
								: ((e > f) ? ((e > g) ? e : g)
										: ((f > g) ? f : g)))
								: ((d > e) ? ((d > f) ? ((d > g) ? d : g)
										: ((f > g) ? f : g))
										: ((e > f) ? ((e > g) ? e : g)
												: ((f > g) ? f : g)))));

		System.out.println(max); // 35
	}
}
