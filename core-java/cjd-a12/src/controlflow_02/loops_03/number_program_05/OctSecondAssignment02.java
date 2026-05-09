package controlflow_02.loops_03.number_program_05;

public class OctSecondAssignment02 {

	public static void main(String[] args) {

		// DATE-02/10/2024

		// WAP TO FIND NUMBER OF 2'S PRESENT IN THE GIVEN RANGE FROM 10 TO 30;

		int n = 10;
		int c = 0;
		while (n <= 30) {
			int j = n;
			while (j != 0) {
				int r = j % 10;
				if (r == 2) {
					c++;
					// System.out.println(n);
				}
				j /= 10;
			}
			n++;
		}
		System.out.println(c);
	}
}
