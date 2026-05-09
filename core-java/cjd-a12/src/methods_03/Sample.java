package methods_03;

public class Sample {

	public static int m1(){
		System.out.println("m1 start");
		int a=10;
		while(true){	//infinite loop is not possible 
			return a;
		}
	}
	public static int m2(){
		System.out.println("m1 start");
		int a=10;
		if(true){	//infinite loop is not possible 
			return a;
		}
		return a;	//Dead code
	}
	public static int m3(){
		System.out.println("m1 start");
		int a=10;
		for(;true;){		//infinite loop is not possible 
			return a;
		}
	}
	public static void main(String[] args){
		System.out.println(m1());
		System.out.println(m2());
		System.out.println(m3());
	}
}
