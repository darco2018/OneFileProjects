package com.ustrzycki.jhtp.TicTacToe;

/*A 3 by 3 board for a tic tac toe game. 
It uses constants EMPTY, X, O from Values class. It is not dependent on any other classes.

The board can initialize and reset its squares to EMPTY, send a copy of the board, tell if a given square is empty,
place X or O in a given square, decide if there are 3 X's or 3 O's in a row horizontally, vertically or diagonally.

It has a potential to be expanded into a board of any width and work for winning lengths larger than 3 X's or 3 O's in a row,
as it takes the size of the square and a winning length as arguments to the constructor.
Some methods have been optimized for this purpose but not tested, some have not been written yet (e.g. check if there are
n same elements in a row horizontally, vertically or diagonally).

*/


public class Board {

	private Values[][] surface; // the 3x3 board
	private final Values initialValue = Values.EMPTY; // the value to which the surface is initialized	
	private final int WINNNING_LENGTH; // for the classic TicTacToe it equals 3
	
	public Board(int surfaceWidth, int winningLength)
	{		
		surface = new Values [surfaceWidth][surfaceWidth]; // surfaceWidth = surface.length
		WINNNING_LENGTH = winningLength;
		resetBoard();
	}
	
	 //Set or reset the board back to initial values (Values.EMPTY)
	public void resetBoard()
	{
		for(int row = 0; row < surface.length; row++)
		{
			for(int column = 0; column < surface[row].length; column++)
			{
				surface[row][column] = initialValue;
			}
		}		
		// NEVER initialize array with enhanced for!!!
	}
       // Sends a copy of the original array so that the internal representation 
	   // of a Board object cannot be modified due to this method	
	public Values[][] getBoard()
	{
		Values[][] copyOfSurface = new Values[surface.length][surface.length];
		
		for(int i=0; i< surface.length; i++)
		{
			  for(int j=0; j < surface[i].length; j++)
				  copyOfSurface[i][j]= surface[i][j];
		}
		
		return copyOfSurface; 
	}
	
	// Returns the number of all squares in the board
	public int getNumberOfAllSquares()
	{
		return (int)Math.pow(surface.length, 2);
	}
	
	public int getWinningLength()
	{
		return WINNNING_LENGTH;
	}
	
	// Checks if a given square is empty (i.e. without X or O)
	// Works for boards larger than a 3 by 3 board (but I haven't tested it yet)
	public boolean isSquareEmpty(int squareNumber) 
	{
		boolean empty = false;
		int counter = 1;
		
		for(int row = 0; row < surface.length; row++)
		{
			for(int column = 0; column < surface[row].length; column++)
			{
				if(counter == squareNumber)
				{
					if (surface[row][column] == Values.EMPTY)
					{
						empty = true;												
					}
					else
					{
						empty = false;
					}						
					
					// statments that enable to quit the two for loops;
					row = surface.length;
					break;
				}
				
				counter++;
			}
		}
		
		return empty;		
	}
	
	// Puts O or X in a given square
	// Works for boards larger than a 3 by 3 board (but I haven't tested it yet)
	public void setXorYinSquare(int squareNumber, boolean xTurn)   
	{
		Values squareValue;
		
		//decide which value to put in the square
		if(xTurn == true)
			squareValue = Values.X;
		else
			squareValue = Values.O;
		
		
		int counter = 1;
		
		for(int row = 0; row < surface.length; row++)
		{
			for(int column = 0; column < surface[row].length; column++)
			{
				if(counter == squareNumber)
				{
					surface[row][column] = squareValue;
					// statements that enable to quit the two for loops;
					row = surface.length;
					break;
				}
				
				counter++;
			}
		}
	}
	
