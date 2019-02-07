import java.util.List;
import java.util.Scanner;

public class EmployeeRoster {
 
	private static Roster myRoster = new Roster();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean selectOption = true;
		
		//prompt user for employee name/title 
		//add employee to roster
		//print roster
		
		do {
			selectOption = employeeRosterProgram (); 
		} while (selectOption);
		
		
		
		
	}
	
	public static void writeMainMenu() {

		System.out.println("**************************************************");
		System.out.println("*                    Main Menu                   *");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("* Nbr    Action                                  *");
		System.out.println("*   1    Add Employee                            *");
		System.out.println("*   2    Print Roster                            *");
		System.out.println("*   3    Exit                                    *");
		System.out.println("*                                                *");
		System.out.println("*------------------------------------------------*");

		System.out.println("Enter the number for the action you would like to take:");

	}
	
	public static Boolean employeeRosterProgram () {
		int choice = 0;
		Boolean runAgain = false;
		Scanner reader = new Scanner(System.in);
		
 
			try {

				do {
					choice = 0;

					writeMainMenu();

					while (choice == 0) {
						try {
							 choice = Integer.parseInt(reader.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("That was an invalid entry. Please enter 1, 2 or 3.");
						} catch (Exception e) {
							System.out.println("Please enter the numbers 1, 2 or 3.");

						}

					}

					switch (choice) {
					case 1:
						addEmployeeInfo(reader);
						runAgain = true;

						break;
					case 2:
						printEmployeeRoster();
						runAgain = true;
						break;
					case 3:
						exitProgram();
						runAgain = false;
						break;
					default:
						throw new java.lang.RuntimeException("That was an invalid selection. Please enter 1, 2 or 3!");
					}

				} while (choice != 3);

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				runAgain = true;

			}

			finally {

				reader.close();
				return runAgain;

			}
		
	}
	
	public static void addEmployeeInfo(Scanner myReader) {
		
		String eName;
		String eTitle;
		String result; 
		Boolean addAnother = true; 

		
		do {
			System.out.println("Enter employee's first and last name:");
			eName = myReader.nextLine();
			
			System.out.println("Enter employee's job title:");
			eTitle = myReader.nextLine();
			
			Employee myEmployee = new Employee(eName, eTitle); 
			
			myRoster.addEmployee(myEmployee);
			
			System.out.println("Do you want to add another employee: Y/N");
			
			result = myReader.nextLine();
			result = result.trim();
			
			switch(result.toUpperCase()) {
				case "Y":
					addAnother = true;
					break;
				case "N":
					addAnother = false;
					break;
				default:
					addAnother = false;
					System.out.println("Invalid selection. Returning to main menu.");
					break;
					
			}
				
		
		}while (addAnother);
	}
	
	
	public static void exitProgram() {


			System.out.println( "ttfn");

			
		
		
	}

	
	public static void printEmployeeRoster() {
		int ID = 0;
		Employee myEmp;
		String name = "";
		String title = "";
		
		
		List<Employee> myEmployees = myRoster.getRoster();
		
		System.out.println( "**********Employee Roster**********");
		
		for(int i = 0; i < myEmployees.size(); i++) {
			
			myEmp = myEmployees.get(i);
			
			ID = myEmp.getID();
			name = myEmp.getEmployeeName();
			title = myEmp.getJobTitle();
			
			System.out.println( "ID:  " + ID);  
			System.out.println( "Name:  " + name);  
			System.out.println( "Title:  " + title);  
			System.out.println( "");  
			
			
			
		}
			
		
		
	}
}
