import java.util.Scanner;

public class VowelGame {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String choice = "";

		do {

			writeMainMenu();
			choice = reader.next();

			switch (choice) {
			case "1":
				translateToPigLatin(reader);
				break;
			case "2":
				translateToEnglish(reader);
				break;
			case "3":
				exitGame();
				break;
			default:
				System.out.println("That was an invalid selection. Please try again!");
				choice = "";
				break;
			}
		} while (!choice.matches("3"));

		reader.close();

	}

	public static void writeMainMenu() {

		System.out.println("****************************************************");
		System.out.println("*               Pig Latin Translator               *");
		System.out.println("*            Igpay Atinlay Anslatortray            *");
		System.out.println("****************************************************");
		System.out.println("*                                                  *");
		System.out.println("* Nbr    Action                                    *");
		System.out.println("*   1    Translate from English to Pig Latin       *");
		System.out.println("* Anslatetray omfray Englishyay otay Igpay Atinlay *");
		System.out.println("*                                                  *");
		System.out.println("*   2    Translate from Pig Latin to English       *");
		System.out.println("* Anslatetray omfray Igpay Atinlay otay Englishyay *");
		System.out.println("*                                                  *");
		System.out.println("*   3    Exit Translator                           *");
		System.out.println("*        Exityay Anslatortray                      *");
		System.out.println("*                                                  *");
		System.out.println("****************************************************");
		System.out.println("Enter the number for the action you would like to take:");

	}

	public static void translateToPigLatin(Scanner reader) {
		String select = "";
		String playAgain = "";

		System.out.println("You chose to translate from English to Pig Latin.");

		do {

			do {
				writeToPigmenu();

				select = reader.next();

				switch (select.toUpperCase()) {
				case "1":
				case "ROCK":
					player = "Rock";
					break;
				case "2":
				case "PAPER":
					player = "Paper";
					break;
				case "3":
				case "SCISSORS":
					player = "Scissors";
					break;
				default:
					System.out.println("That was an invalid selection. Please try again!");
					player = "";
					break;
				}
			} while (player.matches(""));

			computer = computersWeapon(rps);

			System.out.println("You choose: " + player + ".");
			System.out.println("Computers chooses: " + computer + ".");
			winner = checkWin(player, computer);

			System.out.println(winner);

			System.out.println("Do you want to play again?  Y/N: ");
			playAgain = reader.next();
			playAgain = playAgain.toUpperCase();

		} while (!playAgain.matches("N"));

	}

	public static void translateToEnglish(Scanner reader) {
		String select = "";

		String playAgain = "";

		System.out.println("You chose to translate from Pig Latin to Englih.");

		do {

			do {
				writeToEnglishmenu();

				select = reader.next();

				switch (select.toUpperCase()) {
				case "1":
				case "ROCK":
					player = "Rock";
					break;
				case "2":
				case "PAPER":
					player = "Paper";
					break;
				case "3":
				case "SCISSORS":
					player = "Scissors";
					break;
				case "4":
				case "LIZARD":
					player = "Lizard";
					break;
				case "5":
				case "SPOCK":
					player = "Spock";
					break;
				default:
					System.out.println("That was an invalid selection. Please try again!");
					player = "";
					break;
				}
			} while (player.matches(""));

			computer = computersWeapon(rpsls);

			System.out.println("You choose: " + player + ".");
			System.out.println("Computers chooses: " + computer + ".");
			winner = checkWin(player, computer);

			System.out.println(winner);

			System.out.println("Do you want to play again?  Y/N: ");
			playAgain = reader.next();
			playAgain = playAgain.toUpperCase();

		} while (!playAgain.matches("N"));
	}

	public static void exitGame() {
		System.out.println("Thanks for Pig Latin Translator!!!");
	}

	public static void writeToPigmenu() {

		System.out.println("****************************************************");
		System.out.println("*               Pig Latin Translator               *");
		System.out.println("*            Igpay Atinlay Anslatortray            *");
		System.out.println("****************************************************");
		System.out.println("*                                                  *");
		System.out.println("* Enterya ethay igpay atinlay ordwa orya asephray  *");
		System.out.println("* ouyay antway anslatedtray otay Englishay.        *");
		System.out.println("*                                                  *");
		System.out.println("* Enter the pig latin word or phrase you want      *");
		System.out.println("* translated to English.                           *");
		System.out.println("*                                                  *");
		System.out.println("****************************************************");
		System.out.println("Translate Anslatetray:");

	}

	public static void writeToEnglishmenu() {

		System.out.println("****************************************************");
		System.out.println("*               Pig Latin Translator               *");
		System.out.println("*            Igpay Atinlay Anslatortray            *");
		System.out.println("****************************************************");
		System.out.println("*                                                  *");
		System.out.println("* Enter the pig latin word or phrase you want      *");
		System.out.println("* translated to English.                           *");
		System.out.println("*                                                  *");
		System.out.println("* Enterya ethay igpay atinlay ordwa orya asephray  *");
		System.out.println("* ouyay antway anslatedtray otay Englishay.        *");
		System.out.println("*                                                  *");
		System.out.println("****************************************************");
		System.out.println("Anslatetray Translate:");

	}

}
