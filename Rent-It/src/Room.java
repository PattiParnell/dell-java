
public class Room implements Rentable {
	//class for Room that implements Rentable
	//has variable for dailyRate
	private Double dailyRate;
	private String description;

	
	//constructors for Room
	public Room(String myDescription, Double myDailyRate) {
		//sets the description and rate for the room
		
		this.setDescription(myDescription);
		this.setDailyRate(myDailyRate);
	}

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

		return this.getDailyRate() * days;
	}

}
