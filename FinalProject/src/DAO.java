import java.util.ArrayList;

public interface DAO {
	public Integer add(String item) ;
	public void update(int myID, Boolean isCompleted) ;
	public ToDoItem getToDoItem(int ID) ;
	public void delete(int myID) ;
	public ArrayList<ToDoItem> returnList(ITEM_STATUS status, Integer myId);
}
