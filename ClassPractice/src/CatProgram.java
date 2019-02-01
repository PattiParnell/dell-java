
public class CatProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Cat mycat = new Cat();

Book myBook = new Book();
//
//mycat.ageInMonth = 18;
//mycat.breed = "Domestic Short Hair";
//mycat.color = "Black";
//mycat.isPurring = false;
//mycat.isSleeping = true;
//mycat.eyeColor = "Orange";
//
//System.out.println (mycat.breed);

myBook.setAuthorFirstName( " JK "); 
myBook.setAuthorLastName("Rowlings") ;
myBook.setTitle("Harry Potter and the Sorceror's Stone");

Book newBook = new Book ("Mary", "Balough", "Someone to Trust");

System.out.println("Title: " + myBook.getTitle() + " Author: " + myBook.getAuthorFullName());
System.out.println("Title: " + newBook.getTitle() + " Author: " + newBook.getAuthorFullName());


	}
	


}
