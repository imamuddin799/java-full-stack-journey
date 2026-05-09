package object_class_09.equals_02;

public class Main02 {

	public static void main(String[] args) {
		Car01 c1 = new Car01("RR", 20000000, "Red");
		Car01 c2 = new Car01("Lambo", 40000000, "Yellow");
		Car01 c3 = new Car01("RR", 20000000, "Red");

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		System.out.println();

//		System.out.println(c1.toString());
//		System.out.println(c2.toString());
//		System.out.println(c3.toString());

		System.out.println(c1 == c2);
		System.out.println(c1 == c3);

//		System.out.println(c1.toString()==c2.toString());
//		System.out.println(c1.toString()==c3.toString());

		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}
}
