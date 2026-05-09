package java_important_questions_with_answers_17.conditional_operator;

public class LargestOf5Num {

	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, d = 40, e = 50;
		System.out.println("Given numbers are A : " + a + ", B : " + b + ", C : " + c + ", D : " + d + ", E : " + e);
		int res = (a > b)
				? (a > c) ? (a > d) ? (a > e ? a : e) : (d > e ? d : e) : (c > d) ? (c > e ? c : e) : (d > e ? d : e)
				: (b > c) ? (b > d) ? (b > e ? b : e) : (d > e ? d : e) : (c > d) ? (c > e ? c : e) : (d > e ? d : e);
		System.out.println("Largest of given 5 numbers : " + res);
	}
}