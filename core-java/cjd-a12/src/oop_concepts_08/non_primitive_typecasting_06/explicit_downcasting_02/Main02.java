package oop_concepts_08.non_primitive_typecasting_06.explicit_downcasting_02;

class A1 {
	public void m1() {
		System.out.println("A m1");
	}
}

class B1 extends A1 {
	public void m2() {
		System.out.println("B m2");
	}
}

class C1 extends A1 {
	public void m3() {
		System.out.println("C m3");
	}
}

public class Main02 {

	public static void main(String[] args) {
		A1 ob = new C1();
		ob.m1();
		// ob.m2(); //CTE
		// ob.m3(); //CTE

		if (ob instanceof C1) {
			C1 ob1 = (C1) ob;
			ob1.m1();
			ob1.m3();
		} else {
			B1 ob1 = (B1) ob;
			ob1.m1();
			ob1.m2();
		}
	}
}