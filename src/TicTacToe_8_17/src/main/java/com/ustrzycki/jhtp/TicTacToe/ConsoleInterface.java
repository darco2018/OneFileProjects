package com.ustrzycki.jhtp.TicTacToe;

import java.util.Scanner;

//Creates a TicTactoe object which makes it possible to play 1 game
// The class makes it possible to play the game on a console
// This class provides a loop to play another game if the user wants to without closing the application
public class ConsoleInterface {

	public static void main(String[] args) {
		
		//// Create game and initialize it.		
				
		TicTacToe game = new TicTacToe(3, 3);
		Scanner keyboard = new Scanner(System.in);
		
		boolean anotherGame = false;
		
		do
		{
			game.playOneGame();
			
			//This part to be replaced with a "RESTART" button
			System.out.printf("%nPress 1 to play again, or any other key to exit.%n");	
			
			if(keyboard.hasNextInt())
			{
				if(keyboard.nextInt() == 1)
				{
					anotherGame = true;
					game.restartGame();	
				}		
				else
					anotherGame = false;
			}
			else
			{
				anotherGame = false;
			}
			
		} while(anotherGame == true);
		
		System.out.printf("Terminating...");
	}

}
