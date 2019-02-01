public class Car {
	
	//private variables for class Car
	private String color;
	private String licenseNbr;
	private String make;
	private String model;

	public Car () {
		//basic constructor for class Car.  Calls other constructor to set initial values.
		this("Unknown", "Unknown", "Unknown", "Unknown" );	
	}

	public Car (String myColor, String myLicenseNbr, String myMake, String myModel) {
		//constructor for Class car
		
		this.setColor(myColor);
		this.setLicenseNbr(myLicenseNbr);
		this.setMake(myMake);
		this.setModel(myModel);

	}
	
	//	getters and setters 
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getLicenseNbr() {
		return licenseNbr;
	}
	public void setLicenseNbr(String licenseNbr) {
		this.licenseNbr = licenseNbr;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}