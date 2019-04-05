
public class Truck extends Vehicle {
	//variables for class Truck
	private String bedSize; 
	
	//constructor for car
	public Truck(String licenseNbr, String make, String model, Double price, String bedSize) {
		super(licenseNbr, make, model, price);
		this.bedSize = bedSize;
	}

	//getters and setters for truck
	public String getBedSize() {
		return bedSize;
	}

	public void setBedSize(String bedSize) {
		this.bedSize = bedSize;
	}

	
	public void printVehicleDescription() {
		//print routine for car.
		//first calls print routine for abstract class vehicle.
		
		super.printVehicleDescription();
		System.out.println("Bed size:        " + this.getBedSize());
		System.out.println("");

	}

}
