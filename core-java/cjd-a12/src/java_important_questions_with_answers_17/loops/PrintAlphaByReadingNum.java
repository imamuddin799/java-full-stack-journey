package java_important_questions_with_answers_17.loops;

public class PrintAlphaByReadingNum {

	public static void main(String[] args) {
		/**
		 * int n=0; n=n>26?n%26:n; char ch='A'; ch--; //initialize ch as '@' and don't
		 * use ch--; for(int i=1; i<=n; i++){ ch++; } System.out.println(n +"\t"+ ch);
		 */
		int n = 1;
		if (n < 1 || n > 26) {
			System.out.println("Invalid input. Number should be between 1 and 26.");
		} else {
			char ch = 'A';
			for (int i = 2; i <= n; i++) {
				ch++;
			}
			System.out.println("The corresponding output of given number " + n + " is : " + ch);
		}
	}
}