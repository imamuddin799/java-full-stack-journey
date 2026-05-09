package oop_concepts_08.basic_oop_01.oct_30;

public class School04 {

	// Declaring max method to find rank 1 Student03 details based on total marks
	public static Student03 max(Student03 a, Student03 b, Student03 c) {
		if (a.percentage > b.percentage && a.percentage > c.percentage)
			return a;
		else if (b.percentage > c.percentage)
			return b;
		else
			return c;
	}

	// Declaring min method to find rank 3 Student03 details based on total marks
	public static Student03 min(Student03 a, Student03 b, Student03 c) {
		if (a.percentage < b.percentage && a.percentage < c.percentage)
			return a;
		else if (b.percentage < c.percentage)
			return b;
		else
			return c;
	}

	// Declaring max method to find rank 2 Student03 details based on total marks
	public static Student03 sec(Student03 a, Student03 b, Student03 c) {
		Student03 max = max(a, b, c);
		Student03 min = min(a, b, c);
		if (a.percentage > min.percentage && a.percentage < max.percentage)
			return a;
		else if (b.percentage > min.percentage && b.percentage < max.percentage)
			return b;
		else
			return c;
	}

	// Main method starts here
	public static void main(String[] args) {

		// Creating 1st Student03 object
		Student03 s1 = new Student03();

		// Initializing values of object 1st
		s1.name = "Raja";
		s1.id = 1;
		s1.english = 65;
		s1.maths = 67;
		s1.science = 67;
		s1.socialScience = 86;
		s1.totalMarks = s1.totalMarks();
		s1.percentage = s1.percentage();

		// Creating 2nd Student03 object
		Student03 s2 = new Student03();

		// Initializing values of object 2nd
		s2.name = "Rani";
		s2.id = 2;
		s2.english = 55;
		s2.maths = 77;
		s2.science = 57;
		s2.socialScience = 56;
		s2.totalMarks = s2.totalMarks();
		s2.percentage = s2.percentage();

		// Creating 3rd Student03 object
		Student03 s3 = new Student03();

		// Initializing values of object 3rd
		s3.name = "Rajkumar";
		s3.id = 3;
		s3.english = 85;
		s3.maths = 67;
		s3.science = 67;
		s3.socialScience = 87;
		s3.totalMarks = s3.totalMarks();
		s3.percentage = s3.percentage();

		// calling max method and storing object reference of Student03 who got rank 1
		Student03 max = max(s1, s2, s3);

		// calling max method and storing object reference of Student03 who got rank 3
		Student03 min = min(s1, s2, s3);

		// calling max method and storing object reference of Student03 who got rank 2
		Student03 sec = sec(s1, s2, s3);

		// Now printing all the details of the Student03s based on rank they got
		System.out.println("------------------------------------");
		System.out.println("Rank 1 Student Details : ");
		max.details();
		System.out.println("------------------------------------");
		System.out.println("Rank 2 Student Details : ");
		sec.details();
		System.out.println("------------------------------------");
		System.out.println("Rank 3 Student Details : ");
		min.details();
		System.out.println("------------------------------------");
	}
}
