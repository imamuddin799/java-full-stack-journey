package arrays_10;

public class OccurrenceOfGivenElement10 {

	public static void main(String[] args) {
		int a[] = { 5, 3, 2, 3, 5, 7, 3, 4, 3, 7 };
		int elementToFindOccurrence = 9;
		int c = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == elementToFindOccurrence)
				c++;
		}
		if (c == 0)
			c = -1;
		System.out.println("The Occurrence of the given element " + elementToFindOccurrence + " is " + c);
	}
}
