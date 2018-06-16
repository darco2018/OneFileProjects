package com.ustrzycki.games;

public class TicTacToeEngine {

	private Values[][] board; // the 3x3 board
	private final Values initialValue = Values.EMPTY; // the value to which the board "squares" are initialized	
	private final static int WINNING_LENGTH = 3; 
	private final int boardWidth = 3;		
		
	public TicTacToeEngine() 
	{		
		board = new Values [boardWidth][boardWidth]; 		
		resetBoard();
	}
	
	// set or reset the board back to the initial value (Values.EMPTY) when a game is (re)started
	public void resetBoard()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				board[row][column] = initialValue;
			}
		}				
	}
	
    // send a copy of the original array 	
	public Values[][] getBoard()
	{
		Values[][] copyOfSurface = new Values[board.length][board.length];
		
		for(int i=0; i< board.length; i++)
		{
			  for(int j=0; j < board[i].length; j++)
				  copyOfSurface[i][j]= board[i][j];
		}
		
		return copyOfSurface; 
	}
	
	// return the number of all squares in the board
	public int getNumberOfAllSquares()
	{
		return (int)Math.pow(board.length, 2);
	}
	
	// put O/X in a given square
	// (works for boards larger than a 3 by 3 board)				
	private void setXorOinSquare(int squareNumber, boolean xTurn)   
	{
		Values squareValue;		
		
		if(xTurn == true)
			squareValue = Values.X;
		else
			squareValue = Values.O;		
		
		int counter = 1;
		
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				if(counter == squareNumber)
				{
					board[row][column] = squareValue;
					// two statements that enable to quit both for loops;
					row = board.length;
					break;
				}
				
				counter++;
			}
		}
	}
	
	// check if a given square is empty (i.e. without X or O)
	// (works for boards larger than a 3 by 3 board)
	public boolean isSquareEmpty(int squareNumber) 
	{
		boolean empty = false;
		int counter = 1;
		
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				if(counter == squareNumber)
				{
					if (board[row][column] == Values.EMPTY)
					{
						empty = true;												
					}
					else
					{
						empty = false;
					}						
					
					// two statements that enable to quit both for loops;
					row = board.length;
					break;
				}
				
				counter++;
			}
		}
		
		return empty;		
	}
	
	// check if there are 3 X's or O's in one of the board's rows
	// (works for boards larger than a 3 by 3 board)
	private boolean hasThreeTheSameMarksInRow()
	{
		boolean threeInRow = false;
		
		for(int row = 0; row < board.length; row++)
		{
			int oCounter = 0;
			int xCounter = 0;
			
			for(int column = 0; column < board[row].length; column++)
			{
				if (board[row][column] == Values.O)
					oCounter++;
				else
				{
					if (board[row][column] == Values.X)
						xCounter++; 
				}
			}
			
			if(oCounter == WINNING_LENGTH || xCounter == WINNING_LENGTH)
			{				
				threeInRow = true;
				break;
			}			
		}
		
		return threeInRow;
	}
	
	// check if there are 3 X's or O's in one of the board's columns
	// (works for boards larger than a 3 by 3 board)
	private boolean hasThreeTheSameMarksInColumn()
	{
		boolean threeInColumn = false;
		
		for(int column = 0; column < board.length; column++)
		{
			int oCounter = 0;
			int xCounter = 0;
			
			for(int row = 0; row < board.length; row++)
			{
				if (board[row][column] == Values.O)
					oCounter++;
				else
				{
					if (board[row][column] == Values.X)
						xCounter++; 
				}
			}
			
			if(oCounter == WINNING_LENGTH || xCounter == WINNING_LENGTH)
			{				
				threeInColumn = true;
				break;
			}			
		}
		
		return threeInColumn;
	}
	
	// check if there are 3 X's or O's in one of the board's diagonals
	// (works for boards larger than a 3 by 3 board)	
	private boolean hasThreeTheSameMarksDiagonally()
	{		
		boolean threeDiagonally = false;
		
		int oCounter = 0;
		int xCounter = 0;
		
		// check one diagonal
		for(int row = 0; row < board.length; row++)
		{			
			for(int column = row; column <= row; column++)
			{
				if (board[row][column] == Values.O)
					oCounter++;
				else
				{
					if (board[row][column] == Values.X)
						xCounter++; 
				}
			}
			
			if(oCounter == WINNING_LENGTH || xCounter == WINNING_LENGTH)
			{				
				threeDiagonally = true;
			}			
		}
		
		//check the other diagonal
		if(threeDiagonally == false)
		{
			oCounter = 0;
			xCounter = 0;
			
			for(int row = 0; row < board.length; row++)
			{			
				for(int column = board[row].length - 1 - row; column >= board[row].length - 1 - row; column--)
				{
					if (board[row][column] == Values.O)
						oCounter++;
					else
					{
						if (board[row][column] == Values.X)
							xCounter++; 
					}
				}
				
				if(oCounter == WINNING_LENGTH || xCounter == WINNING_LENGTH)
				{					
					threeDiagonally = true;
				}			
			}
		}
		
		return threeDiagonally;
	}
	
	private boolean isAtLeastOneEmptySquare() 
	{
		boolean atLeastOneEmptySquare = false;
				
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{				
					if (board[row][column] == Values.EMPTY)
					{
						atLeastOneEmptySquare = true;							
						// two statements that enable to quit both for loops;
						row = board.length;
						break;
					}
			}
		}
		return atLeastOneEmptySquare;
	}
	
	//check if the game is won
	public boolean isTheGameWon()
	{
		return ( hasThreeTheSameMarksInRow() || 
				 hasThreeTheSameMarksInColumn() || 
				 hasThreeTheSameMarksDiagonally() );
	}
	
	public boolean isTheGameDrawn()
	{
		boolean drawn = false;
		// if the game is NOT won, check .if there is at least 1 empty square.
		if(!isTheGameWon())
		{
			// if there are no empty squares left to fill, the game is drawn
			if(!isAtLeastOneEmptySquare())
			{				 
				drawn = true;
			}
		}	
		
		return drawn;
	}
	
	public boolean changePlayer(boolean xTurn)
	{
		return !xTurn;
	}		
	
	public void setMarkInSquare(int numberOfSquareToMark, boolean xTurn )
	{
		setXorOinSquare(numberOfSquareToMark, xTurn);
	}
	
	public String getWinningMessage(boolean xTurn)
	{		
		return (xTurn ? "X" : "O") + " wins!!!";
	}
	
	public String getDrawMessage()
	{
		return "It's a draw!!!";
	}
	
	public String getWhoseMoveMessage(boolean xTurn)
	{		
		return (xTurn ? "X's" : "O's ") + " move.";
	}		
}

