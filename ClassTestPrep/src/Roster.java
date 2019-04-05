import java.util.ArrayList;
import java.util.List;

public class Roster {
	
	private List<Employee> roster;
	
	public Roster () {
		this.roster = new  ArrayList<>();
	}
	
	public List<Employee> getRoster () {
		return this.roster;
		
	}
	
	
	public void addEmployee(Employee toAdd) {
		roster.add(toAdd);
	}

}
