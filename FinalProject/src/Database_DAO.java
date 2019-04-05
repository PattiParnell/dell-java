import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_DAO implements DAO {

	// this task holds database interaction to store and retrieve data
	// it implements DAO so all the methods would be the same
	// and the user can switch back and forth from arraylist without having to
	// recode the controller app

	static Connection connection = null; // holds db connection
	static Statement statement = null; // holds statement object

	public Database_DAO() {

		// creates the table in the database
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			statement.executeUpdate("drop table if exists ToDo");
			// dropping the tsble if exists.
			statement.executeUpdate(
					"create table ToDo (task_id INTEGER PRIMARY KEY, description string, isCompleted boolean)");
			// creates the table using a primary key field that is auto assigned

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Integer add(String item) {
		// adds item to the database

		String strInsert = "";
		int myID = 0;

		strInsert = String.format("insert into ToDo (description, isCompleted) values ( '%s', %b)", item, false);
		// lets the database assign the id.

		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			statement.executeUpdate(strInsert);

			ResultSet rs = statement.executeQuery("SELECT last_insert_rowid()");
			// gets the id of the record last added to return to calling method

			while (rs.next()) {
				// loops through the recordset
				myID = rs.getInt("last_insert_rowid()");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myID;
		// returns id of task just added.

	}

	public void update(int myID, Boolean isCompleted) {
		// updates the database so that the task is complete
		String strSQL = "";
		Boolean taskComplete = false;

		strSQL = String.format("SELECT * from ToDo where task_id = %d", myID);
		// builds the sql string to be executed.

		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			ResultSet rs = statement.executeQuery(strSQL);
			while (rs.next()) {
				// gets status of the task
				taskComplete = rs.getBoolean("isCompleted");
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		if (!taskComplete) {
			// checks status of todo is complete
			// if not marks it complete
			// if so throws error
			strSQL = String.format("update ToDo set isCompleted = %b where task_id = %d", isCompleted, myID);
			// builds sql to mark ID task completed

			try {
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.
				if (statement.executeUpdate(strSQL) == 0) {
					// executes the task
					// checks to see if records were updated
					// if records update = 0 throws an error
					throw new java.lang.RuntimeException("Task " + myID + " not marked complete. Verify ID.");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// error thrown if task already marked complete
			throw new java.lang.RuntimeException("Task " + myID + " already marked complete.");
		}

	}

	public ToDoItem getToDoItem(int myID) {
		// returns a single item

		String strSQL = "";
		ToDoItem myToDo = null;

		strSQL = String.format("SELECT * from ToDo where task_id = %d", myID);
		// formats sql statemnet to get recordset by id.

		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			ResultSet rs = statement.executeQuery(strSQL);
			while (rs.next()) {
				// if there is a recordset
				// adds it to a todo class
				myToDo = new ToDoItem(rs.getString("description"), myID);
				myToDo.setIsComplete(rs.getBoolean("isCompleted"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return myToDo;
		// returns the task or null if the recordset doesn't exist

	}

	public void delete(int myID) {
		String strSQL = "";
		ToDoItem toDo = getToDoItem(myID);
		// checks to see if the tasks exists

		if (toDo != null) {
			try {
				// if task exists it deletes it
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.
				strSQL = String.format("Delete from ToDo where task_id = %d", myID);
				// holds sql to delete task by id

				if (statement.executeUpdate(strSQL) == 0) {
					// checks to make sure the record was deleted.
					throw new java.lang.RuntimeException("Task " + myID + " not deleted. Verify ID.");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new java.lang.RuntimeException("Task " + myID + " does not exist.");
			// throws error is task id doesn't exist
		}

	}

	public ArrayList<ToDoItem> returnList(ITEM_STATUS status, Integer myId) {

		ToDoItem toDo = null; // todo item
		String strSQL = ""; // holds sql statement
		ArrayList<ToDoItem> listToDo = new ArrayList<ToDoItem>();
		// array to hold the list of todo to be printed.

		if (myId >= 0) {
			// if id was entered - returns the todo item regardless of status.

			toDo = getToDoItem(myId);
			listToDo.add(toDo);
		} else {
			// if id not enterd
			// returns list of todo based on status

			switch (status) {
			// case statement to build sql for list of task with desired status.
			case ALL:
				// creates sql for all task
				strSQL = String.format("SELECT * from ToDo");
				break;
			case PENDING:
				// creates sql for active task
				strSQL = String.format("SELECT * from ToDo where isCompleted = false");
				break;
			case COMPLETE:
				// creates sql for pending task
				strSQL = String.format("SELECT * from ToDo where isCompleted = true");
				break;

			default:
				// if the argument for list is not valid, prints an error.
				throw new java.lang.RuntimeException(
						"That was an invalid entry. Please enter a valid ID, active or complete");
			}

			try {
				Statement statement = connection.createStatement();
				statement.setQueryTimeout(30); // set timeout to 30 sec.
				ResultSet rs = statement.executeQuery(strSQL);

				while (rs.next()) {
					// loops through the recordset
					// creating todo then adding it to the arraylist
					toDo = new ToDoItem(rs.getString("description"), rs.getInt("task_id"));
					toDo.setIsComplete(rs.getBoolean("isCompleted"));
					listToDo.add(toDo);
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

		return listToDo;
	}

}
