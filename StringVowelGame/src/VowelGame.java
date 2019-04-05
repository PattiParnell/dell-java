import java.util.Random;
import java.util.Scanner;

public class VowelGame {

	public static void main(String[] args) {

		translateToPigLatin();

	}

	public static void translateToPigLatin() {
		Scanner reader = new Scanner(System.in);
		String select = "";
		String playAgain = "";
		String translation = "";

		do {
			writeToPigmenu();

			select = reader.nextLine();
			select = (select.trim());

			translation = translatePhrase(select);

			System.out.println(translation);
			System.out.println("Do you want to translate another work or phrase?  Y/N: ");
			playAgain = reader.nextLine();
			playAgain = playAgain.toUpperCase();

		} while (!playAgain.matches("N"));

		reader.close();

	}

	public static void writeToPigmenu() {

		System.out.println("****************************************************");
		System.out.println("*               Pig Latin Translator               *");
		System.out.println("*            Igpay Atinlay Anslatortray            *");
		System.out.println("****************************************************");
		System.out.println("*                                                  *");
		System.out.println("* Enter the word or phrase you want translated     *");
		System.out.println("* to Pig Latin.                                    *");
		System.out.println("*                                                  *");
		System.out.println("* Enterya ethay igpay atinlay ordwa orya asephray  *");
		System.out.println("* ouyay antway anslatedtray otay Englishay.        *");
		System.out.println("*                                                  *");
		System.out.println("****************************************************");
		System.out.println("Translate Anslatetray:");

	}

	public static Boolean isVowel(char myChar) {
		String vowels = "AEIOUaeiou";
		Boolean bVowel = false;

		if (vowels.indexOf(myChar) > 0) {
			bVowel = true;
		}

		return bVowel;

	}

	public static Boolean isY(char myChar) {
		String checkY = "Yy";
		Boolean bIsY = false;

		if (checkY.indexOf(myChar) > 0) {
			bIsY = true;
		}

		return bIsY;

	}

	public static Boolean isSpace(char myChar) {
		Boolean isSpace = false;

		if (myChar == ' ') {
			isSpace = true;
		}

		return isSpace;

	}

	public static String translateWord(String word) {
		String strTranslation = "";
		String temp = "";
		String temp2 = "";

		Boolean firstLetter = true;
		Boolean beginVowel = false;
		Boolean foundVowel = false;

		for (int i = 0; i < word.length(); i++) {

			if (firstLetter) {

				firstLetter = false;

				if (isVowel(word.charAt(i))) {
					// goto end of string
					beginVowel = true;
					foundVowel = true;
					temp = temp + word.charAt(i);

				} else {

					temp2 = temp2 + word.charAt(i);

				}

			} else {
				if (foundVowel) {
					temp = temp + word.charAt(i);

				} else {
					if (isVowel(word.charAt(i)) || isY(word.charAt(i))) {
						foundVowel = true;
						temp = temp + word.charAt(i);
					} else {
						temp2 = temp2 + word.charAt(i);
					}
				}
			}

		}

		if (beginVowel) {
			strTranslation = temp + vowenEnding();
		} else {
			strTranslation = temp + temp2 + "ay";

		}
		strTranslation = strTranslation.toLowerCase();

		return strTranslation;
	}

	public static String vowenEnding() {
		String ending = "";
		int randNum = -1;
		Random randNumGenerator = new Random();

		randNum = randNumGenerator.nextInt(100) % 3;

		switch (randNum) {
		case 0:
			ending = "ay";
			break;
		case 1:
			ending = "way";
			break;
		case 2:
			ending = "yay";
			break;

		default:
			System.out.println("oops");
			ending = "";
			break;
		}

		return ending;

	}

	public static String translatePhrase(String phrase) {
		String strTranslation = "";
		String word = "";
		int intBeginNextWord = 0;
		int i = 0;

		if (phrase.indexOf(" ") == 0) {
			strTranslation = translateWord(phrase);
		}

		else {

			for (i = 0; i < phrase.length(); i++) {

				if (isSpace(phrase.charAt(i))) {
					// goto end of string

					word = phrase.substring(intBeginNextWord, i);
					intBeginNextWord = i + 1;
					strTranslation = strTranslation + translateWord(word) + " ";
					word = "";
				}
			}

			word = phrase.substring(intBeginNextWord, phrase.length());
			strTranslation = strTranslation + translateWord(word) + " ";
		}

		return strTranslation;
	}
}
