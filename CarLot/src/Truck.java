
public class Truck extends Vehicle {
	private String bedSize; 
	
	
	
	public String getBedSize() {
		return bedSize;
	}



	public void setBedSize(String bedSize) {
		this.bedSize = bedSize;
	}



	public void printVehicleDescription() {
		
		super.printVehicleDescription();
		System.out.println("Bed size:        " + this.getBedSize());

	}

}
