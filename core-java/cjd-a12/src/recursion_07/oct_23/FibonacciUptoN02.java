package recursion_07.oct_23;

public class FibonacciUptoN02 {

	public static void fibonacci(int n, int a, int b){
		int c = a + b;
		if(a<=n){
			System.out.println(a);
			fibonacci(n, b, c);
		}
	}
	public static void main(String[] args){
		fibonacci(100, 0, 1);
	}
}
