import java.util.Scanner;

public class Calculator {
	

	public static void main(String[] args) {
		float firstNbr = 0;
		float secondNbr = 0; 

		// TODO Auto-generated method stub
		System.out.println("Welcome to the calculator!");
		System.out.println("Enter in your first number:  ");
		Scanner reader = new Scanner(System.in);
		firstNbr = reader.nextFloat();
		System.out.println("Enter in your second number:  ");
		secondNbr = reader.nextFloat();
		
		printer (firstNbr,secondNbr );

				
		reader.close();

	}
	
	public static float add (float first , float second) {
		return first + second;
	}
	
	public static float subtract (float first , float second) {
		return first - second;
	}
	
	public static float multiply (float first , float second) {
		return first * second;
	}

	public static float divide (float first , float second) {
		return first / second;
	}
	
	public static float modulus (float first , float second) {
		return first % second;
	}
	
	public static void printer (float first, float second) {
		float result = 0; 
		
		System.out.println("Your first number is: " + first);
		System.out.println("Your second number is: " + second);
		
		result = add(first,second) ;
		System.out.println("Addition: " + first + " + " + second + " = " + result);
		
		result = subtract(first,second) ;
		System.out.println("Subtraction: " + first + " - " + second + " = " + result);
		
		result = multiply(first,second) ;
		System.out.println("Multiplication: " + first + " * " + second + " = " + result);
		
		result = divide(first,second) ;
		System.out.println("Division: " + first + " / " + second + " = " + result);
		
		result = modulus(first,second) ;
		System.out.println("Remainder: The remainder of " + first + " / " + second + " is " + result);
	
	
	}
}
