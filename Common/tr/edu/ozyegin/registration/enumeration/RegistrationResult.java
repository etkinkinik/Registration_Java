package tr.edu.ozyegin.registration.enumeration;

// The result of the registration attempt could be:
// The following are "regular" business results. As such, they are not Exceptions.
// - Student is already registered to the course. (We do not want double registrations.)
// - Student is not allowed to register to the course.
// - Student is successfully registered to the course.
// The following are "unexpected" business results. These are exception conditions.
// - The student number does not exist.
// - The course code does not exist.


public enum RegistrationResult {
	REGISTRATION_SUCCESSFUL,
	ALREADY_REGISTERED,
	STUDENT_NOT_ALLOWED
		
}
