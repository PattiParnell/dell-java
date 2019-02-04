
public class Condo implements Rentable {

	private String description;
	private Double weeklyRate;

	public Condo(String myDescription, Double myWeeklyRate) {
		this.setDescription(myDescription);
		this.setWeeklyRate(myWeeklyRate);
	}

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

		return weeklyRate / 7;
	}

	public Double getPrice(Double days) {

		return this.getDailyRate() * days;

	}

}
