
public class CarLotProgram {

	public static void main(String[] args) {
		//declaring 2 car lots passing in the name
		CarLot NorthValley = new CarLot("North Valley");
		CarLot BlueBonnect = new CarLot("Blue Bonnet");
		
		//creating cars and trucks passing in attributes for vehicle + specific attributes
		//specific to type car or truck
		Car BlueHonda = new Car ("abc123", "Honda", "Accord", 20000.10, "Sedan", 4);
		Car RedInfinity = new Car ("zzz343", "Infinity", "300", 12000.10, "Coupe", 2);
		Car MonteCarlo = new Car ("zzz89", "Chevy", "MonteCarlo", 10000.10, "Coupe", 2);
		Car Nissan = new Car ("2233zz", "Nissan", "Altima", 12000.10, "Sedan", 2);
		Car Ford = new Car ("aabb11", "Ford", "Neo", 14000.10, "Hatchback", 3);
		
		Truck FordF150 = new Truck ("abx911", "Ford", "F150", 16000.10, "short");
		Truck Fordf20 = new Truck ("dfx921", "Ford", "F250", 26000.10, "long");
		Truck NissanTundra = new Truck ("jhx911", "Nissan", "Tundra", 14200.10, "medium");
		
		
		//adding vehicles to each carlot
		NorthValley.setAlVehicleList(BlueHonda);
		NorthValley.setAlVehicleList(MonteCarlo);
		NorthValley.setAlVehicleList(Ford);
		NorthValley.setAlVehicleList(FordF150);
		
		BlueBonnect.setAlVehicleList(RedInfinity);
		BlueBonnect.setAlVehicleList(Fordf20);
		BlueBonnect.setAlVehicleList(NissanTundra);
		BlueBonnect.setAlVehicleList(Nissan);
		
		//printing each inventory 
		NorthValley.printInventory();
		BlueBonnect.printInventory();
	}

}
