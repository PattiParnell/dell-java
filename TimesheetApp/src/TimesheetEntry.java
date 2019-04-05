import java.time.LocalDateTime;

public class TimesheetEntry {
	//properties of timesheet entry
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	private static int NEXTID = 1; //holds value of the next ID to be added.
	
	//constructor for TimesheetEntry
	public TimesheetEntry (String myProject, String myTask) {
		
		this.setProjectName(myProject);
		this.setTask(myTask);
		this.setStartTime(LocalDateTime.now()); //sets start time to Now.
		this.setId(NEXTID);
		
		NEXTID++;
		
	}
	
	//getters and setters for timesheet entry;
	
	public String getProjectName() {
		return projectName;
	}

	private void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTask() {
		return task;
	}

	private void setTask(String task) {
		this.task = task;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	private void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	private void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public void updateEndTime() {
		if (this.getEndTime() == null) {
			this.setEndTime(LocalDateTime.now());
		}
			
	}




}
