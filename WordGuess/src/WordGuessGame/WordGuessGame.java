package WordGuessGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		// array used to hold possible works to guess that is read in from a file.
		String guessedLetters = "";
		// holds list of guessed letters
		String hiddenWord = "";
		// holds the hidden word that is revealed with correct guesses.
		Integer wordCount = 0;
		// counts of words in the file or array
		String guessingWord = "";
		// holds the word the user is trying to guess
		Boolean winner = false;
		// holds indicator if user has won
		Scanner reader = new Scanner(System.in);
		// reader for interaction with the user

		try {
			wordCount = readInFile(words); // reads in file of words
			guessingWord = findRandomWord(words, wordCount); // gets random word for user to guess
			hiddenWord = getHiddenWord(guessingWord, guessedLetters); // gets masked word user to show the user

			do {
				guessedLetters = guessedLetters + printInstructions(reader, hiddenWord, guessedLetters);
				// gets letters guessed by user
				hiddenWord = getHiddenWord(guessingWord, guessedLetters);
				// checks to see if the guessed letters exist in the word.
				// updates hidden word showing correctly guessed letters
				winner = checkForWin(guessingWord, hiddenWord);
				// checks to see if the user won

			} while (!winner);
			// loops till user guesses the word

		} catch (IOException e) {
			// catches io exception if there is a problem reading the file
			System.out.println("A file exception occurred: " + e.getMessage());

		}

		catch (Exception e) {
			// catches other exceptions
			System.out.println("An exception occurred: " + e.getMessage());

		}

		System.out.println("Thanks for playing!!");
		// System.out.println("My word is " + guessingWord);
		// System.out.println("My masked word is " + hiddenWord);
		reader.close();
	}

	public static Integer readInFile(List<String> myList) throws IOException {
		// method to read the file and load an array

		BufferedReader in = null;
		String line = null;
		Integer counter = 0;

		try {
			in = new BufferedReader(new FileReader("words_alpha.txt"));

			while ((line = in.readLine()) != null) {
				// as long as line is not null there is another work
				// keeps looping to all the words are read
				myList.add(line);
				counter++;
			}

		} finally {
			// Close input and output streams
			if (in != null) {
				in.close();
			}

		}
		return counter; // count of words in the file
	}

	public static String getHiddenWord(String myWord, String myGuessedLetters) {
		// creates a masked word based on word to guess

		String displayWord = "";

		for (int i = 0; i < myWord.length(); i++) {
			// for loop loops through all letters in the word.
			if (myGuessedLetters.contains(myWord.substring(i, i + 1))) {
				// if the guessed letter lives in the word, it is made visible
				displayWord = displayWord + myWord.substring(i, i + 1);
			} else {
				// if the guessed letters don't exist in the word is shows a hyphen in place of
				// the letter
				displayWord = displayWord + "-";
			}
		}

		return displayWord;

	}

	public static String findRandomWord(List<String> myList, Integer wordCount) {
		//uses random number generator and the number of words in the file
		//to pick a random word

		String myWord = "";
		Integer randNum = -1;
		Random randNumGenerator = new Random();

		randNum = randNumGenerator.nextInt(wordCount);
		myWord = myList.get(randNum);

		return myWord;

	}

	public static String printInstructions(Scanner myReader, String hidden, String guessed) {
		//shows the user the masked word with any guessed letters unmasked.
		//shows the list of guessed letters
		//prompts the user to guess

		String guessedLetter = "";

		while (guessedLetter.equals("")) {
			//loops till a valid letter is guessed.
			//duplicates, numbers, special characters are not allowed. 
			System.out.println("The word to guess is: " + hidden);
			System.out.println("The following letters have been guessed: " + guessed);
			System.out.println("What letter do you want to guess?");

			try {

				guessedLetter = getResponse(myReader.nextLine(), guessed);
				//reads and validates response from user
				
				if (guessed.contains(guessedLetter)) {
					//checks for duplicate guesses
					System.out.println("You've already guessed the letter - " + guessedLetter + ". Try again.");
					guessedLetter = "";
				}

			}

			catch (Exception e) {
				//catches and prints exceptions.
				//sets guessedletter to "" so user can try again 
				guessedLetter = "";
				System.out.println("this is the error message - " + e.getMessage());

			}

		}
		;

		return guessedLetter;  //returns validated value.

	}

	private static String getResponse(String myResponse, String guess) {
		//processes the response from the user
		
		String guessedLetter = "";
		String validLetters = "abcdefghijklmnopqrstuvwxyz";
		//string holds valid values

		guessedLetter = myResponse.trim();
		//trims strings to clear any leading or trailing spaces
		guessedLetter = guessedLetter.toLowerCase();
		//makes guessed letter lower case even if user trys upper case letter

		if (guessedLetter.length() > 1) {
			//error thrown if user enters in muliple values
			throw new java.lang.RuntimeException("Please enter in only 1 letter.");

		}
		if (!validLetters.contains(guessedLetter)) {
			//error thrown if user enters a number or special character
			throw new java.lang.RuntimeException("Please enter in only 1 letter. Special characters or numbers are not allowed.");

		}

		return guessedLetter; //returns guessed letter

	}

	public static Boolean checkForWin(String myWord, String myGuessedWord) {
		//checks to see if the user guessed the whole word.
		Boolean rc = false;

		if (myWord.equals(myGuessedWord)) {
			//compares what the user guessed so far with the word to be guessed.  
			//if it matches - user has uncovered the whole word
			System.out.println("Congratulations!! You have successfully uncovered the word: " + myWord + ".");
			rc = true;

		} else {
			rc = false;
		}

		return rc; //returns boolean to indicate win or loss.
	}

}
