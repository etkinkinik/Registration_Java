package tr.edu.ozyegin.registration.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import tr.edu.ozyegin.registration.business.RegistrationException;
import tr.edu.ozyegin.registration.object.Course;
import tr.edu.ozyegin.registration.presentation.StudentService;

public class Main {

	
	public static void main(String[] args) throws RegistrationException, IOException {
		StudentService studentService = new StudentService();

		System.out.println("Enter student number:");
		// system icersine user olarak yazmak icin BufferedReader i kullaniyoruz bunu kullanirken
		// IOExceptioninda yazmak gerekiyor.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String studentNumber = bufferedReader.readLine();
		
		List<Course> courses = studentService.coursesAvailableToStudent(studentNumber);
		
		for (Course c : courses) {
			System.out.println("Course " + c.getCode() + " Credits " + c.getCredits() + " Title " + c.getTitle());
		}
		
		
	}

}
