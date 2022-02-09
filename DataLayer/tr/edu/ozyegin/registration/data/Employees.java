package tr.edu.ozyegin.registration.data;

import java.util.ArrayList;
import java.util.List;

import tr.edu.ozyegin.registration.object.Employee;
import tr.edu.ozyegin.registration.object.Professor;

public class Employees {

	private List<Employee> employees;
	
	public Employees() {
		
		this.employees = new ArrayList<Employee>();
		this.employees.add(new Professor("1227", "Yasar Safkan"));
		
	}

	public Employee getEmployeeById(String employeeId) {
	
		for(Employee employee : this.employees) {
			if(employee.getEmployeeId().equals(employeeId)) {
				return employee;
			}
		}
		return null;
	}
		
}