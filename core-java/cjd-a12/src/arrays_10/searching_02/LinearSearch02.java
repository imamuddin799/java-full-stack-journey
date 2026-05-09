package arrays_10.searching_02;

public class LinearSearch02 {

	public static void main(String[] args) {
		int a[] = { 5, 7, 6, 9, 15, 3 };
		int elementToFind = 15;
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if (elementToFind == a[i]) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			System.out.println(elementToFind + " not Found");
		} else {
			System.out.println(elementToFind + " is Found at " + index + " and its position is " + (index + 1));
		}
	}
}
