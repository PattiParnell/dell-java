
public class Controller {
	// handles user entry and communicates with screen writer and DAO

	private static ConsoleUtilities printer; // class for screen printer
	private static DAO toDoWriter; // class for to do items
	private static String mode = "arraylist";

	public Controller() {
		// instantiates classes.
		Boolean isValid = false;
		String entry = "";
		this.printer = new ConsoleUtilities();

		while (!isValid) {
			// continues to capture user entry till done.

			entry = "";

			entry = printer.promptUser("Do you want to enter database mode? (y/n)");
			// allows user to select to save to a database or an arraylist
			// uses dao super class
			entry = entry.trim();
			if (entry.toLowerCase().equals("y") || entry.toLowerCase().equals("yes")) {
				isValid = true;
				mode = "database";
				this.toDoWriter = new Database_DAO();
			}
			if (entry.toLowerCase().equals("n") || entry.toLowerCase().equals("no")) {
				isValid = true;
				mode = "arraylist";
				this.toDoWriter = new InMemoryDAO();
			}
		}

	}

	public static void Start() {
		// main method for the class.

		Boolean exit = false; // hold indicator if user is still working or not.
		String userCommand = ""; // holds user commands
		String entry = ""; // holds user entry

		printer.printHelp(mode); // prints the menus

		while (!exit) {
			// continues to capture user entry till done.

			entry = "";
			userCommand = "";

			entry = printer.promptUser("Please enter a command: ");
			entry = entry.trim();
			String[] args = entry.split("\\s+"); // splits user entry into arguments by white space.
			userCommand = args[0].trim(); // trims the first argument

			switch (userCommand.toLowerCase()) {
			// makes user entry all lower case
			// switch statement based on user entry
			// calls method based on user entry

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
				printer.printHelp(mode);
				break;
			case ("exit"):
				printer.printMsg("Exiting program.");
				printer.printMsg("Have a good day!!!");
				exit = true;
				break;
			default:
				// catches any invalid entry and prints an error message.
				printer.printError("Invalid entry. Please enter a valid command.");
				break;

			}

		}

	}

	public static void addToDo() {
		// add program to add task to list of task
		String desc = "";
		Integer iD = -1;

		while (desc.equals("")) {
			// waits till the user enters a valid description
			// blank is not allowed.

			try {
				desc = printer.promptUser("Please enter the TO DO description: ");
				// captures user entry
				if (desc.equals("")) {

					throw new java.lang.RuntimeException("Description cannot be blank.");
				}
			} catch (Exception e) {
				printer.printError(e.getMessage());
			}
		}

		try {
			iD = toDoWriter.add(desc);
			// writers the entry to the array

			if (iD > 0) {
				printer.printMsg(iD + " - " + desc + " - task added successfully.");
			} else {
				throw new java.lang.RuntimeException("Task not added successfully.");
			}
		} catch (Exception e) {
			printer.printError(e.getMessage());

		}

	}

	public static void markToDoComplete(String[] myArgs) {
		// marks the task complete

		String id = "";

		if (myArgs.length == 1) {
			// if the user fails to enter an ID, prompts the user for an ID
			id = printer.promptUser("Please enter the ID of the To Do you want to mark complete: ");

		} else {
			id = myArgs[1]; // sets the id
		}

		try {
			toDoWriter.update(Integer.parseInt(id), true);
			// marks the ID complete.
			printer.printMsg("Task " + id + " completed successfully.");

		} catch (NullPointerException e) {
			// catches various exception
			// including non existing ID and non-numeric format.
			printer.printError("ID doesn't exist. Please enter a valid ID.");
		} catch (NumberFormatException e) {
			printer.printError("Please enter a valid ID in numeric format");
		} catch (Exception e) {
			printer.printError(e.getMessage());

		}

	}

	public static void deleteToDo(String[] myArgs) {
		// deletes task for list

		String id = "";

		if (myArgs.length == 1) {
			// prompts the user for an id if not entered
			id = printer.promptUser("Please enter the ID of the To Do you want delete: ");

		} else {
			id = myArgs[1]; // holds id to be deleted
		}

		try {
			toDoWriter.delete(Integer.parseInt(id));
			// deleted id from the list
			printer.printMsg("Task " + id + " deleted successfully.");
		} catch (NullPointerException e) {
			// catches various exceptions from ID not exist to invalid format.
			printer.printError("ID doesn't exist. Please enter a valid ID.");
		} catch (NumberFormatException e) {
			printer.printError("Please enter a valid ID in numeric format");
		} catch (Exception e) {
			printer.printError(e.getMessage());

		}

	}

	public static void listToDo(String[] myArgs) {
		// gets the list of tasks to print based on user argument
		// if argument entered assumes all tasks to be printer if no argument entered
		try {
			if (myArgs.length == 1) {
				// if no argument prints all the tasks
				printer.printList(toDoWriter.returnList(ITEM_STATUS.ALL, -1));
			}

			else {
				String status = myArgs[1].trim();
				if (isInteger(status)) {
					// prints the id entered regardless of status
					printer.printList(toDoWriter.returnList(ITEM_STATUS.ALL, Integer.parseInt(status)));
				} else {
					switch (status.toLowerCase()) {
					case ("all"):
						// case statement based on user entry
						// even though all not listed accepts it as a valid arguement
						printer.printList(toDoWriter.returnList(ITEM_STATUS.ALL, -1));
						break;
					case ("active"):
						// prints only active tasks
						printer.printList(toDoWriter.returnList(ITEM_STATUS.PENDING, -1));
						break;
					case ("complete"):
						// prints only complete task
						printer.printList(toDoWriter.returnList(ITEM_STATUS.COMPLETE, -1));
						break;

					default:
						// if the argugment for list is not valid, prints an error.
						throw new java.lang.RuntimeException(
								"That was an invalid entry. Please enter a valid ID, active or complete");

					}

				}
			}

		} catch (NullPointerException e) {
			// handles various errors including ID not exist if a number is entered.
			printer.printError("ID doesn't exist. Please enter a valid ID.");
		} catch (NumberFormatException e) {
			printer.printError("Please enter a valid ID in numeric format");

		} catch (Exception e) {
			printer.printError(e.getMessage());

		}
	}

	public static boolean isInteger(String s) {
		// checks to see if the string passed
		// is a number or not. return false if not a number or if the string is null.
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
