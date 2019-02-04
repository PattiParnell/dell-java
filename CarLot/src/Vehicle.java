
public abstract class Vehicle {
	private String licenseNbr;
	private String make;
	private String model;
	private Double price;
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
		System.out.println("Make:            " + this.getMake());
		System.out.println("Model:           " + this.getModel());
		System.out.println("License Number:  " + this.getLicenseNbr());
		System.out.println("Price:           $" + this.getPrice());
	}
}
