package collection_13.list_01.arraylist_01.dec_19;

import java.util.ArrayList;
import java.util.List;

public class PrimeList04 {
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] arhs) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		List<Integer> prime = new ArrayList<Integer>();
		for (int i : list) {
			if (isPrime(i)) {
				prime.add(i);
			}
		}
		System.out.println(prime);
	}
}