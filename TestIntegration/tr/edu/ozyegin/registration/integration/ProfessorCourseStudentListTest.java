package tr.edu.ozyegin.registration.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.main.ServiceFactory;
import tr.edu.ozyegin.registration.object.Student;
import tr.edu.ozyegin.registration.presentation.ProfessorService;
import tr.edu.ozyegin.registration.presentation.StudentService;

class ProfessorCourseStudentListTest {

	private StudentService studentService;
	private ProfessorService professorService;
	
	@BeforeEach
	void setUp() throws Exception {
		ServiceFactory.reset();
		this.professorService = ServiceFactory.buildProfessorService();
		this.studentService = ServiceFactory.buildStudentService();
		this.studentService.registerStudentForCourse("OU2020657231", "CS 102");		
		this.studentService.registerStudentForCourse("OU2020657231", "MATH 212");
		this.studentService.registerStudentForCourse("OU2020856217", "MATH 212");

	}

	@Test
	void testRegistrationListForCS102() throws RegistrationException {
		List<Student> studentList = this.professorService.studentsRegisteredForCourse("1227", "CS 102");
		
		assertEquals(1, studentList.size());
		
	}

	@Test
	void testRegistrationListForMATH212() throws RegistrationException {
		List<Student> studentList = this.professorService.studentsRegisteredForCourse("1227", "MATH 212");
		
		assertEquals(2, studentList.size());
	}

	
}
