import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class InMemoryDAO implements DAO{

	private List<ToDoItem> toDoList;

	public InMemoryDAO() {

		toDoList = new ArrayList<ToDoItem>();

	}

	public Integer add(String item) {
	

		ToDoItem toDo = new ToDoItem( item);

		toDoList.add(toDo);
		
		return toDo.getId();

	}

	public void update(int myID, Boolean isCompleted) {

		ToDoItem toDo = getToDoItem(myID);
		toDo.setIsComplete(isCompleted);

	}

	public ToDoItem getToDoItem(int ID) {
		ToDoItem toDo = null;

		for (int i = 0; i < toDoList.size(); i++) {
			if (ID == toDoList.get(i).getId()) {
				toDo = toDoList.get(i);

			}
		}
		return toDo;

	}

	public void delete(int myID) {

		ToDoItem toDo = getToDoItem(myID);
		toDoList.remove(toDo);

	}

	public ArrayList<ToDoItem> returnList(ITEM_STATUS status, Integer myId) {
		ArrayList<ToDoItem> listToDo = new ArrayList<ToDoItem>();
		
	
		for (int i = 0; i < toDoList.size(); i++) {
			
			if (myId >= 0 ) {
				if (myId != toDoList.get(i).getId())
				{continue;
				}
			}

			if ((ITEM_STATUS.PENDING == status) && (toDoList.get(i).getIsComplete())) {
				continue;

			}

			if ((ITEM_STATUS.COMPLETE == status) && !(toDoList.get(i).getIsComplete())) {
				continue;

			}

			listToDo.add(toDoList.get(i));
		}

		return listToDo;

	}

}
