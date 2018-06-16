package com.ustrzycki.jhtp.TicTacToe;

public enum Values {
	
	EMPTY(0),
	X(1),
	O(2);
	
	
	private final int squareValue;
	
	Values(int squareValue)
	{
		this.squareValue = squareValue;
	}
	
	public int getSquareValue()
	{
		return squareValue;
	}
}
