package tr.edu.ozyegin.registration.data;

import java.util.ArrayList;
import java.util.List;

import tr.edu.ozyegin.registration.object.Student;

public class Students {
	
	private List<Student> students;
	
	public Students() {
		this.students = new ArrayList<Student>();
		
		this.students.add(new Student("OU2020656211", "Mehmet Öztürk")); 
		this.students.add(new Student("OU2020657231", "Ayşe Demir")); 
		this.students.add(new Student("OU2020856217", "Cansu Çelik"));
		
		
	}
	
	public Student getStudentWithNumber(String studentNumber) {
		for (Student s : this.students) {
			if (s.getStudentNumber().equals(studentNumber)) {
				return s;
			}
		}
		
		return null;
	}
	
	public List<Student> retrieveStudents(List<String> studentNumbers) {
		List<Student> studentList = new ArrayList<Student>();
		
		for (String studentNumber : studentNumbers) {
			Student student = this.getStudentWithNumber(studentNumber);
			
			if (student == null) {
				// This should not normally happen. 
				throw new RuntimeException("The student number " + studentNumber + " does not have a corresponding student. This is unexpected.");
			}

			studentList.add(student);
		}
		
		return studentList;
	}
	
}
