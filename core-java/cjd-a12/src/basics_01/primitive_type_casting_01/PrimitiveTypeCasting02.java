package basics_01.primitive_type_casting_01;

public class PrimitiveTypeCasting02 {

	public static void main (String[] args) {
		//Date-03/09/2024
		//long l1=1324214315312345678l;
		//long l1=132421431531531453513541344551345l;
		//System.out.println(l1);
		//float f1=1324214315315314535135413445513452236789.54f;

		//float f1=132421431531531453513541344551345223678.54f;
		//System.out.println(f1); //1.3242143E38

		//double d='a';
		//System.out.println(d); //97.0

		//long l='b';
		//System.out.println(l); //98

		//float f2=5l;
		//System.out.println(f2); //5.0

		//double d2=4.5f;
		//System.out.println(d2); //4.5
		
		// double d3=true; //Compile Time Error(CTC)
		//System.out.println(d3);


		//Explicit Narrowing

		//int i1=(int)35.56;
		//System.out.println(i1); //35

		//int a=' ';
		//System.out.println(a); //32

		//char ch1=98; //its an internal automatic process
		//System.out.println(ch1); //b

		//char ch2=220;
		//System.out.println(ch2);



		
		//Date-03/09/2024
		long l1=(long)1324214315312345678l;
		//long l1=(long)132421431531531453513541344551345l;
		System.out.println(l1);
		//float f1=1324214315315314535135413445513452236789.54f;

		float f1=132421431531531453513541344551345223678.54f;
		System.out.println(f1); //1.3242143E38

		double d=(double)'a';
		System.out.println(d); //97.0

		long l=(long)'b';
		System.out.println(l); //98

		float f2=(float)5l;
		System.out.println(f2); //5.0

		double d2=(double)4.5f;
		System.out.println(d2); //4.5
		
		// double d3=true; //Compile Time Error(CTC)
		//System.out.println(d3);


		//Explicit Narrowing

		int i1=(int)35.56;
		System.out.println(i1); //35

		int a=(int)' ';
		System.out.println(a); //32

		char ch1=(char)98; //its an internal automatic process
		System.out.println(ch1); //b

		char ch2=(char)220;
		System.out.println(ch2); //Ü

		long l2=123l;
		int i3=(int)l2;
		System.out.println(i3);

	}
}
