import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class InMemoryDAO implements DAO {
	// holds array list DAO
	// holds an array of todos
	private static int NEXTID = 100;


	private List<ToDoItem> toDoList;

	public InMemoryDAO() {
		// constructor for class
		// creates a new array

		toDoList = new ArrayList<ToDoItem>();

	}

	public Integer add(String item) {
		// adds new todo to array
		// returns the id to calling method

		ToDoItem toDo = new ToDoItem(item, NEXTID);

		toDoList.add(toDo);
		
		NEXTID++;

		return toDo.getId(); // returns the id for the newly added todo

	}

	public void update(int myID, Boolean isCompleted) {
		// updates the todo completd

		ToDoItem toDo = getToDoItem(myID);
		if (!toDo.getIsComplete()) {
			// checks status of todo is complete
			// if not marks it complete
			// if so throws eror

			toDo.setIsComplete(isCompleted);
		} else {
			throw new java.lang.RuntimeException("Task " + myID + " already marked complete.");
		}

	}

	public ToDoItem getToDoItem(int ID) {
		// get the todo item from array and returns to calling function
		ToDoItem toDo = null;

		for (int i = 0; i < toDoList.size(); i++) {
			//loops through array to find todo
			if (ID == toDoList.get(i).getId()) {
				toDo = toDoList.get(i);
				break;  //exits loop when todo is found

			}
		}
		return toDo; //returns todo

	}

	public void delete(int myID) {
		//removes the todo from the array. 

		ToDoItem toDo = getToDoItem(myID);
		
		if (toDo != null) {
			//if todo is found removes it
			//if todo is not found throws error.
			toDoList.remove(toDo);
		} else {
			throw new java.lang.RuntimeException("Task " + myID + " does not exit.");
		}

	}

	public ArrayList<ToDoItem> returnList(ITEM_STATUS status, Integer myId) {
		//returns the list of todo based on user requirements
		//returns just the id needed
		//or list of todo by status active, completed or all
		
		ArrayList<ToDoItem> listToDo = new ArrayList<ToDoItem>();
		//array to hold the list of todo to be printed. 

		for (int i = 0; i < toDoList.size(); i++) {
			//loops through todo array
			

			if (myId >= 0) {
				//if id is not empty returns just the id
				//then exits for loop
				
				if (myId != toDoList.get(i).getId()) {
					continue;
				}
			}
			
			//if a specific status is requested
			//loops through and if the status matches the desired status then returns it
			

			if ((ITEM_STATUS.PENDING == status) && (toDoList.get(i).getIsComplete())) {
			//goes to next item in the for loop
				//if the user wants pending todos and the todo is completed
				continue;

			}

			if ((ITEM_STATUS.COMPLETE == status) && !(toDoList.get(i).getIsComplete())) {
				//goes to next item in the for loop
				//if the user wants completed todos and the todo is active
				continue;

			}

			listToDo.add(toDoList.get(i));
			//adds the todo to the list of todo's to be printed
		}

		return listToDo;  //returns list to be printed. 

	}

}
