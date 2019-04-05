import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	static int rps = 1;
	static int rpsls = 2;
	static int computerScore = 0;
	static int playerScore = 0;
	static int tie = 0;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String choice = "";

		computerScore = 0;
		playerScore = 0;
		tie = 0;

		do {

			writeMainMenu();
			choice = reader.next();

			switch (choice) {
			case "1":
				playRPS(reader);
				break;
			case "2":
				playRPSLS(reader);
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

		System.out.println("**************************************************");
		System.out.println("*                    Main Menu                   *");
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

	public static void playRPS(Scanner reader) {
		String select = "";
		String computer = "";
		String player = "";
		String winner = "";
		String playAgain = "";

		System.out.println("You chose to play Rock Paper Scissors");

		do {

			do {
				writeRPSmenu();

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

	public static void playRPSLS(Scanner reader) {
		String select = "";
		String computer = "";
		String player = "";
		String winner = "";
		String playAgain = "";

		System.out.println("You chose to play Rock Paper Scissors Lizard Spock");

		do {

			do {
				writeRPSLSmenu();

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
		System.out.println("Thanks for playing!!!");
	}

	public static void writeRPSmenu() {

		System.out.println("**************************************************");
		System.out.println("*              Rock Paper Scissors               *");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("* Nbr    Action                                  *");
		System.out.println("*   1    Rock                                    *");
		System.out.println("*   2    Paper                                   *");
		System.out.println("*   3    Scissors                                *");
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
		System.out.println("Choose your weapon!:");

	}

	public static String computersWeapon(int game) {
		String weapon = "";
		int randNum = -1;
		Random randNumGenerator = new Random();

		if (game == rps) {
			// playing Rock Paper Scissors
			randNum = randNumGenerator.nextInt(100) % 3;
		} else {
			// playing Rock Paper Scissors
			randNum = randNumGenerator.nextInt(100) % 5;
		}
		switch (randNum) {
		case 0:
			weapon = "Rock";
			break;
		case 1:
			weapon = "Paper";
			break;
		case 2:
			weapon = "Scissors";
			break;
		case 3:
			weapon = "Lizard";
			break;
		case 4:
			weapon = "Spock";
			break;

		default:
			System.out.println("oops");
			weapon = "";
			break;
		}

		return weapon;

	}

	public static void writeRPSLSmenu() {

		System.out.println("**************************************************");
		System.out.println("*              Rock Paper Scissors               *");
		System.out.println("**************************************************");
		System.out.println("*                                                *");
		System.out.println("* Nbr    Action                                  *");
		System.out.println("*   1    Rock                                    *");
		System.out.println("*   2    Paper                                   *");
		System.out.println("*   3    Scissors                                *");
		System.out.println("*   4    Lizard                                  *");
		System.out.println("*   5    Spock                                   *");
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
		System.out.println("Choose your weapon!:");

	}

	public static String checkWin(String player, String computer) {

		String message = "";

		switch (player) {
		case "Rock":
			switch (computer) {
			case "Rock":
				message = "Player and computer tie. No Winner!";
				tie = tie + 1;
				break;
			case "Paper":
				message = "Paper covers rock! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Scissors":
				message = "Rock breaks scissors! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Lizard":
				message = "Rock crushes lizard! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Spock":
				message = "Spock vaporizes rock! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			default:
				message = ("oops");
				break;
			}
			break;
		case "Paper":
			switch (computer) {
			case "Rock":
				message = "Paper covers rock! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Paper":
				message = "Player and computer tie. No Winner!";
				tie = tie + 1;
				break;
			case "Scissors":
				message = "Scissors cuts paper! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Lizard":
				message = "Lizard eats paper! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Spock":
				message = "Paper disproves Spock! You win!!";
				playerScore = playerScore + 1;
				break;
			default:
				message = ("oops");
				break;
			}
			break;
		case "Scissors":
			switch (computer) {
			case "Rock":
				message = "Rock breaks scissors! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Paper":
				message = "Scissors cuts paper! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Scissors":
				message = "Player and computer tie. No Winner!";
				tie = tie + 1;
				break;
			case "Lizard":
				message = "Scissors decapitates lizard! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Spock":
				message = "Spock smashes scissors! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			default:
				message = ("oops");
				break;
			}
			break;
		case "Lizard":
			switch (computer) {
			case "Rock":
				message = "Rock crushes lizard! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Paper":
				message = "Lizard eats paper! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Scissors":
				message = "Scissors decapitates lizard! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Lizard":
				message = "Player and computer tie. No Winner!";
				tie = tie + 1;
				break;
			case "Spock":
				message = "Lizard poisons Spock! You win!!";
				playerScore = playerScore + 1;
				break;
			default:
				message = ("oops");
				break;
			}
			break;
		case "Spock":
			switch (computer) {
			case "Rock":
				message = "Spock vaporizes rock! You win!!";
				playerScore = playerScore + 1;
				break;
			case "Paper":
				message = "Paper disproves Spock! Computer wins!!";
				playerScore = computerScore + 1;
				break;
			case "Scissors":
				message = "Spock smashes scissors! You win!!";
				computerScore = playerScore + 1;
				break;
			case "Lizard":
				message = "Lizard poisons Spock! Computer wins!!";
				computerScore = computerScore + 1;
				break;
			case "Spock":
				message = "Player and computer tie. No Winner!";
				tie = tie + 1;
				break;
			default:
				message = ("oops");
				break;
			}
			break;
		default:
			message = ("oops");
			break;
		}
		return message;
	}
}
