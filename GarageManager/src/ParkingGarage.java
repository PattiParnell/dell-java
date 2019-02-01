import java.util.HashMap;
import java.util.Map;

public class ParkingGarage {
	// private variables for Parking Garage class
	private Car[] arrCar; // holds array of cars in the garage
	private int capacity; // holds how many cars garage can hold
	private int[] spot; // holds an array of possible parking spots
	private String GarageName; // name of garage
	private Map<Integer, Car> mapParkingSpots = new HashMap<Integer, Car>(); // holds collection of car and the spot
																				// they are in

	// constructor for Parking Garage Calls
	// must include a capacity
	public ParkingGarage(int myCapacity) {
		try {
			this.setCapacity(myCapacity);

		} catch (NegativeArraySizeException e) {
			// catches error for spots outside of the capacity of the array
			System.out.println("Type of Exception: " + "NegativeArraySizeException");
			System.out.println("Garage capacity must be a postive value. Setting capactiy to 1");
			this.setCapacity(1); 
			System.out.println("");
		} catch (Exception e) {
			// catches all other errors
			System.out.println("Error Message: " + e.getMessage());
			System.out.println("Setting capactiy to 1");
			this.setCapacity(1); 
			System.out.println("");
		}
	}

	// getters and setters for variables
	public String getGarageName() {
		return GarageName;
	}

	public void setGarageName(String garageName) {
		GarageName = garageName;
	}

	public Car[] getArrCar() {
		return arrCar;
	}

	public void setArrCar(Car[] arrCar) {
		this.arrCar = arrCar;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		// setter for capacity
		if (capacity != 0) {
			this.capacity = capacity;
			this.spot = new int[capacity];

			for (int i = 0; i < this.getCapacity(); i++) {
				// loop to initialize array of spots
				spot[i] = i;
			}
		} else {
			// throws error when spot is occupied
			throw new java.lang.RuntimeException("Size of garage can't be zero.");
		}

	}

	public void park(Car myCar, int mySpot) {
		// method to assign a car to a spot then adds it to collection

		try {
			// try-catch routine to check for
			// --valid car identification
			// --valid spot
			// --occupied spot
			if (checkCarID(myCar)) {
				// calls method to make sure car has a valid identity
				if (!mapParkingSpots.containsKey(mySpot)) {
					// checks to see if the spot is occupied
					mapParkingSpots.put(spot[mySpot], myCar);
				} else {
					// throws error when spot is occupied
					throw new java.lang.RuntimeException(
							"Spot " + mySpot + " is already occupied.  Select another spot.");
				}

			} else {
				// throws error when car has no identifying information
				throw new java.lang.RuntimeException(
						"Parked cars must have at least Make, Model, License Number or Color defined.");
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			// catches error for spots outside of the capacity of the array
			System.out.println("Type of Exception: " + "ArrayIndexOutOfBoundsException");
			System.out.println("Parking Spot doesn't exist.  Please try another spot.");
			System.out.println("");
		} catch (Exception e) {
			// catches all other errors
			System.out.println("Error Message: " + e.getMessage());
			System.out.println("");
		}

	}

	public void vacate(int mySpot) {

		try {
			// try - catch routing

			if (mapParkingSpots.containsKey(mySpot)) { // checks to see if the spot is occumpied
				mapParkingSpots.remove(spot[mySpot]); // removes car from spot
			} else {
				// error thrown when no car parked in given spot
				throw new java.lang.RuntimeException("No car is parked in this spot - " + mySpot + ".");

			}

		} catch (ArrayIndexOutOfBoundsException e) {
			// catches spot not valid for this garage
			System.out.println("Type of Exception: " + "ArrayIndexOutOfBoundsException");
			System.out.println("Parking Spot doesn't exist.  Please enter correct spot to vacate.");
			System.out.println("");
		} catch (Exception e) {
			// returns all other error messages
			System.out.println("Error Message: " + e.getMessage());
			System.out.println("");
		}
	}

	public void printInventory() {
		// print routine for a garages inventory

		Car myCar = new Car();

		System.out.println("**************************************************");
		System.out.println("Parking Garage: " + this.getGarageName());
		for (int i = 0; i < spot.length; i++) {
			// for each spot in the garage gives
			// car information if occupied
			// gives vacant remark if empty

			if (mapParkingSpots.containsKey(this.spot[i])) {
				myCar = mapParkingSpots.get(this.spot[i]);
				System.out.println("Spot: " + this.spot[i]);
				System.out.println("Color: " + myCar.getColor());
				System.out.println("Make: " + myCar.getMake());
				System.out.println("Model: " + myCar.getModel());
				System.out.println("License Plate: " + myCar.getLicenseNbr());
				System.out.println("---------------------------------------------");
			} else {
				System.out.println("Spot: " + this.spot[i] + " - Vacant");
				System.out.println("---------------------------------------------");
			}

		}
		System.out.println("**************************************************");

	}

	public static Boolean checkCarID(Car myCar) {
		// method to check that the car has some identifying information

		Boolean rc = true;

		if ((myCar.getColor() == "Unknown") && (myCar.getLicenseNbr() == "Unknown") && (myCar.getMake() == "Unknown")
				&& (myCar.getModel() == "Unknown")) {
			rc = false;
		}

		return rc;

	}

}

