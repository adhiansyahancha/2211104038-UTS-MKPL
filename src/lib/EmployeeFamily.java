package lib;

import java.util.LinkedList;
import java.util.List;

public class EmployeeFamily {
	public String spouseName;
	public String spouseIdNumber;

	public List<String> childNames;
	public List<String> childIdNumbers;

	public EmployeeFamily() {
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
}