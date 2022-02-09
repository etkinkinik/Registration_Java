package tr.edu.ozyegin.registration.business;

import java.util.List;

import tr.edu.ozyegin.registration.data.Courses;
import tr.edu.ozyegin.registration.data.Employees;
import tr.edu.ozyegin.registration.data.Registrations;
import tr.edu.ozyegin.registration.data.Students;
import tr.edu.ozyegin.registration.object.Course;
import tr.edu.ozyegin.registration.object.Employee;
import tr.edu.ozyegin.registration.object.Student;

public class ProfessorCourseRegistrationsManager {

	private Courses courses;
	private Registrations registrations;
	private Students students;
	private Employees employees;
	
	public ProfessorCourseRegistrationsManager() {
	}
	
	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public void setRegistrations(Registrations registrations) {
		this.registrations = registrations;
	}

	public void setStudents(Students students) {
		this.students = students;
	}
	
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public List<Student> studentsRegisteredForCourse(String employeeId, String courseCode) throws RegistrationException {
		//TODO: Check that professor with employeeId actually exists and is teaching the course given.
		
		Employee employee = this.employees.getEmployeeById(employeeId);
		
		if (employee == null) {
			throw new RegistrationException("Trying to get students registered for course with code " + courseCode + 
                    " but the employee with Id " + employeeId  + " does not exist.");
		}
		
		if (!employee.canTeachCourses()) {
			throw new RegistrationException("Trying to get students registered for course with code " + courseCode + 
                    " but the employee with Id " + employeeId  + " is not allowed to teach courses.");
			
		}
		
		Course course = this.courses.getCourseWithCode(courseCode);
		
		if (course == null) {
			throw new RegistrationException("Trying to get students registered for course with code " + courseCode + 
					                        " but the course does not exist.");
		}		

		List<String> studentNumbers = this.registrations.retrieveStudentNumbersRegisteredForCourse(course);
		
		List<Student> studentList = this.students.retrieveStudents(studentNumbers);
		
		return studentList;
	}
}
