package controlflow_02.loops_03.number_program_05;

import java.util.Scanner;

public class NovSeven09 {

	public static int count(int n){
		int c = 0;
		while(n != 0){
			c++;
			n /= 10;
		}
		return c;
	}
	public static int split(int n, int c){
		/*int a = 0, b = 0, p = 1;
		int count = c/2;
		while(c != count){
			int r = n % 10;
			a = a + r * p;
			p *= 10;
			n /= 10;
			c--;
		}
		b = n;
		n = sum(a, b);
		return n;
		*/
		int s = 0, p = 1;
		for(int i =1; i <= c/2; i++){
			int r = n % 10;
			s = r * p + s;
			p *= 10;
			n /= 10;
		}
		return n + s;
	}
	public static int check(int n){
		int count = count(n);
		if(count % 2 == 0)
			return split(n, count);
		else
			return sort(n);
	}
	public static int sort(int n){
		int s = 0;
		for(int i = 1; i <= 9; i++){
			int k = n;
			while(k != 0){
				int r = k % 10;
				if(r == i)
					s = s * 10 + r;
				k /= 10;
			}
		}
		return s;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number : ");
		int n = sc.nextInt();
		int result = check(n);
		System.out.println(result);
		sc.close();
	}
}
