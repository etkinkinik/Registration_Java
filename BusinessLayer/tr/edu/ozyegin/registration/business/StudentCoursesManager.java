package tr.edu.ozyegin.registration.business;

import java.util.List;

import tr.edu.ozyegin.registration.data.Courses;
import tr.edu.ozyegin.registration.data.Registrations;
import tr.edu.ozyegin.registration.data.Students;
import tr.edu.ozyegin.registration.enumeration.RegistrationCancellationResult;
import tr.edu.ozyegin.registration.enumeration.RegistrationResult;
import tr.edu.ozyegin.registration.object.Course;
import tr.edu.ozyegin.registration.object.Registration;
import tr.edu.ozyegin.registration.object.Student;

public class StudentCoursesManager {
	
	private Courses courses;
	private Students students;
	private Registrations registrations;
	
	
	public StudentCoursesManager() {
	}
	
	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public void setRegistrations(Registrations registrations) {
		this.registrations = registrations;
	}



	public List<Course> coursesAvailableToStudent(String studentNumber) throws RegistrationException {
		Student student = this.students.getStudentWithNumber(studentNumber);
		
		if (student == null) {
			throw new RegistrationException("Student with student number " + studentNumber + " does not exist.");
		}
		
		// Student has been retrieved, now need to get the course list.
		
		List<Course> courses = this.courses.getAllCourses();

		// Any filtering for courses available for the specific student should happen here.
		// Currently, there are no filters.
		
		return courses;
	}
	
	public RegistrationResult registerStudentForCourse(String studentNumber, String courseCode) throws RegistrationException {
		Student student = this.students.getStudentWithNumber(studentNumber);

		
		if (student == null) {
			throw new RegistrationException("Trying to register student to course with code " + courseCode + 
					                        " but student with student number " + studentNumber + " does not exist.");
		}

		Course course = this.courses.getCourseWithCode(courseCode);
		
		if (course == null) {
			throw new RegistrationException("Trying to register student with number " + studentNumber + 
					                        " to a course, but course with code " + courseCode + " does not exist.");
		}

		// TODO: There is no way to return RegistrationResult.STUDENT_NOT_ALLOWED because
		// rules have not been implemented. Rule checking should happen here once they are
		// in fact implemented.
		
		Registration newRegistration = new Registration(student, course);
		
		boolean registrationSuccessful = this.registrations.saveRegistration(newRegistration);
	
		if (registrationSuccessful) {
			return RegistrationResult.REGISTRATION_SUCCESSFUL;
		} else {
			return RegistrationResult.ALREADY_REGISTERED;
		}
		
	}
	
	public RegistrationCancellationResult cancelStudentRegistrationForCourse(String studentNumber, String courseCode) throws RegistrationException {
		Student student = this.students.getStudentWithNumber(studentNumber);
		
		if (student == null) {
			throw new RegistrationException("Trying to cancel student registration to course with code " + courseCode + 
					                        " but student with student number " + studentNumber + " does not exist.");
		}

		Course course = this.courses.getCourseWithCode(courseCode);
		
		if (course == null) {
			throw new RegistrationException("Trying to cancel registration of student with number " + studentNumber + 
					                        " to a course, but course with code " + courseCode + " does not exist.");
		}

		Registration registrationToBeCanceled = new Registration(student, course);


		boolean cancellationSuccessful = this.registrations.cancelRegistration(registrationToBeCanceled);

		if (cancellationSuccessful) {
			return RegistrationCancellationResult.CANCELLATION_SUCCESSFUL;
		} else {
			return RegistrationCancellationResult.NOT_REGISTERED;
		}
		
	}
	
	public List<Course> listRegisteredCoursesForStudent(String studentNumber) throws RegistrationException {
		Student student = this.students.getStudentWithNumber(studentNumber);
		
		if (student == null) {
			throw new RegistrationException("Trying to list courses registered by a student " +  
					                        " but student with student number " + studentNumber + " does not exist.");
		}

		List<String> courseCodes = this.registrations.retrieveCourseCodesRegisteredByStudent(student);

		List<Course> courseList = this.courses.retrieveCourses(courseCodes);
		
		return courseList;
	}
	
}
