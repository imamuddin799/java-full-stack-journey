package collection_13.list_01.arraylist_01.sorting.dec_24;

public class Employee01 implements Comparable<Employee01> {

	int id;
	String name;
	double salary;
	String dOJ;// Date of Joining

	public Employee01(int id, String name, double salary, String dOJ) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dOJ = dOJ;
	}

	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", dOJ=" + dOJ + "]";
	}

	public int compareTo(Employee01 o) {
		return this.name.compareTo(o.name);
	}
}