package tr.edu.ozyegin.registration.object;

public class Course extends Object {

	private String code;
	private String title;
	private int credits;
	
	public Course(String code, String title, int credits) {
		this.code = code;
		this.title = title;
		this.credits = credits;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}
	
	public int getCredits() {
		return credits;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course other = (Course)obj;
			
			return this.code.equals(other.code);
		} else {
			return false;
		}
	}
	
}
