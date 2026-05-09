package basics_01.operators_02;

public class Logical04 {

	public static void main(String[] args){
		double tenth=68;
		double twelfth=72;
		double degree=75;
		System.out.println(tenth>=60 && twelfth>=65 && degree>=60);

		char ch='i';
		System.out.println(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');

		char ch1='b';
		System.out.println(!(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u'));
	}
}
