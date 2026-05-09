package collection_13.list_01.arraylist_01.sorting.dec_24;

public class Students03 implements Comparable<Students03> {

//	int id;
//	String name;
//	int marks;
//	int rank;
//	
//	public Students(int id, String name, int marks) {
//		this.id = id;
//		this.name = name;
//		this.marks = marks;
//	}
//
//	public int compareTo(Students o) {
//		return o.marks-this.marks;
//	}
//
//	public String toString() {
//		return "\nStudents [id=" + id + ", name=" + name + ", marks=" + marks + ", rank=" + rank + "]";
//	}

	int id;
	String name;
	double marks;
	int rank;

	public Students03(int id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return "\nStudents [id=" + id + ", name=" + name + ", marks=" + marks + ", rank=" + rank + "]";
	}

	public int compareTo(Students03 o) {
		if (this.marks > o.marks)
			return -1;
		if (this.marks < o.marks)
			return 1;
		return 0;
	}

//	we will use this if we will not implement the comparable with generic
//	public int compareTo(Object o) {
//		Students s = (Students03) o;
//		return 0;
//	}

}