	// Checks if there are 3 X's or O's in one of the board's rows
	// Works for boards larger than a 3 by 3 board (but I haven't tested it yet)
	public boolean hasThreeTheSameMarksInRow()
	{
		boolean threeInRow = false;
		
		for(int row = 0; row < surface.length; row++)
		{
			int oCounter = 0;
			int xCounter = 0;
			
			for(int column = 0; column < surface[row].length; column++)
			{
				if (surface[row][column] == Values.O)
					oCounter++;
				else
				{
					if (surface[row][column] == Values.X)
						xCounter++; 
				}
			}
			
			if(oCounter == WINNNING_LENGTH || xCounter == WINNNING_LENGTH)
			{
				//System.out.println("We have a winner!");
				threeInRow = true;
				break;
			}			
		}
		
		return threeInRow;
	}
	
	// Checks if there are 3 X's or O's in one of the board's columns
	// Works for boards larger than a 3 by 3 board (but I haven't tested it yet)
	public boolean hasThreeTheSameMarksInColumn()
	{
		boolean threeInColumn = false;
		
		for(int column = 0; column < surface.length; column++)
		{
			int oCounter = 0;
			int xCounter = 0;
			
			for(int row = 0; row < surface.length; row++)
			{
				if (surface[row][column] == Values.O)
					oCounter++;
				else
				{
					if (surface[row][column] == Values.X)
						xCounter++; 
				}
			}
			
			if(oCounter == WINNNING_LENGTH || xCounter == WINNNING_LENGTH)
			{
				//System.out.println("We have a winner!");
				threeInColumn = true;
				break;
			}			
		}
		
		return threeInColumn;
	}
	
	// Checks if there are 3 X's or O's in one of the board's diagonals
	// Works for boards larger than a 3 by 3 board (but I haven't tested it yet)	
	public boolean hasThreeTheSameMarksDiagonally()
	{		
		boolean threeDiagonally = false;
		
		int oCounter = 0;
		int xCounter = 0;
		
		// check one diagonal
		for(int row = 0; row < surface.length; row++)
		{			
			for(int column = row; column <= row; column++)
			{
				if (surface[row][column] == Values.O)
					oCounter++;
				else
				{
					if (surface[row][column] == Values.X)
						xCounter++; 
				}
			}
			
			if(oCounter == WINNNING_LENGTH || xCounter == WINNNING_LENGTH)
			{
				//System.out.println("We have a winner 1st diagonally!");
				threeDiagonally = true;
			}			
		}
		
		//check the other diagonal
		if(threeDiagonally == false)
		{
			oCounter = 0;
			xCounter = 0;
			
			for(int row = 0; row < surface.length; row++)
			{			
				for(int column = surface[row].length - 1 - row; column >= surface[row].length - 1 - row; column--)
				{
					if (surface[row][column] == Values.O)
						oCounter++;
					else
					{
						if (surface[row][column] == Values.X)
							xCounter++; 
					}
				}
				
				if(oCounter == WINNNING_LENGTH || xCounter == WINNNING_LENGTH)
				{
					//System.out.println("We have a winner 2nd diagonally!");
					threeDiagonally = true;
				}			
			}
		}
		
		return threeDiagonally;
	}
	
	public boolean isAtLeastOneEmptySquare() 
	{
		boolean atLeastOneEmptySquare = false;
				
		for(int row = 0; row < surface.length; row++)
		{
			for(int column = 0; column < surface[row].length; column++)
			{				
					if (surface[row][column] == Values.EMPTY)
					{
						atLeastOneEmptySquare = true;	
						//System.out.println("there is at least 1 empty square!");
						// statments that enable to quit the two for loops;
						row = surface.length;
						break;
					}
			}
		}
		return atLeastOneEmptySquare;
	}
	/*public void showOriginalBoard()
	{		
		System.out.println("Welcome to showOriginalBoard()");
		System.out.println("surface in showOriginalBoard(): " + surface.hashCode() + "\n");
		
		for(Values[] row : surface)
		{
			for(Values element : row)
			{
				System.out.println(element.toString());
			}		
		}
	}*/
}

