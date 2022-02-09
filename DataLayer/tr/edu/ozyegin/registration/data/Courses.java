package tr.edu.ozyegin.registration.data;

import java.util.ArrayList;
import java.util.List;

import tr.edu.ozyegin.registration.object.Course;

public class Courses {
	
	private List<Course> courses;
	
	public Courses() {
		this.courses = new ArrayList<Course>();
	
		this.courses.add(new Course("CS 101", "Computer Programming", 6));
		this.courses.add(new Course("ENG 101", "English I", 4));
		this.courses.add(new Course("MATH 103",	"Calculus for Engineering I", 8));
		this.courses.add(new Course("PHYS 101",	"Physics I", 8));
		this.courses.add(new Course("TLL 101", "Turkish Language and Literature I", 4));
		this.courses.add(new Course("BUS 101", "Introduction to Business I (Decision Making)", 4));
		this.courses.add(new Course("CS 102", "Object-Oriented Programming", 6));
		this.courses.add(new Course("ENG 102", "English II", 3));
		this.courses.add(new Course("MATH 104", "Calculus for Engineering II", 8));	
		this.courses.add(new Course("PHYS 102", "Physics II", 8));
		this.courses.add(new Course("SEC 101", 	"Introduction to University", 1));
		this.courses.add(new Course("CS 112", "Discrete Mathematics for Computer Science", 6));
		this.courses.add(new Course("CS 201", "Data Structures and Algorithms", 6));
		this.courses.add(new Course("EE 203", "Digital Systems", 6));
		this.courses.add(new Course("MATH 212", "Differential Equations", 6));
		this.courses.add(new Course("SEC 201", "Introduction to Sectors", 2));
		this.courses.add(new Course("TLL 102", 	"Turkish Language and Literature II", 4));
		this.courses.add(new Course("CS 202", "Database Management Systems", 6));
		this.courses.add(new Course("CS 240", "Computer Architecture", 	6));
		this.courses.add(new Course("HIST 201",	"Principles of Ataturk and History of the Turkish Republic I", 4));
		this.courses.add(new Course("MATH 211", "Linear Algebra", 6));
		this.courses.add(new Course("MATH 217", "Probability and Statistics", 6));
		this.courses.add(new Course("SEC 202", "Skills Management", 2));
		this.courses.add(new Course("CS 320", "Software Engineering", 6));
		this.courses.add(new Course("CS 321", "Programming Paradigms", 6));
		this.courses.add(new Course("CS 447", "Computer Networks", 6));
		this.courses.add(new Course("ENG 303", "Technical Communication", 2));
		this.courses.add(new Course("CS 300", "Summer Training I", 2));
		this.courses.add(new Course("CS 333", "Analysis of Algorithms", 6));
		this.courses.add(new Course("CS 350", "Operating Systems", 6));
		this.courses.add(new Course("ECON 210", "Introduction to Economics", 6));
		this.courses.add(new Course("FE 101", "Being an Engineer", 2));
		this.courses.add(new Course("HIST 202", "Principles of Ataturk and History of the Turkish Republic II", 4));
		this.courses.add(new Course("BUS 102", "Introduction to Business II (Entrepreneurship)", 4));
		this.courses.add(new Course("CS 400", "Summer Training II", 4));
		this.courses.add(new Course("CS 401", "Computer Science Senior Project I", 4));
		this.courses.add(new Course("CS 410", "Automata Theory and Formal Languages", 6));
		this.courses.add(new Course("CS 402", "Computer Science Senior Project II", 4));
	}
	
	
	public List<Course> getAllCourses() {
		return this.courses;
	}
	
	public List<Course> getCoursesWithPrefix(String prefix) {
		
		ArrayList<Course> coursesWithPrefix = new ArrayList<Course>();
		
		// This is a "foreach" loop
		for (Course c : this.courses) {
			if (c.getCode().startsWith(prefix)) {
				coursesWithPrefix.add(c);
			}
		}
		
		return coursesWithPrefix;
	}
	
	public Course getCourseWithCode(String code) {
		for (Course c : this.courses) {
			if (c.getCode().equals(code)) {
				return c;
			}
		}
		
		return null;
	}
	
	public List<Course> searchForCourseByTitle(String partialTitle) {
		ArrayList<Course> coursesFound = new ArrayList<Course>();
		
		for (Course c : this.courses) {
			if (c.getTitle().contains(partialTitle)) {
				coursesFound.add(c);
			}
		}
		
		return coursesFound;
	}

	public List<Course> retrieveCourses(List<String> courseCodes) {
		//Since if it is a RuntimeException, it is a uncheck exception. We dont have to declare it.
		//Why we used RuntimeException because we dont want it as a checked exception because i dont want to handle it anywhere.
		List<Course> courseList = new ArrayList<Course>();
		
		for (String courseCode : courseCodes) {
			Course course = this.getCourseWithCode(courseCode);
			
			if (course == null) {
				// This should not normally happen. 
				throw new RuntimeException("The course code " + courseCode + " does not have a corresponding course. This is unexpected.");
			}
	
			courseList.add(course);
		}
		
		
		return courseList;
	}
	
}
