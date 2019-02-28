
public class Controller {

	private static ConsoleUtilities printer;
	private static DAO toDoWriter;

	public Controller() {
		this.printer = new ConsoleUtilities();
		this.toDoWriter = new InMemoryDAO();
	}

	public static void Start() {
		Boolean exit = false;
		String userCommand = "";
		String entry = "";

		printer.printHelp();

		while (!exit) {

			entry = "";
			userCommand = "";

			entry = printer.promptUser("Please enter a command. >");
			entry = entry.trim();
			String[] args = entry.split("\\W+");
			userCommand = args[0].trim();

			switch (userCommand.toLowerCase()) {
			case ("add"):
				addToDo();
				break;
			case ("delete"):
				deleteToDo(args);
				break;
			case ("complete"):
				markToDoComplete(args);
				break;
			case ("list"):
				listToDo(args);
				break;
			case ("help"):
				printer.printHelp();
				break;
			case ("exit"):
				exit = true;
				break;
			default:
				printer.printError("Invalid entry. Please enter a valid command.");
				break;

			}

		}

	}

	public static void addToDo() {
		String desc = "";
		Integer iD = -1;
		
while (desc.equals("")) {
	
	try {
		desc = printer.promptUser("Please enter the TO DO description: ");
		if (desc.equals("") ){
			

			throw new java.lang.RuntimeException(
					"Description cannot be blank.");
		}
		} catch (Exception e) {
			printer.printError(e.getMessage());

		}
		
			
			
	}

try {
		iD = toDoWriter.add(desc);
		
		if (iD > 0) {
				printer.printMsg( iD +  " - " + desc + " - task added successfully.");
		}
		else {
			throw new java.lang.RuntimeException(
					"Task not added successfully.");
		}
}catch (Exception e) {
	printer.printError(e.getMessage());

}
		
}

	

	public static void markToDoComplete(String[] myArgs)  {
		String id = "";

		if (myArgs.length == 1) {
			id = printer.promptUser("Please enter the ID of the To Do you want to mark complete: ");

		} else {
			id = myArgs[1];
		}

		try {
			toDoWriter.update(Integer.parseInt(id), true);
			printer.printMsg(id + " completed successfully.");

		} catch (NullPointerException e) {
			printer.printError("ID doesn't exist. Please enter a valid ID.");
		} catch (NumberFormatException e) {
			printer.printError("Please enter a valid ID in numeric format");
		} catch (Exception e) {
			printer.printError(e.getMessage());

		}

	}

	public static void deleteToDo(String[] myArgs) {
		String id = "";

		if (myArgs.length == 1) {
			id = printer.promptUser("Please enter the ID of the To Do you want delete: ");

		} else {
			id = myArgs[1];
		}

		try {
			toDoWriter.delete(Integer.parseInt(id));
			printer.printMsg(id + " deleted successfully.");
		} catch (NullPointerException e) {
			printer.printError("ID doesn't exist. Please enter a valid ID.");
		} catch (NumberFormatException e) {
			printer.printError("Please enter a valid ID in numeric format");
		} catch (Exception e) {
			printer.printError(e.getMessage());

		}

	}

	public static void listToDo(String[] myArgs) {
		try {
			if (myArgs.length == 1) {

				printer.printList(toDoWriter.returnList(ITEM_STATUS.ALL, -1));
			}

			else {
				String status = myArgs[1].trim();
				if (isInteger(status)) {
					printer.printList(toDoWriter.returnList(ITEM_STATUS.ALL, Integer.parseInt(status)));
				} else {
					switch (status.toLowerCase()) {
					case ("all"):
						printer.printList(toDoWriter.returnList(ITEM_STATUS.PENDING, -1));
						break;
					case ("active"):
						printer.printList(toDoWriter.returnList(ITEM_STATUS.PENDING, -1));
						break;
					case ("complete"):
						printer.printList(toDoWriter.returnList(ITEM_STATUS.COMPLETE, -1));
						break;

					default:
						throw new java.lang.RuntimeException(
								"That was an invalid entry. Please enter a valid ID, active or complete");
						

					}

				}
			}

		} catch (NullPointerException e) {
			printer.printError("ID doesn't exist. Please enter a valid ID.");
		} catch (NumberFormatException e) {
			printer.printError("Please enter a valid ID in numeric format");

		} catch (Exception e) {
			printer.printError(e.getMessage());

		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}
}
