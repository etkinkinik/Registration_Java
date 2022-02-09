package tr.edu.ozyegin.registration.object;

public class Administrator extends Employee {

	public Administrator() {
	}

	@Override
	public boolean canTeachCourses() {
		return false;
	}

	@Override
	public boolean canAdministerCourses() {
		return true;
	}

}
