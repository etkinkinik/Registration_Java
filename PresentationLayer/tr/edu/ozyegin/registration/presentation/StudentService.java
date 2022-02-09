package tr.edu.ozyegin.registration.presentation;

import java.util.List;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.business.StudentCoursesManager;
import tr.edu.ozyegin.registration.enumeration.RegistrationCancellationResult;
import tr.edu.ozyegin.registration.enumeration.RegistrationResult;
import tr.edu.ozyegin.registration.object.Course;

public class StudentService {

	private StudentCoursesManager studentCoursesManager;
	
	public StudentService() {
	}
	
	
	public void setStudentCoursesManager(StudentCoursesManager studentCoursesManager) {
		this.studentCoursesManager = studentCoursesManager;
	}


	public List<Course> coursesAvailableToStudent(String studentNumber) throws RegistrationException {
		// TODO: Validate the student number before calling the business layer
		// for correct format. If the number is not in the correct format,
		// produce a meaningful error.
		
		List<Course> courses = this.studentCoursesManager.coursesAvailableToStudent(studentNumber);
		
		return courses;
	}

	
	// The result of the registration attempt could be:
	// The following are "regular" business results. As such, they are not Exceptions.
	// - Student is already registered to the course. (We do not want double registrations.)
	// - Student is not allowed to register to the course.
	// - Student is successfully registered to the course.
	// The following are "unexpected" business results. These are exception conditions.
	// - The student number does not exist.
	// - The course code does not exist.
	
	public RegistrationResult registerStudentForCourse(String studentNumber, String courseCode) throws RegistrationException {
		// TODO: Validation for correct format of student number and course code
		// should happen here, before we send it back to the business layer.
		
		// Very basic checking:
		
		if (studentNumber == null) {
			throw new IllegalArgumentException("The argument studentNumber can not be null.");
		}
		
		if (courseCode == null) {
			throw new IllegalArgumentException("The argument courseCode can not be null");
		}
		
		return this.studentCoursesManager.registerStudentForCourse(studentNumber, courseCode);
	}
	
	public RegistrationCancellationResult cancelStudentRegistrationForCourse(String studentNumber, String courseCode) throws RegistrationException {
		// Very basic checking:
		
		if (studentNumber == null) {
			throw new IllegalArgumentException("The argument studentNumber can not be null.");
		}
		
		if (courseCode == null) {
			throw new IllegalArgumentException("The argument courseCode can not be null");
		}

		return this.studentCoursesManager.cancelStudentRegistrationForCourse(studentNumber, courseCode);
		
	}
	
	public List<Course> listRegisteredCoursesForStudent(String studentNumber) throws RegistrationException {

		// Very basic checking:
		
		if (studentNumber == null) {
			throw new IllegalArgumentException("The argument studentNumber can not be null.");
		}
		
		return this.studentCoursesManager.listRegisteredCoursesForStudent(studentNumber);
	}

}
