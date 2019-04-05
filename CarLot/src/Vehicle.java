
public abstract class Vehicle {
	//declaration for abstract class
	
	//variables for abstract class vehicle
	private String licenseNbr;
	private String make;
	private String model;
	private Double price;
	
	
	//constructor for abstract class vehicles
	public Vehicle(String licenseNbr, String make, String model, Double price) {
		this.licenseNbr = licenseNbr;
		this.make = make;
		this.model = model;
		this.price = price;
	}
	
	//getters and setters for the class
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public void printVehicleDescription() {
		//print method for class vehicle.  called from any subclasses. 
		System.out.println("Make:            " + this.getMake());
		System.out.println("Model:           " + this.getModel());
		System.out.println("License Number:  " + this.getLicenseNbr());
		System.out.println("Price:           " + String.format ( "$ %(,.2f", this.getPrice()));
	}
}
