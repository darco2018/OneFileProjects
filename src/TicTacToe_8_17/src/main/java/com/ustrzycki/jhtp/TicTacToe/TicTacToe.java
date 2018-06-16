package com.ustrzycki.jhtp.TicTacToe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicTacToe
{
	private Board board;	
		
	public TicTacToe(int boardWidth, int winningLength)
	{
		board = new Board(boardWidth, winningLength);
	}

	//Runs a complete TicTacToe game until it's won or drawn
	public void playOneGame()
	{				
		boolean xTurn = true;		
		boolean continueGame = true;
		
		do
		{			
			displayBoard(board.getBoard());			// System.out and uses a Board instance method
			displayWhoseMoveMessage(xTurn);	         // System.out
			int numberOfSquareToMark = getNumberOfSquareToMark(); // System.in  System.out
			setMarkInSquare(numberOfSquareToMark, xTurn ); // uses a Board instance method 				
			
			if (isTheGameWon())
			{
				displayWinningMessage(xTurn); // System.out
				continueGame = false;
			}			
			else
			{
				if(isTheGameDrawn())
				{
					displayDrawMessage(); // System.out
					continueGame = false;
				}
				else
				{
					xTurn = changePlayer(xTurn); // not dependent on other classes
				}
			}
			
		} while (continueGame == true);   // 
				
		displayBoard(board.getBoard());	// System.out and uses a Board instance method
				
		
		//System.out.println("Game over!");
	}
	
	private void displayWinningMessage(boolean xTurn)
	{
		String message = (xTurn ? "X" : "O") + " wins!!!";
		System.out.printf("%n%s%n", message);
	}
	
	private void displayDrawMessage()
	{
		String message = "It's a draw!!!";
		System.out.printf("%n%s%n", message);
	}
	
	
	private void displayWhoseMoveMessage(boolean xTurn)
	{
		String message = "It's " + (xTurn ? "X's" : "O's ") + " move.";
		System.out.printf("%n%s", message);
	}
	
	public void restartGame()
	{
		board.resetBoard();
	}
	
	//Inputs and returns the number of the square a player chose 
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
				if(board.isSquareEmpty(Integer.valueOf(input)))
					chosenSquare = Integer.valueOf(input);
				else
					System.out.print("This square is NOT empty!\n");
			}
				
		} while (chosenSquare == -1);    	
		
		return chosenSquare;
	}
	
	// Checks if this input is an integer and whether it is larger than 0 and less or equal to the number
	// of squares in the board
	private boolean isIntegerInRange(String input)
	{		
		Pattern expression = Pattern.compile("[1-" + board.getNumberOfAllSquares() + "]");
		Matcher matcher = expression.matcher(input);
		
		return matcher.matches();
	}
	
	// take this code straight into a GUI setup where starting your JFrame constructor would create and initialize this class 
	//and clicking a square would trigger the setMarkInSquare() method. A reset button might trigger the board.resetBoard() method 
	//and you could either use the displayBoard() function to display the board in your GUI.
	public void setMarkInSquare(int numberOfSquareToMark, boolean xTurn )
	{
		board.setXorYinSquare(numberOfSquareToMark, xTurn);
	}
	
	public boolean changePlayer(boolean xTurn)
	{
		return !xTurn;
	}
	
	// Checks if the game is won
	private boolean isTheGameWon()
	{
		return ( board.hasThreeTheSameMarksInRow() || 
				board.hasThreeTheSameMarksInColumn() || 
				board.hasThreeTheSameMarksDiagonally() );
	}
	
	private boolean isTheGameDrawn()
	{
		boolean drawn = false;
		// if the game is NOT won, check ...
		if(!isTheGameWon())
		{
			// if it is NOT true that there is even 1 empty square
			if(!board.isAtLeastOneEmptySquare())
			{
				//then 
				drawn = true;
			}
		}	
		
		return drawn;
	}
	
	// Display the current board (may be replaced by GUI implementation later)
	private void displayBoard(Values[][] valuesBoard)
	{
		String[][]PlayersBoard = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "9"},
				};
		
		// transform original values into Strings O, X and square numbers
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
		// display the players' current board		
		
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
	
	}// end displayBoard

}

