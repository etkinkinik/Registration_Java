package tr.edu.ozyegin.registration.object;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StudentTest {

	private Student student;
	
	@BeforeEach
	void setup() {
		this.student = new Student("12345", "Yasar Safkan");
	}
	
	@Test
	void testStudentNumber() {
		assertEquals("12345", this.student.getStudentNumber());
	}
	
	@Test
	void testStudentName() {
		assertEquals("Yasar Safkan", this.student.getName());
	}

}
