package tr.ozyegin.registration.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tr.edu.ozyegin.registration.data.Courses;
import tr.edu.ozyegin.registration.object.Course;

class CoursesTest {

	private Courses courses;
	
	@BeforeEach
	void setUp() throws Exception {
		this.courses = new Courses();
	}

	@Test
	void testGetCoursesWithPrefixEngCount() {
		List<Course> coursesWithPrefix = this.courses.getCoursesWithPrefix("ENG");
		
		assertEquals(3, coursesWithPrefix.size());
		
	}

	@Test
	void testGetCoursesWithPrefixMath() {
		List<Course> coursesWithPrefix = this.courses.getCoursesWithPrefix("MATH");
		
		for (Course c : coursesWithPrefix) {
			assertTrue(c.getCode().startsWith("MATH"));
		}
		
		assertTrue(coursesWithPrefix.size() > 0, "There should be at least one course with prefix MATH.");
	}
	
	@Test
	void testGetCourseWithCodeCs101() {
		Course cs101 = this.courses.getCourseWithCode("CS 101");
		
		assertNotNull(cs101, "The course \"CS 101\" should exist and should be returned by getCourseWithCode().");
		
		assertEquals("CS 101", cs101.getCode());
	}

	@Test
	void testSearchForCourseByTitle() {
		List<Course> coursesFound = this.courses.searchForCourseByTitle("Calculus");
		
		assertTrue(coursesFound.size() > 0, "There should be at least one Calculus course.");
		
		assertTrue(coursesFound.get(0).getCode().startsWith("MATH"), "Any Calculus course code should begin with MATH.");
		
	}
	
	
}
