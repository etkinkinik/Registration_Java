package tr.edu.ozyegin.registration.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tr.edu.ozyegin.registration.data.dbobjects.RegistrationData;
import tr.edu.ozyegin.registration.object.Course;
import tr.edu.ozyegin.registration.object.Registration;
import tr.edu.ozyegin.registration.object.Student;

public class Registrations {

	private Set<RegistrationData> registrationData;
	
	public Registrations() {
		this.registrationData = new HashSet<RegistrationData>();
		
	}

	/**
	 * Save the given registration to the database, given it does not
	 * already exist.
	 * 
	 * @param registration Registration to be saved to the database.
	 * @return true if successful, false if it already exists.
	 */
	public boolean saveRegistration(Registration registration) {
		RegistrationData data = new RegistrationData();
		
		data.setCourseCode(registration.getRegisteredCourse().getCode());
		data.setStudentNumber(registration.getRegisteredStudent().getStudentNumber()); 

		if (registrationData.contains(data)) {
			return false;
		} else {
			registrationData.add(data);
			return true;
		}
	}
	
	public boolean cancelRegistration(Registration registration) {
		RegistrationData data = new RegistrationData();
		
		data.setCourseCode(registration.getRegisteredCourse().getCode());
		data.setStudentNumber(registration.getRegisteredStudent().getStudentNumber()); 
		
		return registrationData.remove(data);
	}
	
	public List<String> retrieveCourseCodesRegisteredByStudent(Student student) {
		
		List<String> courseCodesRegisteredByStudent = new ArrayList<String>();
		
		for (RegistrationData data : this.registrationData) {
			if (data.getStudentNumber().equals(student.getStudentNumber())) {
				courseCodesRegisteredByStudent.add(data.getCourseCode());
			}
		}
		
		return courseCodesRegisteredByStudent;
	}
	
	public List<String> retrieveStudentNumbersRegisteredForCourse(Course course) {
		List<String> studentNumbersRegisteredForCourse = new ArrayList<String>();
		
		for (RegistrationData data : this.registrationData) {
			if (data.getCourseCode().equals(course.getCode())) {
				studentNumbersRegisteredForCourse.add(data.getStudentNumber());
			}
		}
		
		return studentNumbersRegisteredForCourse;
	}
	
	
}
