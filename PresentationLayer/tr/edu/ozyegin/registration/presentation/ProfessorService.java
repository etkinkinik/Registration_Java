package tr.edu.ozyegin.registration.presentation;

import java.util.List;

import tr.edu.ozyegin.registration.business.ProfessorCourseRegistrationsManager;
import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.object.Student;

public class ProfessorService {

	private ProfessorCourseRegistrationsManager professorCourseRegistrationsManager;
	
	public ProfessorService() {
	}
	
	public void setProfessorCourseRegistrationsManager(ProfessorCourseRegistrationsManager professorCourseRegistrationsManager) {
		this.professorCourseRegistrationsManager = professorCourseRegistrationsManager;
	}

	public List<Student> studentsRegisteredForCourse(String employeeId, String courseCode) throws RegistrationException {
		// Very basic checking:
		
		if (employeeId == null) {
			throw new IllegalArgumentException("The argument employeeId can not be null.");
		}
		
		if (courseCode == null) {
			throw new IllegalArgumentException("The argument courseCode can not be null");
		}
		
		return this.professorCourseRegistrationsManager.studentsRegisteredForCourse(employeeId, courseCode);
	}
	
}
