package de.demo.commandlinedicegame;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean exit = false;		
		GUI gui = new GUI();
		Scanner sc = new Scanner(System.in);
		String input; //used to read user's input
		
		/*
		 * The game has 4 stages:
		 * stage 0 - the game's just begun and it's >PlayerOne<'s turn
		 * 			 here user can type 'throw' or 'exit'
		 * 
		 * stage 1 - it's >PlayerTwo<'s turn
		 * 			 here user can also type 'throw' or 'exit'
		 * 
		 * stage 2 - the score is shown and the winner is proclaimed 
		 * 
		 * stage 3 - the user can type 'yes' to start over or 'no' or 'exit' to quit
		 */
		int stage = 0;

		int scorePlayerOne = 0;
		int scorePlayerTwo = 0;
		
		gui.showIntro();
		
		while(!exit) {
			input = sc.next();
						
			if (input.equals("throw")) {
				
				if (stage == 0) {
					//the dice is thrown and the sum of two random numbers is returned by GUI
					scorePlayerOne = gui.drawDice(getRandomNumber(),getRandomNumber());
					System.out.println("\n>PlayerTwo< throw the dice!");
				} else if (stage == 1) {
					//the same happens for >PlayerTwo<
					scorePlayerTwo = gui.drawDice(getRandomNumber(),getRandomNumber());
				}
				if (stage < 2) {stage++;}
			}
			
			if (stage == 2) {
				//The score is shown and the winner is chosen
				gui.showScore(scorePlayerOne, scorePlayerTwo);
				stage++;
			}
			
			//If 'yes' is inputed, the game starts anew
			if (stage == 3 && input.equals("yes")){
				scorePlayerOne = 0;
				scorePlayerTwo = 0;
				stage = 0;
				gui.showIntro();
				
			}
			
			sc.nextLine(); // it's used to ignore the rest of the input
			
			//if 'exit' or 'no' (during stage 3) is inputed the program terminates
			if (input.equals("exit") || (stage == 3 && input.equals("no")) ) {
				exit = true;
				sc.close();
				gui.showOutro();
			}
		}

	}
	
	private static int getRandomNumber() {
		return (int) (1 + Math.random() * 5);
	}

}
