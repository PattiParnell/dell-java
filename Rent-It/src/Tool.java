
public class Tool implements Rentable {

	private String description;
	private Double hourlyRate;

	public Tool(String myDescription, Double myHourlyRate) {
		this.setDescription(myDescription);
		this.setHourlyRate(myHourlyRate);
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(String myDescription) {
		this.description = myDescription;
	}

	
	public Double getDailyRate() {

		return this.hourlyRate * 24;
	}

	
	public Double getPrice(Double days) {

		return this.getDailyRate() * days;
	}

	public Double getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(Double myRate) {
		this.hourlyRate = myRate;

	}
}
