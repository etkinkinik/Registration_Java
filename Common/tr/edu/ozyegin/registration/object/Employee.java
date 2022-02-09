package tr.edu.ozyegin.registration.object;

public abstract class Employee {
	// abstract class can not be instantiated. Abstract class allows me to introduce a abstract methods into this class.
	// methods which dont have bodies are just abstract method.
	// abstract class is only useful to be extended by other classes.
	protected String employeeId; // private employeeId --> is just for Employee abstract class so we can not write into other class.
	protected String fullName;	 // protected employeeId --> we can reach this string into a subclass
								 // but we cant reach in other classes which are not sub class of Employee

	public Employee() {
		
	}

	public String getEmployeeId() {
		return employeeId;
	}
	
	public String getFullName() {
		return fullName;
	}

	public abstract boolean canTeachCourses();
	
	public abstract boolean canAdministerCourses();

	
	
}
