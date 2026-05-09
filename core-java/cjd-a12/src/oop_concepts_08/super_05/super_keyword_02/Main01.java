package oop_concepts_08.super_05.super_keyword_02;

class A {
	int a = 10;
}

class B extends A {
	int a = 20;

	public void m1() {
		int a = 30;
		System.out.println(a);
		System.out.println(this.a);
		System.out.println(super.a);
	}
}

public class Main01 {
	public static void main(String[] args) {
		B ob = new B();
		ob.m1();
	}
}