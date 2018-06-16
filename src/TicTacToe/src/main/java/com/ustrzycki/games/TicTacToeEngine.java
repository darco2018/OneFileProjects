package com.ustrzycki.games;

/**
* The TicTacToeEngine class implements the logic of a tic tac toe game on a 3 by 3 board.
* It should be used with other classes which will display the game on a console or GUI.
* 
* <p>The TicTacToeEngine class includes methods placing X or O in a square, checking if a square is empty, checking if a game is won,
* returning useful string messages and others. Some methods have been developed to work with boards larger than a 3 by 3 board.</p>
* 
* @since   2015-09-24
* @version 1.0
* @author Dariusz Ustrzycki
*/
public class TicTacToeEngine {

	private final int boardWidth = 3;
	private Values[][] board = new Values [boardWidth][boardWidth]; // the 3x3 board
	private final Values initialValue = Values.EMPTY; // the value to which the board "squares" are initialized	
	private final static int WINNING_LENGTH = 3; 
	private Values player; // Values.X or Values.O
					
	public TicTacToeEngine() 
	{				  		
		resetBoard();
	}
	
	/**
	 * (Re)sets the board cells to the initial values when a game is (re)started
	 */
	public void resetBoard()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				board[row][column] = initialValue;
			}
		}	
		
		setPlayer(Values.X);
	}
	
	/**
	 * @return Returns the player whose turn is now
	 */
	private Values getPlayer()
	{
		return player;
	}
	
	/**
	 * @param player whose turn is to be set now
	 */
	private void setPlayer(Values player)
	{
		this.player = player;
	}
	
     	
	/**
	 * Returns a copy of the board
	 * @return a 2D array with a copy of the board
	 */
	public Values[][] getBoard()
	{
		// (System.arraycopy method makes only a shallow copy)
		Values[][] copyOfBoard = new Values[board.length][board.length];
		
		for(int i=0; i< board.length; i++)
		{
			  for(int j=0; j < board[i].length; j++)
				  copyOfBoard[i][j]= board[i][j];
		}
		
		return copyOfBoard; 
	}
	
	
	/**
	 * Returns the number of all squares in the board
	 * @return the number of all squares in the board
	 */
	public int getNumberOfAllSquares()
	{
		return (int)Math.pow(board.length, 2);
	}
	
			
	/**
	 * Places O or X in a given square. 
	 * 
	 * The method works also for boards larger than a 3 by 3 board.
	 * @param squareNumber the number of the square where X or O should be placed
	 */
	public void setXorOinSquare(int squareNumber)   
	{
		if (squareNumber <= 0 || squareNumber > getNumberOfAllSquares())
			throw new IllegalArgumentException("The number of the square must be 1-9");	
		
		int counter = 1;
		
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				if(counter == squareNumber)
				{
					board[row][column] = (getPlayer() == Values.X) ? Values.X : Values.O;  
					return;
				}
				
				counter++;
			}
		}
	}
	
	// 
	// 
	/**
	 * Checks if a given square is empty (i.e. without X or O)
	 * 
	 * The method also works for boards larger than a 3 by 3 board.
	 * 
	 * @param squareNumber the number of the square to check
	 * @return returns true if the given square is not occupied by X or O
	 */
	public boolean isSquareEmpty(int squareNumber) 
	{
		if (squareNumber <= 0 || squareNumber > getNumberOfAllSquares())
			throw new IllegalArgumentException("The number of the square must be 1-9");
				
		int counter = 1;
		
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{
				if(counter == squareNumber)
				{
					if (board[row][column] == Values.EMPTY)
					{
						return true;												
					}
					else
					{
						return false;
					}	
				}				
				
				counter++;
			}
		}
		
		return false;		
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
		for(int row = 0; row < board.length; row++)
		{
			for(int column = 0; column < board[row].length; column++)
			{				
					if (board[row][column] == Values.EMPTY)
					{
						return true;
					}
			}
		}
		
		return false;
	}
		
	/**
	 * Checks if the game is won.
	 * 
	 * @return true if the game is won, false otherwise
	 */
	public boolean isTheGameWon()
	{
		return ( hasThreeTheSameMarksInRow() || 
				 hasThreeTheSameMarksInColumn() || 
				 hasThreeTheSameMarksDiagonally() );
	}
	
	public boolean isTheGameDrawn()
	{		
		if(!isTheGameWon())
		{
			// if there are no empty squares left to fill, the game is drawn
			if(!isAtLeastOneEmptySquare())
			{				 
				return true;
			}
		}			
		
		return false;
	}
	
	/**
	 * Changes the player from X to O and from O to X
	 */
	public void changePlayer()
	{
		if (getPlayer() == Values.X)
			setPlayer(Values.O);
		else
			setPlayer(Values.X);
	}		
	
	/**
	 * Returns a string with a message which player has won
	 * @return a string with a message which player has won
	 */
	public String getWinningMessage()
	{		
		return (getPlayer() == Values.X ? "X" : "O") + " wins!!!";
	}
	
	/**
	 * Returns a string with a message that the game has ended in a draw
	 * @return a string with a message that the game has ended in a draw
	 */
	public String getDrawMessage()
	{
		return "It's a draw!!!";
	}
	
	/**
	 * Returns a string with a message whose move it is now
	 * @return a string with a message whose move it is now
	 */
	public String getWhoseMoveMessage()
	{		
		return (getPlayer() == Values.X ? "X's" : "O's ") + " move.";
	}		
}

