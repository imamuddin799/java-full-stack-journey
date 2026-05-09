package oop_concepts_08.non_primitive_typecasting_06.explicit_downcasting_02;

class A {
	public void m1() {
		System.out.println("A m1");
	}
}

class B extends A {
	public void m2() {
		System.out.println("B m2");
	}
}

public class Main01 {
	public static void main(String[] args) {
		A ob = new B();
		B ob1 = (B) ob;
		ob1.m1();
		ob1.m2();
	}
}