package basics_01.primitive_type_casting_01;

public class Primitive01 {

	public static void main(String[] args){
		byte b=100;
		int a=b;
		System.out.println(b); //100
		System.out.println(a); //100
		char ch='a';
		int i=ch;
		System.out.println(ch); //a
		System.out.println(i); //97
		int i2='A';
		System.out.println(i2); //65
		long l=3456787656787L;
		float f=l;
		System.out.println(l);
		System.out.println(f);
		char ch2=65;
		System.out.println(ch2);
	}
}
