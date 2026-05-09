package class_members_06.static_member_01.static_variable_01.oct_18;

public class A02 {

	static int a=10;
	public static void main(String[] args){
		int a=20;
		System.out.println(a);//20
		System.out.println(A02.a);//10
	}
}
