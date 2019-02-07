
public class RentableProgram {

	public static void main(String[] args) {

		Rentable [] rentalList = new Rentable[9];
		
		Room room1 = new Room ("By the Sea", 110.34);
		Room room2 = new Room ("Downtown", 262.34);
		Room room3 = new Room ("Riverfront", 79.99);
		
		Condo condo1 = new Condo ("Domain", 1245.00);
		Condo condo2 = new Condo ("Airport", 920.02);
		Condo condo3 = new Condo ("East Austin", 777.77);
		
		Tool tool1 = new Tool ("Hammer", 1.01);
		Tool tool2 = new Tool ("Bobcat", 25.00);
		Tool tool3 = new Tool ("Wet Saw", 7.50);
		
		
		rentalList[0] = room1;
		rentalList[1] = room2;
		rentalList[2] = room3;
		rentalList[3] = condo1;
		rentalList[4] = condo2;
		rentalList[5] = condo3;
		rentalList[6] = tool1;
		rentalList[7] = tool2;
		rentalList[8] = tool3;
		
		for (int i = 0; i < rentalList.length; i++) {
			System.out.println("Description: " + rentalList[i].getDescription() 
					            +  "   Daily Rate: "  
					             +  String.format ( "$ %(,.2f", rentalList[i].getDailyRate()));
		}
			
		
		
		

	}

}
