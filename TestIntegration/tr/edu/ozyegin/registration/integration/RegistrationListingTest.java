package tr.edu.ozyegin.registration.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.main.ServiceFactory;
import tr.edu.ozyegin.registration.object.Course;
import tr.edu.ozyegin.registration.presentation.StudentService;

class RegistrationListingTest {

	private StudentService studentService;
	
	@BeforeEach
	void setUp() throws Exception {
		ServiceFactory.reset();
		this.studentService = ServiceFactory.buildStudentService();
		this.studentService.registerStudentForCourse("OU2020657231", "CS 102");
		this.studentService.registerStudentForCourse("OU2020657231", "MATH 212");
	}

	@Test
	void testRegistrations() throws RegistrationException {
		List<Course> courseList = this.studentService.listRegisteredCoursesForStudent("OU2020657231");

		assertEquals(2, courseList.size());
		
		Course c1 = courseList.get(0);
		
		assertTrue(c1.getCode().equals("CS 102") || c1.getCode().equals("MATH 212"));

		Course c2 = courseList.get(1);
		
		assertTrue(c2.getCode().equals("CS 102") || c2.getCode().equals("MATH 212"));
		
	}

}
