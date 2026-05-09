package recursion_07.oct_23;

public class FibonacciNumOfElements03 {

	public static void fibonacci(int n, int a, int b){
		int c = a + b;
		if(n>0){
			System.out.println(a);
			fibonacci(--n, b, c);
		}
	}
	public static void main(String[] args){
		fibonacci(10, 0, 1);
	}
}
