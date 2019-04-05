
public class Car extends Vehicle {
	//variables for class car
	private String type;
	private Integer doorNumber;
	
	
	//constructor for car
	public Car(String licenseNbr, String make, String model, Double price, String type, Integer doorNumber) {
		super(licenseNbr, make, model, price); //call to constructor for abstract class vehicles
		this.type = type;
		this.doorNumber = doorNumber;
	}
	
	//getters and setters for car
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(Integer doorNumber) {
		this.doorNumber = doorNumber;
	}
	
	public void printVehicleDescription() {
		//print routine for car.
		//first calls print routine for abstract class vehicle.
		
		super.printVehicleDescription();
		System.out.println("Type:            " + this.getType());
		System.out.println("Number of Doors: " + this.getDoorNumber());
		System.out.println("");
	}
}
