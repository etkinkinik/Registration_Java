package tr.edu.ozyegin.registration.object;

public class Student {
	
	private String studentNumber; // Data Members
	private String name; // Data Members
	
	public Student(String studentNumber, String name) { // Constructors
		this.studentNumber = studentNumber;
		this.name = name;
	}

	public String getStudentNumber() { // Methods
		return studentNumber;
	}

	public String getName() { // Methods
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student)obj;
			
			return this.studentNumber.equals(other.studentNumber);
		} else {
			return false;
		}
	}
	
}
