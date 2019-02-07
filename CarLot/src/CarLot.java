import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarLot {
	//declare variables for carlot name and list of vehicles
	private String carLotName;
	private ArrayList <Vehicle> alVehicleList = new ArrayList<Vehicle>(); //using an array list 
	
	//constructor for car lot
	public CarLot(String carLotName) {
		this.carLotName = carLotName;
	}
	
	//getters and setters for carlot
	public ArrayList<Vehicle> getAlVehicleList() {
		return alVehicleList;
	}
	public void setAlVehicleList(Vehicle myVehicle) {
		//this setting is just taking in 1 vehicle and 
		//adding it to the array list
		this.alVehicleList.add(myVehicle);
	}
	public String getCarLotName() {
		return carLotName;
	}
	public void setCarLotName(String carLotName) {
		this.carLotName = carLotName;
	}

	
	public void printInventory () {
	//prints our car lots inventory
		
		System.out.println("**********Car Lot Name:    " + this.getCarLotName() + " Inventory List **********");
		
		for (int i = 0; i < alVehicleList.size(); i++) {
			// loop for each vehicle in array
		
			if (alVehicleList.get(i) instanceof Truck ) {
				//prints Truck attributes for trucks
				((Truck)alVehicleList.get(i)).printVehicleDescription();
			}
			else {
				//prints Car attributes for cars.
				((Car)alVehicleList.get(i)).printVehicleDescription();
			}				

		}
		
		System.out.println("**********End  " + this.getCarLotName() + " Inventory List **********");
		System.out.println("");
		System.out.println("");

		
	
	}
	
	
	

}
