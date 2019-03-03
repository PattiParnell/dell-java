import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_DAO implements DAO {
	 Connection connection = null;
	 Statement statement = null;
	private static int NEXTID = 1000;

	public Database_DAO() {
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
	        Statement statement = connection.createStatement();
	        statement.setQueryTimeout(30);  // set timeout to 30 sec.
	          statement.executeUpdate("drop table if exists ToDo");
	          statement.executeUpdate("create table ToDo (id integer, description string, isCompleted boolean)");
statement.executeUpdate("insert into ToDo values (1000, 'sdlfkei', false)");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	
	}

	public Integer add(String item) {
		String strInsert = "";
		int rs =  0;
		
		strInsert = String.format("insert into ToDo values (%d, '%s', %b)", NEXTID, item, false);
		System.out.println(strInsert);
		try {
			 statement.execute(strInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rs = e.getErrorCode();
			e.printStackTrace();
		} 
		return 1;
		
	}

	@Override
	public void update(int myID, Boolean isCompleted) {
		// TODO Auto-generated method stub

	}

	@Override
	public ToDoItem getToDoItem(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int myID) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<ToDoItem> returnList(ITEM_STATUS status, Integer myId) {
		// TODO Auto-generated method stub
		return null;
	}

}
