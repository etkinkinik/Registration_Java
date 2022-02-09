package tr.edu.ozyegin.registration.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.enumeration.RegistrationCancellationResult;
import tr.edu.ozyegin.registration.main.ServiceFactory;
import tr.edu.ozyegin.registration.presentation.StudentService;

class RegistrationCancellationTest {

	private StudentService studentService;
	
	@BeforeEach
	void setUp() throws Exception {
		ServiceFactory.reset();
		this.studentService = ServiceFactory.buildStudentService();
		this.studentService.registerStudentForCourse("OU2020657231", "CS 102");
		this.studentService.registerStudentForCourse("OU2020657231", "MATH 212");
	}

	@Test
	void testSuccessfulCancellation() throws RegistrationException {
		RegistrationCancellationResult result = this.studentService.cancelStudentRegistrationForCourse("OU2020657231", "CS 102");

		assertEquals(RegistrationCancellationResult.CANCELLATION_SUCCESSFUL, result);
	}
	
	@Test
	void testFailedCancellation() throws RegistrationException {
		RegistrationCancellationResult result = this.studentService.cancelStudentRegistrationForCourse("OU2020657231", "SEC 202");

		assertEquals(RegistrationCancellationResult.NOT_REGISTERED, result);
	}

	

}
