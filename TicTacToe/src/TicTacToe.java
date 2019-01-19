import java.util.Scanner;

public class TicTacToe {
	static int playerX_Score = 0;
	static int playerO_Score = 0;
	static int tie = 0;
	static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, };

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String choice = "0";
		Boolean playNewGame = false;

		do {
			printTicTacToeMenu();
			choice = reader.nextLine();
			choice = choice.trim();

			switch (choice) {
			case "1":
				do {
					playNewGame = playTicTacToe(reader);
				} while (playNewGame);

				break;
			case "2":
				exitGame();
				playNewGame = false;
				break;
			default:
				System.out.println("That was an invalid selection. Please try again!");
				playNewGame = false;
				choice = "0";
				break;
			}
		} while (choice != "2");

		reader.close();
	}

	public static Boolean playTicTacToe(Scanner myReader) {
		char player = ' ';
		Boolean playGame = true;
		String playAgain = "";

		initializeBoard();

		do {

			printTicTacToeBoard();

			if (checkTie()) {
				tie = tie + 1;
				playGame = false;
				System.out.println("Game was a tie.  No winner.");
				break;

			}

			if (checkWin(player)) {
				System.out.println("Congratulations Player " + player + " !!  You won!!");

				if (player == 'X') {
					playerX_Score = playerX_Score + 1;
				} else {
					playerO_Score = playerO_Score + 1;
				}

				playGame = false;
			} else {

				player = changePlayer(player);
				takeTurn(player, myReader);

				System.out.println("Player " + player + "'s turn.");
			}

		} while (playGame);

		System.out.println("Do you want to play again?  Y/N: ");
		playAgain = myReader.nextLine();
		playAgain = playAgain.trim();
		playAgain = playAgain.toUpperCase();

		if (playAgain.matches("Y")) {
			return true;

		} else {
			return false;
		}

	}

	public static void printTicTacToeMenu() {

		System.out.println("**************************************************");
		System.out.println("*                Tic Tac Toe Menu                *");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("* Nbr    Action                                  *");
		System.out.println("*   1    2 Players                               *");
		System.out.println("*   2    Exit Game                               *");
		System.out.println("*                                                *");
		System.out.println("*------------------------------------------------*");
		System.out.println("*                     Score                      *");
		System.out.println("*------------------------------------------------*");
		System.out.println("* Player      Score                              *");
		System.out.println("*------------------------------------------------*");
		System.out.println("* Player X       " + playerX_Score + "                               *");
		System.out.println("* Player O       " + playerO_Score + "                               *");
		System.out.println("* Ties           " + tie + "                               *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");
		System.out.println("Enter the number for the action you would like to take:");

	}

	public static void printTicTacToeBoard() {

		System.out.println("**************************************************");
		System.out.println("*               Tic Tac Toe Board                *");
		System.out.println("**************************************************");
		System.out.println("*                     Column                     *");
		System.out.println("*                 0     1     2                  *");
		System.out.println("*               -----------------                *");
		System.out.println("*                    |     |                     *");
		System.out.println("*  Row 0          " + board[0][0] + "  |  " + board[0][1] + "  |  " + board[0][2]
				+ "                  *");
		System.out.println("*               _____|_____|_____                *");
		System.out.println("*                    |     |                     *");
		System.out.println("*  Row 1          " + board[1][0] + "  |  " + board[1][1] + "  |  " + board[1][2]
				+ "                  *");
		System.out.println("*               _____|_____|_____                *");
		System.out.println("*                    |     |                     *");
		System.out.println("*  Row 2          " + board[2][0] + "  |  " + board[2][1] + "  |  " + board[2][2]
				+ "                  *");
		System.out.println("*                    |     |                     *");
		System.out.println("*                                                *");
		System.out.println("**************************************************");

	}

	public static void initializeBoard() {

		for (int i = 0; i < 3; i++) {

			for (int y = 0; y < 3; y++) {

				board[i][y] = ' ';
			}

		}
	}

	public static Boolean checkWin(char myPlayer) {
		Boolean win = false;

		if (((board[0][0] == board[0][1]) && (board[0][0] == board[0][2]) && (board[0][0] != ' '))
				|| ((board[1][0] == board[1][1]) && (board[1][0] == board[1][2]) && (board[1][0] != ' '))
				|| ((board[2][0] == board[2][1]) && (board[2][0] == board[2][2]) && (board[2][0] != ' '))
				|| ((board[0][0] == board[1][0]) && (board[0][0] == board[2][0]) && (board[0][0] != ' '))
				|| ((board[0][1] == board[1][1]) && (board[0][1] == board[2][1]) && (board[0][1] != ' '))
				|| ((board[0][2] == board[1][2]) && (board[0][2] == board[2][2]) && (board[0][2] != ' '))
				|| ((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[0][0] != ' '))
				|| ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board[0][2] != ' '))) {
			win = true;

		}

		return win;
	}

	public static char changePlayer(char myPlayer) {
		if (myPlayer == 'X') {
			myPlayer = 'O';
		} else {
			myPlayer = 'X';
		}

		return myPlayer;
	}

	public static void takeTurn(char myPlayer, Scanner myReader) {
		String row = "";
		String column = "";
		Boolean validPlay = false;
		Boolean validRow = false;
		Boolean validColumn = false;

		do {

			System.out.println("Player " + myPlayer + "'s turn.");
			do {
				System.out.println("Which row would you like to put your " + myPlayer + "?");
				row = myReader.nextLine();
				row = row.trim();
				

				if ((Integer.parseInt(row) >= 0) && (Integer.parseInt(row) <= 2)) {
					validRow = true;
				}
			} while (!validRow);

			do {
				System.out.println("Which column would you like to put your " + myPlayer + "?");
				column = myReader.nextLine();
				column = column.trim();

				if ((Integer.parseInt(column) >= 0) && (Integer.parseInt(column) <= 2)) {
					validColumn = true;
				}
			} while (!validColumn);

			if (isValidPlay(Integer.parseInt(row), Integer.parseInt(column))) {
				board[Integer.parseInt(row)][Integer.parseInt(column)] = myPlayer;
				System.out.println("Row: " + row + " column: " + column + " was played");
				validPlay = true;
			} else {
				System.out.println("Row: " + row + " column: " + column + " are already taken. Try again!");
				row = "";
				column = "";
				validPlay = false;
			}

		} while (!validPlay);

	}

	public static Boolean isValidPlay(Integer myRow, Integer myCol) {
		Boolean isValid = false;

		if (board[myRow][myCol] == ' ') {
			isValid = true;
		}

		return isValid;

	}

	public static Boolean checkTie() {
		Boolean isTie = true;

		for (int i = 0; i < 3; i++) {

			for (int y = 0; y < 3; y++) {

				if (board[i][y] == ' ') {
					isTie = false;
					break;
				}
			}

		}

		return isTie;
	}

	public static void exitGame() {
		System.out.println("Thanks for playing!!!");
	}

}