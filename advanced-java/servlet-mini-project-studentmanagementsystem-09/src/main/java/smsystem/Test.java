package smsystem;

import java.util.Scanner;

public class Test {
	
	public static void sum60(int a[]) {
		boolean isFound = false;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				for(int k = 0; k < a.length; k++) {
					int sum = a[i] + a[j] + a[k];
					if(sum == 60) {
						System.out.println(a[i] +" "+ a[j] +" "+ a[k]);
						isFound = true;
					}
				}
			}
		}
		if(!isFound)
			System.out.println("not found");
	}
	
	public static int  test(int n) {
		for(int i = 0; i < 10; i++) {
			return n;
		}
		return n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter hour : ");
//		int hr = sc.nextInt();
//		System.out.print("Enter minute : ");
//		int min = sc.nextInt();
//		System.out.print("Enter seconds : ");
//		int sec = sc.nextInt();
//		
//		if(isValid(hr, min, sec)) {
//			int totalSec = (hr * 3600) + min * 60 + sec;
//			System.out.println("Total seconds : "+ totalSec);
//		}
//		else {
//			System.out.println("Invalid Input");
//		}

//		System.out.print("Enter number : ");
//		int n = sc.nextInt();
//
//		int a = n - 1;
//		int b = 1;
//
//		int c = 0;
//		if (n > 1) {
//			while (a >= b && n >= 2 && a + b == n) {
//
//				System.out.println(a + " => " + b);
//				c++;
//				a--;
//				b++;
//			}
//		} else {
//			c = 1;
//			a++;
//			b--;
//			System.out.println(a +" => "+ b);
//		}
//		System.out.println(c);
		
		int a[] = {2, 6, 10, 18, 14, 22, 26, 30, 34, 38, 42, 46, 50, 53};
		sum60(a);

	}

	public static boolean isValid(int hr, int min, int sec) {
		if (hr >= 1 && hr <= 60 && min >= 1 && min <= 60 && sec >= 1 && sec <= 60) {
			return true;
		} else {
			return false;
		}
	}
}

//package smsystem;
//
//import java.sql.Date;
//import java.util.Scanner;
//
//public class Test {
//
//	private static String correctDate(String s) {
//		System.out.println(s);
//		if (!s.equals("null")) {
//			String res = "";
//
//			String s1[] = s.split("-");
//			for (String s2 : s1) {
//				res = "-" + s2 + res;
//			}
//			res = res.substring(1);
//			return res;
//		} else {
//			return "Not available";
//		}
//	}
//	public static void main(String[] args) {
////		Date dob = null;
////		System.out.println(correctDate(dob+""));
//		
////		String name = "imamuddin";
////		String lastName = "ansari";
////		
////		System.out.println("First name = "+ name.toUpperCase() +"\nLast name = "+ lastName.toUpperCase());
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter starting number : ");
//		int a = sc.nextInt();
//		System.out.print("Enter common difference : ");
//		int d = sc.nextInt();
//		System.out.print("Enter number of term : ");
//		int n = sc.nextInt();
//		
//		int nthterm = 0;
//		if(n >= 1 && n <=10000 && a >= 1 && a <= 10000 && d >= -100 && d <= 100) {
//			nthterm = a + (n - 1) *d;
//			System.out.println("Nth term is : "+ nthterm);
//		}
//		else {
//			System.out.println("Please Enter valid inputs");
//		}
//		
//		
//	}
//}