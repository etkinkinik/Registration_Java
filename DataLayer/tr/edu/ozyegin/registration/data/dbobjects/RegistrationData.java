
package tr.edu.ozyegin.registration.data.dbobjects;

public class RegistrationData {

	
	private String studentNumber;
	private String courseCode;
	
	public RegistrationData() {
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RegistrationData) {
			RegistrationData other = (RegistrationData)obj;
			
			return this.courseCode.equals(other.courseCode) && this.studentNumber.equals(other.studentNumber);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.courseCode.hashCode()*91 + this.studentNumber.hashCode()*129;
	}
	
	
}
