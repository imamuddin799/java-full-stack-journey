package oop_concepts_08.package_07.access_specifiers_01.package_02;

import oop_concepts_08.package_07.access_specifiers_01.package_01.A01;

public class C01 extends A01 {

	public static void main(String[] args) {
		A01 ob = new A01();
		C01 ob1 = new C01();
		System.out.println(ob1.c);
		System.out.println(ob.d);
		System.out.println(ob1.d);
	}
}
