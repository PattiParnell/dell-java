import java.util.HashMap;
import java.util.Map;

public class ParkingGarage {
	private Car[] arrCar;
	private int capacity;
	private int[] spot;
	private Map<Integer, Car> mapParkingSpots = new HashMap<Integer, Car>();

	public ParkingGarage(int myCapacity) {
		this.setCapacity(myCapacity);

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
		this.capacity = capacity;

		for (int i = 0; i < this.getCapacity(); i++) {
			spot[i] = i;
		}
	}

	public void park(Car myCar, int mySpot) {
		mapParkingSpots.put(spot[mySpot], myCar);
	}

	public void vacate(int mySpot) {
		mapParkingSpots.remove(spot[mySpot]);
	}

	public void printInventory() {
		Car myCar = new Car();
		for (int i = 0; i < spot.length; i++) {
			if (mapParkingSpots.containsKey(this.spot[i])) {
				myCar = mapParkingSpots.get(this.spot[i]);
				System.out.println("Spot: " + this.spot[i]);
				System.out.println("Color: " + myCar.getColor());
				System.out.println("Color: " + myCar.getMake());
				System.out.println("Color: " + myCar.getModel());
				System.out.println("Color: " + myCar.getLicenseNbr());
			} else {
				System.out.println("Spot: " + this.spot[i]);
				System.out.println("Vacant");

			}

		}

	}

}
