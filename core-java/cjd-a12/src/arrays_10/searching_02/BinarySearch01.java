package arrays_10.searching_02;

public class BinarySearch01 {

	public static void main(String[] args) {
		int a[] = { 3, 5, 8, 11, 15 };
		int ele = 5;
		int f = 0;
		int l = a.length - 1;
		while (f <= l) {
			int mid = (f + l) / 2;
			if (ele == a[mid]) {
				System.out.println(ele + " found at " + mid);
				break;
			} else if (ele > a[mid]) {
				f = mid + 1;
			} else {
				l = mid - 1;
			}
		}
		if (f > l) {
			System.out.println(ele + " not found");
		}
	}
}
