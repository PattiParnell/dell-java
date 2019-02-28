
public class ToDoItem {
	private Integer id ;
	private String itemDescription ;
	private Boolean isComplete;
	private static int NEXTID = 100;
	
	
	public ToDoItem ( String myDescription) {
		setId (NEXTID);
		setItemDescription(myDescription);
		setIsComplete (false);
		NEXTID++;
	}


	public Integer getId() {
		return id;
	}


	private void setId(Integer id) {
		this.id = id;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	private void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public Boolean getIsComplete() {
		return isComplete;
	}


	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
}
