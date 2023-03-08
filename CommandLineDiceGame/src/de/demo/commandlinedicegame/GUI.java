package de.demo.commandlinedicegame;

public class GUI {
	
	// the following enum is used to draw a cube line on line basis
	// the three different positions of one dot are required to draw two-dot and three-dot sides
	public enum DotAmount {
		NONE, ONE_LEFT, ONE_CENTER, ONE_RIGHT, TWO
	}
	
	public int drawDice(int dice1, int dice2) {
		
		/*
		 *   The dice will basically look like this:
		 *    _________    _________
         *   |         |  |         |      <- the top
         *   |  *   *  |  |         |      <- row 1 with dots
         *   |    *    |  |    *    |      <- row 2 with dots
         *   |  *   *  |  |         |      <- row 3 with dots
         *   |_________|  |_________|      <- the bottom
         *   
         *   The number of dots on them are random, provided by the Main class
		 */
		
		// An Array of DotAmount enums is used, because we have 3 rows with dots
		// on each dice
		DotAmount[] dotsDiceOne = getArrayOfDotsPerDiceRow(dice1);
		DotAmount[] dotsDiceTwo = getArrayOfDotsPerDiceRow(dice2);
		
		//First we draw the top
		System.out.println("   _________    _________");
		System.out.println("  |         |  |         |");
		
		//Now, we draw the 3 rows that have dots on them
		for (int i = 0; i < 3; i++) {
			System.out.println( getLineOfADie(dotsDiceOne[i]) + getLineOfADie(dotsDiceTwo[i]) );
		}
		
		//And finally we draw the bottom
		System.out.println("  |_________|  |_________|");
		
		// the sum of the numbers on the dice is returned for the purposes 
		// of comparing the scores and identifying a winner
		return dice1 + dice2;
	}
	
	//Just an introduction, it greets the user and shows the rules
	public void showIntro() {
		System.out.println("Hello and welcome to this simple dice game.");
		System.out.println(">>>RULES:<<<");
		System.out.println(">PlayerOne< throws first. To do so just type 'throw'.");
		System.out.println("Then it's >PlayerTwo<'s turn.");
		System.out.println("The one who has the highest score wins.");
		System.out.println(">>>To exit type 'exit'.\n");
		System.out.println(">PlayerOne< throw the dice!");
	}
	
	public void showOutro() {
		System.out.println("Thank you for playing this simple game!");
		System.out.println("Have a nice day!");
	}
	
	// This method compares the scores and identifies the winner
	// and asks whether the user wants to play again
	public void showScore(int score1, int score2) {
		System.out.println("\n>PlayerOne<'s score: " + score1);
		System.out.println(">PlayerTwo<'s score: " + score2);
		
		if (score1 > score2) {
			System.out.println("\nThe winner is >PlayerOne<!\n");
		} else if (score1 < score2) {
			System.out.println("\nThe winner is >PlayerTwo<!\n");
		} else {
			System.out.println("\nLooks Like it's a draw!\n");
		}
		
		System.out.println("Play Again? (yes / no)");
	}
	
	private DotAmount[] getArrayOfDotsPerDiceRow(int value) {
		// each of the possible numbers on a dice has a certain combination
		// of dots on each of the three rows that have dots in them
		switch(value) {
		case 1:
			// here, the first and the last rows are empty, and only the centre row (row 2)
			// has a dot in it
			return new DotAmount[] {DotAmount.NONE, DotAmount.ONE_CENTER, DotAmount.NONE};
		case 2:
			return new DotAmount[] {DotAmount.ONE_LEFT, DotAmount.NONE, DotAmount.ONE_RIGHT};
		case 3:
			return new DotAmount[] {DotAmount.ONE_LEFT, DotAmount.ONE_CENTER, DotAmount.ONE_RIGHT};
		case 4:
			return new DotAmount[] {DotAmount.TWO, DotAmount.NONE, DotAmount.TWO};
		case 5:
			return new DotAmount[] {DotAmount.TWO, DotAmount.ONE_CENTER, DotAmount.TWO};
		default:
			return new DotAmount[] {DotAmount.TWO, DotAmount.TWO, DotAmount.TWO};
	}
	}
	
	private String getLineOfADie(DotAmount type) {
		// this one returns a line of a single die with
		// the corresponding amount of dots, located in the right place
		// ...as you can see there aren't many possibilities
		switch(type) {
		case ONE_LEFT:
			return "  |  *      |";
		case ONE_CENTER:
			return "  |    *    |";
		case ONE_RIGHT:
			return "  |      *  |";
		case TWO:
			return "  |  *   *  |";
		default:
			return "  |         |";
		}
	}	

}
