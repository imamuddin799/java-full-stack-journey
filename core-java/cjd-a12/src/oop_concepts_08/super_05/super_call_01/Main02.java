package oop_concepts_08.super_05.super_call_01;

class A1 {
	static int a = 10;
	int b = 20;
}

class B01 extends A1 {
	static int c = 30;
	int d = 40;
}

public class Main02 {
	public static void main(String[] args) {
		B01 ob = new B01();
		System.out.println(ob.a);
		System.out.println(ob.b);
		System.out.println(ob.c);
		System.out.println(ob.d);
	}
}