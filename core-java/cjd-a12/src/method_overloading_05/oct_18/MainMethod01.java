package method_overloading_05.oct_18;

public class MainMethod01 {

	public static void main(int a){
		System.out.println("main(int a)");
	}
	public static void main(){
		System.out.println("main()");
	}
	public static void main(String[] args) {
		System.out.println("String[] args");
		main(5);
		main("10");
		main();
	}
	public static void main(String s){
		System.out.println("main(String s)");
	}
}
