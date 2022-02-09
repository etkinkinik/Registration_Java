package tr.edu.ozyegin.registration.object;

public class Registration {
	private Student registeredStudent;
	private Course registeredCourse;
	
	public Registration(Student student, Course course) {
		this.registeredStudent = student;
		this.registeredCourse = course;
	}

	public Student getRegisteredStudent() {
		return registeredStudent;
	}

	public Course getRegisteredCourse() {
		return registeredCourse;
	}
	
}
