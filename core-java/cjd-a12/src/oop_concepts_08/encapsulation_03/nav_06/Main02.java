package oop_concepts_08.encapsulation_03.nav_06;

public class Main02 {
	
	public static void main(String[] args) {
		A01 ob = new A01();
		System.out.println(ob.getA());
		ob.setB("Hi");
		System.out.println(ob.getB());
		ob.setA(10);
		System.out.println(ob.getA());
	}
}
