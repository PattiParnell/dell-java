
public class TicTacToe {

 static char board [] [] ;
 
	public static void main(String[] args) {
		
		boolean playGame = true ;
		
		initializeBoard (); 

		do {
			
			printBoard ();
		
		checkwin();
		
	} playGame;

}
	public static void printBoard () {
		
		System.out.println("**************************************************");
		System.out.println("*                Tic Tac Toe Board               *");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("* Nbr    Action                                  *");
		System.out.println("*   1    Play Rock Paper Scissors                *");
		System.out.println("*   2    Play Rock Paper Scissors Lizard Spock   *");
		System.out.println("*   3    Exit Game                               *");
		System.out.println("*                                                *");
		System.out.println("*------------------------------------------------*");
		System.out.println("*                     Score                      *");
		System.out.println("*------------------------------------------------*");
		System.out.println("* Player      Score                              *");
		System.out.println("*------------------------------------------------*");
		System.out.println("* Human          " + playerScore + "                               *");
		System.out.println("* Computer       " + computerScore + "                               *");
		System.out.println("* Ties           " + tie + "                               *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
		System.out.println("Enter the number for the action you would like to take:");

		
		
	}
	
	public static void initializeBoard () {
		char[][] board = {
			      { ' ', ' ', ' ' },
			      { ' ', ' ', ' ' },
			      { ' ', ' ', ' ' },
			    };
	}

}