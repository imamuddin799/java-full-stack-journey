package collection_13.list_01.arraylist_01.sorting.dec_24.assignment;

public class Student01 implements Comparable<Student01> {

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

	public int compareTo(Student01 o) {
		if(this.marks < o.marks)
			return 1;
		if(this.marks > o.marks)
			return -1;
		else {
			if(this.name.compareTo(o.name) > 0) {
				return 1;
			}
			else if(this.name.compareTo(o.name) < 0) {
				return -1;
			}
			else {
				if(this.id > o.id) {
					return 1;
				}
				else if(this.id < o.id) {
					return -1;
				}
				else
					return 0;
			}
		}
	}
}