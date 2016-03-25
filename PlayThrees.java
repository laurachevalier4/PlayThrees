/*
 * Laura Chevalier
 * Intro to Computer Science
 * Professor Versoza
 */
import java.util.Scanner;
public class PlayThrees {
	//Simulates a game of Threes
	public static void main(String[] args) {
		String pinnedDice = "";
		Scanner input = new Scanner(System.in);
		String symbol = "";
		int unpinnedDice = 5;
		String rolledDice = "";
		String symbols = "";
		String pinnedSymbols = "";
		int finalScore = 0;
		//roll all unpinned dice
		while (pinnedDice.length() < 5) {
			rolledDice = "";
			for (int i = 1; i <= unpinnedDice; i++) {
			int die = (int) (1 + (Math.random() * 6));
			switch (die) {
				case 1: symbol = "\u2680";
						break;
				case 2: symbol = "\u2681";
						break;
				case 3: symbol = "\u2682";
						break;
				case 4: symbol = "\u2683";
						break;
				case 5: symbol = "\u2684";
						break;
				case 6: symbol = "\u2685";
						break;
				//^Can store these in a string and index into it instead of
				//using a switch statement
			}
			rolledDice += die;
			symbols += symbol;
			System.out.printf("Die Roll " + i + " - " + symbol + " (%s)\n", die);
			}
			//pin die automatically if only 1 remains
			if (unpinnedDice == 1) {
				System.out.println("Automatically pin last die.");
				pinnedDice += rolledDice.charAt(0);
				pinnedSymbols += symbol;
				System.out.printf("Pinned: %s (%s)\n", pinnedSymbols, pinnedDice);
			} //ask user to pin dice 
			else {
				System.out.println("Which dice would you like to pin? "
						+ "For example, to pin the dice 1 and 2, enter 12.\n> ");
				String diceToPin = input.next();
				for (int j = 0; j < diceToPin.length(); j++) {
					int index = Character.getNumericValue(diceToPin.charAt(j)) - 1;
					pinnedDice += rolledDice.charAt(index);
					unpinnedDice -= 1;
					pinnedSymbols += symbol;
			} 
			System.out.printf("Pinned: %s (%s)\n", pinnedSymbols, pinnedDice); 
		}
	} //calculate score (3 counts as 0)
		for (int k = 0; k < 5; k++) {
		int pointValue = Character.getNumericValue(pinnedDice.charAt(k));
		if (pointValue == 3) {
			continue;
		}
		finalScore += pointValue; 
	}
	System.out.println("Final score: " + finalScore);
}
}
