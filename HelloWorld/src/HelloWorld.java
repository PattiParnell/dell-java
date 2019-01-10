import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println("Hello World!");
System.out.println("Welcome to my world!!");
System.out.println();
System.out.println("What is your name?");
Scanner reader = new Scanner(System.in);
String input = reader.nextLine();
System.out.println("Hello, " + input);
reader.close();

	}

}
