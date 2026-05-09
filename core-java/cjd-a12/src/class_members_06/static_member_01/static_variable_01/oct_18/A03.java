package class_members_06.static_member_01.static_variable_01.oct_18;

public class A03 {

	static int a=10;
	static double b;
	public static void main(String[] args){
		System.out.println(a);//10
		System.out.println(b);//0.0
		int a=50;
		System.out.println(a);//50
		System.out.println(A03.a);//10
		A03.b=20;
		System.out.println(b);//20
	}
}
