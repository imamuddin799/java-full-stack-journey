package collection_13.set_02.tree_set_02.dec_31;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class NthMaximum01 {

	public static void main(String[] args) {
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		al.add(3);
//		al.add(8);
//		al.add(7);
//		al.add(2);
//		al.add(9);
//		al.add(8);
//		al.add(3);
//		al.add(5);
//		al.add(9);
//		al.add(2);
//		al.add(4);
//		al.add(10);
//		al.add(9);
//		
//		System.out.println(al);
//		
//		Set<Integer> ts = new TreeSet<Integer>(al);
//		System.out.println(ts);
//		al.clear();
//		System.out.println(al);
//		al.addAll(ts);
//		System.out.println(al);
//		System.out.println(al.get(al.size()-3));

		Scanner sc = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		int n = 3;
		Boolean b = true;
		while (b) {
			System.out.println("1:add\n0:Quit");
			int op = sc.nextInt();
			if (op == 1)
				v.add(sc.nextInt());
			else if (op == 0)
				b = false;
		}
		System.out.println(v);
		TreeSet<Integer> ts = new TreeSet<Integer>(v);
		ArrayList<Integer> al = new ArrayList<Integer>(ts);
		System.out.println(al);
		System.out.println(al.get(al.size() - n));
	}
}
/*
 * 1 3 1 8 1 7 1 2 1 9 1 8 1 3 1 5 1 9 1 2 1 4 1 10 1 9 0
 */