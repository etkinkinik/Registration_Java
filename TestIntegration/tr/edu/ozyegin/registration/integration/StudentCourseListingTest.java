package tr.edu.ozyegin.registration.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.main.ServiceFactory;
import tr.edu.ozyegin.registration.object.Course;
import tr.edu.ozyegin.registration.presentation.StudentService;

class StudentCourseListingTest {

	private StudentService studentService;
	
	@BeforeEach
	void setUp() throws Exception {
		ServiceFactory.reset();
		this.studentService = ServiceFactory.buildStudentService();
	}

	@Test
	void testSuccessfulListing() throws RegistrationException {
		List<Course> courses = this.studentService.coursesAvailableToStudent("OU2020656211");

		assertEquals(38, courses.size());
	}

}
