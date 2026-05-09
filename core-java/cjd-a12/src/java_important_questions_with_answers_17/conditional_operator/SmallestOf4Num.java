package java_important_questions_with_answers_17.conditional_operator;

public class  SmallestOf4Num{
	
	public static void main(String[] args) {
		int a=10, b=20, c=30, d=4;
		System.out.println("Given numbers are A : "+ a +", B : "+ b +", C : "+ c +", D : "+ d);
		int res=(a<b)?
				(a<c)?
					(a<d?a:d)
					:(c<d?c:d)
				:(b<c)?
					(b<d?b:d)
					:(c<d?c:d);
		System.out.println("Smallest of given 4 numbers : "+res);
	}
}