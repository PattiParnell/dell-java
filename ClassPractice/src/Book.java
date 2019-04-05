
public class Book {
	private String title ;
	private String authorFirstName;
	private String authorLastName;
	
	public Book() {
		this.title = "";
		this.authorFirstName = "";
		this.authorLastName = "";
	}
	
	public Book(String myTitle, String myAuthorFirst, String myAuthorLast) {
		this.title = myTitle;
		this.authorFirstName = myAuthorFirst;
		this.authorLastName = myAuthorLast;
	}
	
	public String getTitle () {
		return this.title;
		
	}
	
	public void setTitle (String myTitle) {
		this.title = myTitle;
			}
	
	
	public String getAuthorFirstName () {
		return this.authorFirstName;
		
	}
	
	public void setAuthorFirstName (String myAuthorFirstName) {
		this.authorFirstName = myAuthorFirstName;
			}

	
	public String getAuthorLastName () {
		return this.authorFirstName;
		
	}
	
	public void setAuthorLastName (String myAuthorLastName) {
		this.authorLastName = myAuthorLastName;
			}

	
	public  String getAuthorFullName () {
		
		return ( authorFirstName.trim() + " " + authorLastName);
		
	}
	
}
