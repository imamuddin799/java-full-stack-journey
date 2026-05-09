package objectdemo;

public class Student {

	int id;
	String name;
	double marks;
	
	
	public Student(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}


	@Override
	public String toString() {
		return id +", '"+ name +"' ,"+ marks;
	}
	
}