import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class ConsoleUtilities {
	//prints to the screen and receives input from the screen
	
	private Scanner reader ;  //captures user entry from the screen

	
	public ConsoleUtilities () {
		 //constructor for console
		//instantiates the reader
		reader = new Scanner(System.in);

		
		
	}
	

	public void  printHelp () {
		//prints the help menu
		
		System.out.println("**************************************************************");
		System.out.println("*                         Help Menu                          *");
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*  Command         Action                                    *");
		System.out.println("*------------------------------------------------------------*");
		System.out.println("*  add             Creates a new to do item.                 *");
		System.out.println("*  complete ID     Marks given to do item as complete.       *");
		System.out.println("*  delete ID       Removes given to do item from to do list. *");
		System.out.println("*  list            Lists active and completed to do items.   *");
		System.out.println("*  list ID         Lists the task for the ID entered.        *");
		System.out.println("*  list active     Lists active tasks.                       *");
		System.out.println("*  list complete   Lists completed tasks.                    *");
		System.out.println("*  help            Lists commands available.                 *");
		System.out.println("*  exit            Ends To Do List Program.                  *");
		System.out.println("*                                                            *");
		System.out.println("**************************************************************");

	}
	
	public void printMsg ( String myMessage) {
		//prints informative message to the screen. doesn't accepts user entry
		System.out.println( "[ " + myMessage + " ]");
		System.out.println();
	}
	
	public void printError ( String myError) {
		//printers error messages to the screen
		System.out.println( "[ERROR: " + myError + "]");
		System.out.println();
	}
	
	public String promptUser ( String prompt) {
		//prints a message to the screen and expects the user to enter a response.
		//response is returned to the calling method as a string. 
		String command = "";
		System.out.println( prompt);
		
		command = reader.nextLine();
		
		return command;
		
		
	}
	
	public void printList ( ArrayList<ToDoItem> myToDoList ) {
		//prints list of task based on the array passed. 
		
		int longestToDo =  17;  //holds the length of the longest to do 
        int completed = 9;      //holds the length of active or completed columnt
        String isComplete = "";

        for(ToDoItem toDo : myToDoList){
        	//for loop to get longest task length
            if(toDo.getItemDescription().length() > longestToDo){
            	longestToDo = toDo.getItemDescription().length();
            }

        }

        String toDoHeader = String.format("%-"+longestToDo+"s", "To Do Description");
        //string that holds the header of the task list for the to do column
        
        String toDoUnderline = "";
        for(int i=0;i<longestToDo;i++){
        	//creates an underline string to follow the column to do column. 
        	toDoUnderline+="-";
        }
        
        String cmplHeader = String.format("%-"+completed+"s", "Status");
        //string that holds the header of the task list for the status column
        String cmpltUnderline = "";
      //creates an underline string to follow the column to do column. 
        for(int i=0;i<completed;i++){
        	cmpltUnderline+="-";
        }

        System.out.println("   ID  | "+toDoHeader   +" | "+cmplHeader   +" | ") ;
        //printers the header column
        System.out.println("-------+-"+toDoUnderline+"-+-"+cmpltUnderline+"-+----------------+----------------");
        //prints underline for header column

        for(ToDoItem toDo : myToDoList){
            String toDoItem = String.format("%-"+longestToDo+"s", toDo.getItemDescription());
            //adds todo description to string
            
            if (toDo.getIsComplete()) {
            	//adds status for to do to string
            	 isComplete  = String.format("%-"+completed+"s", "Completed");
            }
            else {
            	 isComplete  = String.format("%-"+completed+"s", "Active");
            }


            String line = String.format(" %5s | %s | %s | ", toDo.getId(), toDoItem, isComplete);
            System.out.println(line);
            //prints out the id, description and status to screen. 
        }

        if(myToDoList.size() == 1){
        	//prepares footer entry based on number of items in list
            System.out.println("[1 entry]");
        } else {
            System.out.println("["+myToDoList.size()+" entries]");
        }

        System.out.println();
        //prints out footer. 
		
	}
}
