
public class Room implements Rentable {
	// class for Room that implements Rentable
	// has variable for dailyRate

	private Double dailyRate; // holds daily rate for rentable item
	private String description; // holds item description.

	// constructor for Room
	public Room(String myDescription, Double myDailyRate) {
		// sets the description and rate for the room

		this.setDescription(myDescription);
		this.setDailyRate(myDailyRate);
	}

	// getters and setters for room
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String myDescription) {
		this.description = myDescription;
	}

	public Double getDailyRate() {

		return this.dailyRate;
	}

	public void setDailyRate(Double myRate) {
		this.dailyRate = myRate;
	}

	public Double getPrice(Double days) {
		// returns price for room based on the number of days user requests.
		return this.getDailyRate() * days;
	}

}
