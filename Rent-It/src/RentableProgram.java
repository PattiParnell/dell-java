import java.util.Scanner;

public class RentableProgram {

	public static void main(String[] args) {
		Double numberRentDays = 0.00; // variable to hold users #days to rent
		Scanner reader = new Scanner(System.in); // reads users entry

		Rentable[] rentalList = new Rentable[9];
		// array to hold list of rentable items

		// creates 3 each of rooms, condo and tools to rent
		Room room1 = new Room("By the Sea", 110.34);
		Room room2 = new Room("Downtown", 262.34);
		Room room3 = new Room("Riverfront", 79.99);

		Condo condo1 = new Condo("Domain", 1245.00);
		Condo condo2 = new Condo("Airport", 920.02);
		Condo condo3 = new Condo("East Austin", 777.77);

		Tool tool1 = new Tool("Hammer", 1.01);
		Tool tool2 = new Tool("Bobcat", 25.00);
		Tool tool3 = new Tool("Wet Saw", 7.50);

		// adds then rentable items to the array
		rentalList[0] = room1;
		rentalList[1] = room2;
		rentalList[2] = room3;
		rentalList[3] = condo1;
		rentalList[4] = condo2;
		rentalList[5] = condo3;
		rentalList[6] = tool1;
		rentalList[7] = tool2;
		rentalList[8] = tool3;

		// prints out the daily prices list for rentable items
		System.out.println("Rental Items and Price to Rent per Day");
		for (int i = 0; i < rentalList.length; i++) {
			System.out.println("Description: " + rentalList[i].getDescription() + "   Daily Rate: "
					+ String.format("$ %(,.2f", rentalList[i].getDailyRate()));
			// formats string to have 2 decimal places
		}
		System.out.println("");

		// request from user the number of days to rent
		while (numberRentDays == 0) {
			try {
				System.out.println("How many days would you like to rent?");
				numberRentDays = Double.parseDouble(reader.nextLine());

				if (numberRentDays <= 0) {
					// throw error is user enters 0 days or negative days
					throw new java.lang.RuntimeException(
							"That was an invalid selection. Please enter a number great than 0.");
				}

			} catch (Exception e) {
				// catches all exceptions and prints out common error message
				// so user can try again.
				System.out.println("That was an invalid selection. Please enter a number great than 0.");

				numberRentDays = 0.00; // resents rent days to go through while loop again.
			}
		}

		// prints price for the desired number of days.
		for (int i = 0; i < rentalList.length; i++) {
			System.out.println("Description: " + rentalList[i].getDescription() + "   Price for " + numberRentDays
					+ " days rental: " + String.format("$ %(,.2f", rentalList[i].getPrice(numberRentDays)));
			// formats string to show 2 places for decimal
		}
		reader.close(); // closes reader
	}

}
