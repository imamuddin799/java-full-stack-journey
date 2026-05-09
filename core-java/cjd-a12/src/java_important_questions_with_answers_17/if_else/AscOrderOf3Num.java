package java_important_questions_with_answers_17.if_else;

public class AscOrderOf3Num {

	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, max, min, mid;
		System.out.println("Given numbers are A : " + a + ", B : " + b + ", C : " + c);
		if (a > b && a > c) {
			max = a;
		} else if (b > c) {
			max = b;
		} else {
			max = c;
		}
		if (a < b && a < c) {
			min = a;
		} else if (b < c) {
			min = b;
		} else {
			min = c;
		}
		if (a > b && a < c || a < b && a > c) {
			mid = a;
		} else if (b > a && b < c || b < a && b > c) {
			mid = b;
		} else {
			mid = c;
		}
		System.out.println("Ascending of given numbers are : " + min + ", " + mid + ", " + max);
		System.out.println("Descending of given numbers are : " + max + ", " + mid + ", " + min);
	}
}