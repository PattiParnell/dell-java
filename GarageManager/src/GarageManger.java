
public class GarageManger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Cars
		System.out.println("*****Cars*****");
		Car carHonda = new Car("Gold", "Xyy123", "Honda", "Accord");
		Car carChevyTruck = new Car("Blue", "zzz111", "Chevy", "Silvarado");
		Car carVan = new Car("Silver", "drv123", "Dodge", "GrandCaravan");
		Car carMotorcycle = new Car("Red", "mtrCyl", "Harley Davidson", "Scorpian");
		Car carVan2 = new Car("Silver", "xyd988", "Chrysler", "Town & Country");
		Car carNissan = new Car("White", "abd877", "Nissan", "Altima");
		Car carUnknown1 = new Car(); // testing basic constructor
		Car carUnknown2 = new Car();
		System.out.println("*****8 Cars Created*****");
		System.out.println("");
		System.out.println("");

		// Create Garages
		System.out.println("*****Creating and Naming Garages*****");


		// Name Garages
		System.out.println("Creating Garage: " + "BlueBonnet Garage" + "Capacity - 3.");
		ParkingGarage pgBlueBonnet = new ParkingGarage(3);
		pgBlueBonnet.setGarageName("BlueBonnet Garage");
		
		System.out.println("Creating Garage: " + "6th Street Garage" + "Capacity - 6.");
		ParkingGarage pg6thStreet = new ParkingGarage(6);
		pg6thStreet.setGarageName("6th Street Garage");
		
		System.out.println("Creatimg Garage: " + "Fail Test - Zero Capacity" + "Capacity - 0.");
		ParkingGarage pgFailTest_ZeroSpots = new ParkingGarage(0);
		pgFailTest_ZeroSpots.setGarageName("Fail Test - Zero Capacity");
		
		System.out.println("Creating Garage: " + "Fail Test - Invalid Value" + "Capacity - -1.");
		ParkingGarage pgFailTest_CapacityLetter = new ParkingGarage(-1);
		pgFailTest_CapacityLetter.setGarageName("Fail Test - Invalid Value");

		System.out.println("");
		System.out.println("");

		// Test Capacity
		// pgFailTest_CapacityLetter.setCapacity("A"); --Doesn't compile

		// update Car Characteristics
		carUnknown2.setColor("Green");
		carUnknown2.setMake("Lexus");

		// Park Cars
		System.out.println("*****Parking Cars time 1*****");
		System.out.println("");
		pgBlueBonnet.park(carHonda, 0);
		pgBlueBonnet.park(carChevyTruck, 1);
		pgBlueBonnet.park(carVan, 2);
		pgBlueBonnet.park(carMotorcycle, 3); // should fail array out bounds

		pgFailTest_ZeroSpots.park(carMotorcycle, 3); // should fail. array out bounds

		pg6thStreet.park(carVan2, 1);
		pg6thStreet.park(carNissan, 1);
		pg6thStreet.park(carUnknown1, 5); // fails because car must have some identifying information
		pg6thStreet.park(carUnknown2, 3);
		pg6thStreet.park(carMotorcycle, 3); // should fail. spot already taken

		System.out.println("*****End Parking Cars time 1*****");
		System.out.println("");

		// print inventory
		System.out.println("*****Inventory Print - time 1*****");
		pgBlueBonnet.printInventory();
		pg6thStreet.printInventory();
		pgFailTest_ZeroSpots.printInventory();
		pgFailTest_CapacityLetter.printInventory();
		System.out.println("*****End Inventory Print - time 1*****");
		System.out.println("");
		System.out.println("");

		// move cars
		System.out.println("*****Moving Cars*****");
		pgBlueBonnet.vacate(0);
		pg6thStreet.park(carHonda, 0);

		pgBlueBonnet.vacate(2);
		pg6thStreet.park(carVan, 2);

		pg6thStreet.park(carMotorcycle, 5);

		pg6thStreet.vacate(1);
		pgBlueBonnet.park(carVan2, 2);

		// invalid vacate tests
		pgBlueBonnet.vacate(-5); // not a valid spot in the array
		pgFailTest_CapacityLetter.vacate(0); // no car parked
		System.out.println("*****Moving Cars*****");
		System.out.println("");

		// print inventory
		System.out.println("*****Inventory Print - time 2*****");
		pgBlueBonnet.printInventory();
		pg6thStreet.printInventory();
		pgFailTest_ZeroSpots.printInventory();
		pgFailTest_CapacityLetter.printInventory();
		System.out.println("*****End Inventory Print - time 2*****");
		System.out.println("");

		System.out.println("*****End Garage Manager Program *****");

	}

	public void createGarage(String myGarage) {
		
	}
	
}
