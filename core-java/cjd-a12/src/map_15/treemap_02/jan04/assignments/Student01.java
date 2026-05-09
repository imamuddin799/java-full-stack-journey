package map_15.treemap_02.jan04.assignments;

public class Student01 {

	int id;
	String name;
	double marks;
	int rank;

	public Student01(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public String toString() {
		return "\nStudent [id=" + id + ", name=" + name + ", marks=" + marks + ", rank=" + rank + "]";
	}
}