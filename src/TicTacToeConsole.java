package com.ustrzycki.games;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Creates a TicTacToe object which makes it possible for two human players 
//to play TicTacToe against each other on console

public class TicTacToeConsole
{
	private final TicTacToeEngine engine;		
		
	public TicTacToeConsole()
	{
		engine = new TicTacToeEngine();
	}	
	
	public static void main(String[] args) {
				
		TicTacToeConsole game = new TicTacToeConsole();
		Scanner keyboard = new Scanner(System.in);		
		
		//the do-while below enables the user to play another game
		boolean anotherGame = false;
		
		do
		{
			game.playOneGame();
			
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
		
		System.out.printf("GAME OVER");
		keyboard.close();
	} // end main

	//run one complete TicTacToe game until it's won or drawn
	public void playOneGame()
	{				
		boolean xTurn = true;		
		boolean continueGame = true;
		
		do
		{				
			refreshBoard(engine.getBoard()); // update the board on the screen		
			displayWhoseMoveMessage(xTurn);	   
			
			// get the number of the square the user chose and place X/Y in it
			int numberOfSquareToMark = getNumberOfSquareToMark(); 
			engine.setMarkInSquare(numberOfSquareToMark, xTurn ); 				
			
			// unless the game is won or drawn, change the players' turn and keep continueGame true
			if (engine.isTheGameWon())
			{
				displayWinningMessage(xTurn); 
				continueGame = false;
			}			
			else
			{
				if(engine.isTheGameDrawn())
				{
					displayDrawMessage(); 
					continueGame = false;
				}
				else
				{
					xTurn = engine.changePlayer(xTurn); 
				}
			}
			
		} while (continueGame == true);    
				
		refreshBoard(engine.getBoard());	// update the board on the screen		
	}
	
	public void restartGame()
	{
		engine.resetBoard();
	}
	
	//input and return the number of the square a player chose 
	private int getNumberOfSquareToMark()
	{		
		Scanner sc = new Scanner(System.in);
		int chosenSquare = -1;
		
		do
		{
			System.out.printf("Choose the number of a free square and press ENTER. %n");			
			String input = sc.next();
					
			if(isIntegerInRange(input))
			{
				if(engine.isSquareEmpty(Integer.valueOf(input)))
					chosenSquare = Integer.valueOf(input);
				else
					System.out.print("This square is NOT empty!\n");
			}
			
		} while (chosenSquare == -1);    
		
		return chosenSquare;
	}
	
	// display the updated board
	private void refreshBoard(Values[][] valuesBoard)
	{
		String[][]PlayersBoard = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "9"},
				};
		
		// replace square numbers from PlayersBoard with O and X
		for(int row = 0; row < valuesBoard.length; row++)
		{
			for(int column = 0; column < valuesBoard[row].length; column++)
			{
				switch(valuesBoard[row][column])
				{
					case EMPTY:						
						break;
					case O:
						PlayersBoard[row][column] = "O";
						break;
					case X:	
						PlayersBoard[row][column] = "X";
						break;
					default:
						System.out.println("Error - wrong value.");
				}
			}
		}		
		
		// output the updated board to the console		
		int counter = 1;	
		
		for(String row[] : PlayersBoard)
		{
			for (String value : row)
			{
				System.out.printf("%4s", value);
				
				if (counter % 3 == 0)
					System.out.println();
				
				counter++;
			}
		}	
	}
	
	// three messages displaying messages for the players
	private void displayWinningMessage(boolean xTurn)
	{		
		System.out.printf("%n%s%n", engine.getWinningMessage(xTurn));
	}
	
	private void displayDrawMessage()
	{		
		System.out.printf("%n%s%n", engine.getDrawMessage());
	}	
	
	private void displayWhoseMoveMessage(boolean xTurn)
	{		
		System.out.printf("%n%s", engine.getWhoseMoveMessage(xTurn));
	}
	
	// check if the input number of the square is an integer larger than 0 
	// and less or equal to the number of squares in the board
		private boolean isIntegerInRange(String input)
		{		
			Pattern expression = Pattern.compile("[1-" + engine.getNumberOfAllSquares() + "]");
			Matcher matcher = expression.matcher(input);
			
			return matcher.matches();
		}
}