package tr.edu.ozyegin.registration.object;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RegistrationTest {

	private Registration registration;
	
	@BeforeEach
	void setup() {
		Student student = new Student("12345", "Yasar Safkan");
		Course course = new Course("CS 102", "Object Oriented Programming", 6);
		
		this.registration = new Registration(student, course);
	}
	
	@Test
	void testStudentRegistered() {
		Student myStudent = new Student("12345", "Yasar Safkan");
		
		assertEquals(myStudent, this.registration.getRegisteredStudent());
	}
	
	@Test
	void testCourseRegistered() {
		Course myCourse = new Course("CS 102", "Object Oriented Programming", 6);
		
		assertEquals(myCourse, this.registration.getRegisteredCourse());
	}
	

}
