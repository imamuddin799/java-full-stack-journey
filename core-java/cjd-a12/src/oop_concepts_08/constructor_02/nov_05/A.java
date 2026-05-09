package oop_concepts_08.constructor_02.nov_05;

public class A{
	int a;
	int b;
	A(int a, int b){
		this.a = a;
		this.b = b;
	}
	A(A ob){
		this.a = ob.a;
		this.b = ob.b;
	}
}
class Main{
	public static void main(String[] args){
		A ob1 = new A(10, 20);
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		ob1.a = 500;
		ob1.b = 600;
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		A ob2 = ob1;
		ob2.b = 700;
		System.out.println(ob2.a);
		System.out.println(ob2.b);
		A ob3 = new A(ob1);
		System.out.println(ob3.a);
		System.out.println(ob3.b);
		ob3.a = 1000;
		ob3.b = 2000;
		System.out.println(ob3.a);
		System.out.println(ob3.b);
	}
}
//class A{
//	int a;
//	int b;
//	int c;
//	int d;
//	A(int a){
//		this.a = a;
//	}
//	A(int a, int b){
//		this(a, b, 10, 20);
//	}
//	A(int a, int b, int c){
//		this(a, b);
//		this.c = c;
//	}
//	A(int a, int b, int c, int d){
//		this(a, b, c);
//		this.d = d;
//	}
//}
//class Main{
//	public static void main(String[] args){
//		A ob = new A(10, 20, 30);
//	}
//}