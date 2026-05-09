package scanner_class_04;

import java.util.Scanner;

public class NextLineMethod03 {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
	 /**String s=sc.nextLine();
	 	int a=sc.nextInt();
	 	System.out.println(s);
	 	System.out.println(a);
	 */
		int a=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		System.out.println(a);
		System.out.println(s);
		sc.close();
	}
}
