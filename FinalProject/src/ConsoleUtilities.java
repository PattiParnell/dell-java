import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class ConsoleUtilities {
	private Scanner reader ;

	
	public ConsoleUtilities () {
		 
		reader = new Scanner(System.in);

		
		
	}
	

	public void  printHelp () {
		System.out.println("**************************************************************");
		System.out.println("*                         Help Menu                          *");
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*  Command         Action                                    *");
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
		System.out.println( "[ " + myMessage + " ]");
		System.out.println();
	}
	
	public void printError ( String myError) {
		System.out.println( "[ ERROR: " + myError + "]");
		System.out.println();
	}
	
	public String promptUser ( String prompt) {
		String command = "";
		System.out.println( prompt);
		
		command = reader.nextLine();
		
		return command;
		
		
	}
	
	public void printList ( ArrayList<ToDoItem> myToDoList ) {
		
		int longestToDo =  17;
        int completed = 9;
        String isComplete = "";

        for(ToDoItem toDo : myToDoList){
            if(toDo.getItemDescription().length() > longestToDo){
            	longestToDo = toDo.getItemDescription().length();
            }

        }

        String toDoHeader = String.format("%-"+longestToDo+"s", "To Do Description");
        String toDoUnderline = "";
        for(int i=0;i<longestToDo;i++){
        	toDoUnderline+="-";
        }
        
        String cmplHeader = String.format("%-"+completed+"s", "Status");
        String cmpltUnderline = "";
        for(int i=0;i<completed;i++){
        	cmpltUnderline+="-";
        }

        System.out.println("   ID  | "+toDoHeader   +" | "+cmplHeader   +" | ") ;
        System.out.println("-------+-"+toDoUnderline+"-+-"+cmpltUnderline+"-+----------------+----------------");

        for(ToDoItem toDo : myToDoList){
            String toDoItem = String.format("%-"+longestToDo+"s", toDo.getItemDescription());
            
            if (toDo.getIsComplete()) {
            	 isComplete  = String.format("%-"+completed+"s", "Completed");
            }
            else {
            	 isComplete  = String.format("%-"+completed+"s", "Pending");
            }


            String line = String.format(" %5s | %s | %s | ", toDo.getId(), toDoItem, isComplete);
            System.out.println(line);
        }

        if(myToDoList.size() == 1){
            System.out.println("[1 entry]");
        } else {
            System.out.println("["+myToDoList.size()+" entries]");
        }

        System.out.println();
		
	}
}
