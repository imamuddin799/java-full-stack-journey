package oop_concepts_08.constructor_02.nov_04;

public class JobMela02 {

	/**
	String name;
	int id;
	double tenth;
	double twelth;
	double degree;
	*/
	public static void main(String[] args){
		Student01 s1 = new Student01("Imam", 1, 64.0);
		s1.details();
		
		Student01 s2 = new Student01("Uddin", 2, 64.0, 55.0);
		s2.details();
		
		Student01 s3 = new Student01("Ansari", 3, 64.0, 55.0, 55.7);
		s3.details();
	}
}
