package oop_concepts_08.package_07.access_specifiers_01.package_01;

public class A01 {

	private int a = 10;
	int b = 20;
	protected int c = 30;
	public int d = 40;

	public static void main(String[] args) {
		A01 ob = new A01();
		System.out.println(ob.a);
		System.out.println(ob.b);
		System.out.println(ob.c);
		System.out.println(ob.d);
	}
}
