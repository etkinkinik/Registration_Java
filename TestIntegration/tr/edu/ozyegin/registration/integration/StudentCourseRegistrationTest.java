package tr.edu.ozyegin.registration.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.enumeration.RegistrationResult;
import tr.edu.ozyegin.registration.main.ServiceFactory;
import tr.edu.ozyegin.registration.presentation.StudentService;

class StudentCourseRegistrationTest {

	private StudentService studentService;
	
	@BeforeEach
	void setUp() throws Exception {
		ServiceFactory.reset();
		this.studentService = ServiceFactory.buildStudentService();
	}

	@Test
	void testRegistrationSuccessful() throws RegistrationException {
		RegistrationResult result = this.studentService.registerStudentForCourse("OU2020657231", "CS 102");
		
		assertEquals(RegistrationResult.REGISTRATION_SUCCESSFUL, result);
	}

	@Test
	void testAlreadyRegistered() throws RegistrationException {
		this.studentService.registerStudentForCourse("OU2020657231", "CS 102");
		
		RegistrationResult result = this.studentService.registerStudentForCourse("OU2020657231", "CS 102");
		
		assertEquals(RegistrationResult.ALREADY_REGISTERED, result);
	}

	@Test
	void testStudentDoesNotExist() {
		
		try {
			this.studentService.registerStudentForCourse("XXX", "CS 102");
			fail("The call should have thrown an exception.");
		} catch (RegistrationException e) {
			// Success
		} catch (Exception e) {
			fail("An unexpected kind of exception was thrown. Should have thrown RegistrationException.");
		}
		
	}
	
	
	
}
