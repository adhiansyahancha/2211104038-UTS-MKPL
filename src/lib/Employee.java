package lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Sengaja dibuat untuk kelas data
public class Employee {
	public String firstName;
	public String lastName;
	public String employeeId;
	public String idNumber;
	public String address;
	public Gender gender;
	public boolean isForeigner;
	public LocalDate dateJoined;
	public EmployeeFamily family;
	
	public Employee(String firstName, String lastName, String employeeId,  String idNumber, String address, String dateJoined, boolean isForeigner, Gender gender, EmployeeFamily family) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.idNumber = idNumber;
		this.address = address;
		this.isForeigner = isForeigner;
		this.gender = gender;
		this.family = family;

		// Waktu diharapkan ditulis dalam ISO 8601
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		this.dateJoined = LocalDate.parse(dateJoined, f);
	}
}
