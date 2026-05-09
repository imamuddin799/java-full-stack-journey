package collection_13.list_01.arraylist_01.sorting.dec_24;

import java.util.ArrayList;
import java.util.Collections;

public class Company02 {

	public static void main(String[] args) {
		ArrayList<Employee01> emp = new ArrayList<Employee01>();
		emp.add(new Employee01(1, "ABC", 50000, "22-08-2024"));
		emp.add(new Employee01(2, "DEF", 40000, "23-12-2024"));
		emp.add(new Employee01(3, "GHI", 45000, "01-12-2024"));
		emp.add(new Employee01(4, "MNO", 60000, "31-07-2022"));
		emp.add(new Employee01(5, "PQR", 65000, "01-08-2022"));
		emp.add(new Employee01(6, "RST", 70000, "09-09-2020"));
		emp.add(new Employee01(7, "XYZ", 80000, "15-06-2014"));
		emp.add(new Employee01(8, "Samdhani", 100000, "25-08-2021"));
		emp.add(new Employee01(9, "Ashutosh", 185000, "08-11-2020"));
		emp.add(new Employee01(10, "Yeswanth", 32500, "24-07-2024"));
		emp.add(new Employee01(11, "Vaishnavi", 70000, "12-12-2023"));

//		System.out.println(emp);
//		
//		Collections.sort(emp);
//		
//		System.out.println(emp);

		for (Employee01 e : emp) {
			int year = Integer.parseInt(e.dOJ.substring(6));
			int mon = Integer.parseInt(e.dOJ.substring(3, 5));
			if (year < 2022 || (year == 2022 && mon < 8)) {
				e.salary = e.salary + (e.salary * 0.25);
			}
		}
		Collections.sort(emp);
		System.out.println(emp);
	}
}