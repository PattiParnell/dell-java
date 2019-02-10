
public class Tool implements Rentable {
	// class for Tool that implements Rentable
	// has variable for hourlyrate

	private String description; // holds item description.
	private Double hourlyRate; // holds hourly rate for rentable item

	// constructor for tool
	public Tool(String myDescription, Double myHourlyRate) {
		// sets the description and rate for the tool
		this.setDescription(myDescription);
		this.setHourlyRate(myHourlyRate);
	}

	// getters and setters for tool
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String myDescription) {
		this.description = myDescription;
	}

	public Double getDailyRate() {
		// calculates daily rate based on hourly rate
		return this.hourlyRate * 24;
	}

	public Double getPrice(Double days) {
		// returns price for tool based on the number of days user requests.
		return this.getDailyRate() * days;
	}

	public Double getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(Double myRate) {
		this.hourlyRate = myRate;

	}
}
