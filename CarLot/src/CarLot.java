import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarLot {
	
	private String carLotName;
	private Map< String, Vehicle> mapVehicleList = new HashMap<String, Vehicle>();
	
	public String getCarLotName() {
		return carLotName;
	}
	public void setCarLotName(String carLotName) {
		this.carLotName = carLotName;
	}
	public Map<String, Vehicle> getMapVehicleList() {
		return mapVehicleList;
	}
	public void setMapVehicleList(String myLicenseNumber, Vehicle myVehicle) {
		this.mapVehicleList.put(myLicenseNumber, myVehicle);
		
		
	}
	
	public void printInventory ()
	{
		String license; 

		
		System.out.println("Car Lot Name:    " + this.getCarLotName());
		
		
		ArrayList<String> vehicleList = new ArrayList<String>(mapVehicleList.keySet());
		// gets the key list for the map of vehicles

		for (int i = 0; i < vehicleList.size(); i++) {
			// loop for each vehicle in array
			license = vehicleList.get(i); // gets key for map
			if (mapVehicleList.get(license) instanceof Truck) {
			    ((Truck)mapVehicleList.get(license)).printVehicleDescription();
			}
			else {
				((Car)mapVehicleList.get(license)).printVehicleDescription();
			}
						

		}
		
	
	}
	
	
	

}
