package basics_01.primitive_type_casting_01;

public class ExplicitNarrowing03 {

	public static void main(String[] args){
		int a=100;;
		byte b=(byte)a;
		System.out.println(a); //100
		System.out.println(b); //100

		float f=102.75f;
		int a2=(int)f;
		System.out.println(f); //102.75
		System.out.println(a2); //102

		int a3=97;
		char ch=(char)a3;
		System.out.println(a3); //97
		System.out.println(ch); //a

		System.out.println("Byte datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Byte Size :\t"+Byte.SIZE);
		System.out.println("Byte Minimum Value :\t"+Byte.MIN_VALUE);
		System.out.println("Byte Maximum Value :\t"+Byte.MAX_VALUE +"\n");

		System.out.println("Short datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Short Size :\t"+Short.SIZE);
		System.out.println("Short Minimum Value :\t"+Short.MIN_VALUE);
		System.out.println("Short Maximum Value :\t"+Short.MAX_VALUE +"\n");


		System.out.println("Integer datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Integer Size :\t"+Integer.SIZE);
		System.out.println("Integer Minimum Value :\t"+Integer.MIN_VALUE);
		System.out.println("Integer Maximum Value :\t"+Integer.MAX_VALUE +"\n");

		System.out.println("Long datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Long Size :\t"+Long.SIZE);
		System.out.println("Long Minimum Value :\t"+Long.MIN_VALUE);
		System.out.println("Long Maximum Value :\t"+Long.MAX_VALUE +"\n");

		System.out.println("Float datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Float Size :\t"+Float.SIZE);
		System.out.println("Float Minimum Value :\t"+Float.MIN_VALUE);
		System.out.println("Float Maximum Value :\t"+Float.MAX_VALUE +"\n");

		System.out.println("Double datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Double Size :\t"+Double.SIZE);
		System.out.println("Double Minimum Value :\t"+Double.MIN_VALUE);
		System.out.println("Double Maximum Value :\t"+Double.MAX_VALUE +"\n");

		System.out.println("Character datatype's size in bits, minimum value and maximum value : ");
		System.out.println("Character Size :\t"+Character.SIZE);
		System.out.println("Character Minimum Value :\t'"+Character.MIN_VALUE+"'");
		System.out.println("Character Maximum Value :\t"+Character.MAX_VALUE +"\n");
	}
}
