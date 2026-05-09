package oop_concepts_08.non_primitive_typecasting_06.auto_upcasting_01;

class A {
	int a = 10;
}

class B extends A {
	int b = 20;
}

public class Main01 {

	public static void main(String[] args) {
		A ob = new B();
		System.out.println(ob.a);
		// System.out.println(ob.b); //CTE: Compile Time Error
	}
}