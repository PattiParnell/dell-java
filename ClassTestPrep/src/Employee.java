
public class Employee {
private String employeeName;
private String jobTitle;
private int ID ;

private static int NEXTID = 100;
public Employee (String myEmployeeName, String myJobTitle) {
	this.setEmployeeName(myEmployeeName);
	this.setJobTitle(myJobTitle);
	this.ID  = NEXTID;
	
	NEXTID++;
	
}

public int getID() {
	return ID;
}

public void setID(int myID) {
	ID = myID;
}

public void setJobTitle (String myJobTitle) {
	this.jobTitle = myJobTitle;
	
}

public String getJobTitle () {
	return this.jobTitle;
	
}

public void setEmployeeName (String myEmpName) {
	this.employeeName = myEmpName;
	
}

public String getEmployeeName () {
	return this.employeeName;
	
}




}
