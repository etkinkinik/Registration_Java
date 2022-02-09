package tr.edu.ozyegin.registration.main;

import tr.edu.ozyegin.registration.business.ProfessorCourseRegistrationsManager;
import tr.edu.ozyegin.registration.business.StudentCoursesManager;
import tr.edu.ozyegin.registration.data.Courses;
import tr.edu.ozyegin.registration.data.Employees;
import tr.edu.ozyegin.registration.data.Registrations;
import tr.edu.ozyegin.registration.data.Students;
import tr.edu.ozyegin.registration.presentation.ProfessorService;
import tr.edu.ozyegin.registration.presentation.StudentService;
//being synchronized means only one execution thread can enter the method
public class ServiceFactory {

	public static void reset() {
		professorService = null;
		studentService = null;
		studentCoursesManager = null;
		professorCourseRegistrationsManager = null;
		courses = null;
		registrations = null;
		students = null;
	}
	
	private static ProfessorService professorService;
	
	public synchronized static ProfessorService buildProfessorService() {
		
		if (professorService == null) {
			professorService = new ProfessorService();
			professorService.setProfessorCourseRegistrationsManager(buildProfessorCourseRegistrationsManager());
		}
		
		return professorService;
	}

	private static StudentService studentService;
	
	public synchronized static StudentService buildStudentService() {
		
		if (studentService == null) {
			studentService = new StudentService();
			studentService.setStudentCoursesManager(buildStudentCoursesManager()); 
		}
		
		return studentService;
	}

	private static StudentCoursesManager studentCoursesManager;
	
	private synchronized static StudentCoursesManager buildStudentCoursesManager() {

		if (studentCoursesManager == null) {
			studentCoursesManager = new StudentCoursesManager();
			studentCoursesManager.setCourses(buildCourses());
			studentCoursesManager.setRegistrations(buildRegistrations());
			studentCoursesManager.setStudents(buildStudents());
		}
		
		return studentCoursesManager;
	}

	private static ProfessorCourseRegistrationsManager professorCourseRegistrationsManager;
	
	private synchronized static ProfessorCourseRegistrationsManager buildProfessorCourseRegistrationsManager() {
		if (professorCourseRegistrationsManager == null) {
			professorCourseRegistrationsManager = new ProfessorCourseRegistrationsManager();
			professorCourseRegistrationsManager.setCourses(buildCourses());
			professorCourseRegistrationsManager.setRegistrations(buildRegistrations());
			professorCourseRegistrationsManager.setStudents(buildStudents());
			professorCourseRegistrationsManager.setEmployees(buildEmployees());
		}
		
		return professorCourseRegistrationsManager;
	}

	private static Courses courses;
	
	private synchronized static Courses buildCourses() {
		if (courses == null) {
			courses = new Courses();
		}
		
		return courses;
	}

	private static Registrations registrations;

	private synchronized static Registrations buildRegistrations() {
		if (registrations == null) {
			registrations = new Registrations();
		}

		return registrations;
	}

	private static Students students;
	
	private synchronized static Students buildStudents() {
		if (students == null) {
			students = new Students();
		}
	
		return students;
	}
	
	private static Employees employees;
	
	private synchronized static Employees buildEmployees() {
		if (employees == null) {
			employees = new Employees();
		}
		
		return employees;
	}
}
