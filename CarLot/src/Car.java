
public class Car extends Vehicle {

	private String type;
	private Integer doorNumber;
	
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
		super.printVehicleDescription();
		System.out.println("Type:            " + this.getType());
		System.out.println("Number of Doors: " + this.getModel());
	}
}
