package basics_01;

class Sample01 {
	public static void main(String[] args) {
		int a=10;
		System.out.println(10); //10
		System.out.println(a); //10
		System.out.println('a'); //a
		System.out.println("a"); //a
		int b=20;
		//String b="sleep"; CTE	two local variables must not have same name
		System.out.println(b); //20
		b=50; //initializing
		System.out.println(b); //50
		b=100;
		System.out.println(b); //100
		System.out.println(b); //100
		System.out.println(b); //100
		System.out.println(b); //100
	}
}