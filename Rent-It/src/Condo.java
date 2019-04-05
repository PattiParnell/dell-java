
public class Condo implements Rentable {
	// class for condo that implements Rentable
	// has variable for weeklyRate

	private String description; // holds item description.
	private Double weeklyRate; // holds hourly rate for rentable item

	// constructor for Condo
	public Condo(String myDescription, Double myWeeklyRate) {
		// sets the description and rate for the room

		this.setDescription(myDescription);
		this.setWeeklyRate(myWeeklyRate);
	}

	// getters and setters for condo
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String myDescription) {
		this.description = myDescription;
	}

	public Double getWeeklyRate() {
		return this.weeklyRate;
	}

	public void setWeeklyRate(Double myRate) {
		this.weeklyRate = myRate;

	}

	public Double getDailyRate() {
		// calculates daily rate based on weekly rate
		return weeklyRate / 7;
	}

	public Double getPrice(Double days) {
		// returns price for condo based on the number of days user requests.
		return this.getDailyRate() * days;

	}

}
