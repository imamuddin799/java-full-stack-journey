package arrays_10;

public class LeftRotation08 {

	public static void main(String[] args) {
		int n = 4;
		int a[] = { 1, 2, 3, 4, 5, 6 }; // 5,6,1,2,3,4
		int res[] = new int[a.length];// 6 res[] = {0,0,0,0,0,0}
		int k = n;
		for (int i = 0; i < a.length; i++, k++) {
			if (k >= a.length)
				k = 0;
			res[i] = a[k]; // {5,6,1,2,3,4} {0,0,0,0,0,0} {0,0,0,0,5,6}
		}
		for (int i : res)
			System.out.print(i + " ");
	}
}
