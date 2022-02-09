package tr.edu.ozyegin.registration.object;

public class Professor extends Employee {
	// eger canTeachCourses methodunu silersek class error vericek bu sorunu gidermenin iki yolu var:
	// 1- canTeachCourses'i tekrardan Professor class'ina yazicaz
	// 2- Professor class'ini abstract class yapicaz. (Yani public abstract class Professor extends Employee)
	public Professor(String employeeId, String fullName) {
		// TODO Auto-generated constructor stub
		
		this.employeeId = employeeId;
		this.fullName = fullName;
	}

	
	@Override
	public boolean canTeachCourses() {
		return true;
	}

	@Override
	public boolean canAdministerCourses() {
		return false;
	}

}
