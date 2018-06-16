package com.ustrzycki.jhtp.turtlegraphics;

import java.awt.Point;

public class Surface {

	private int[][] floor;  // the surface (on which the turtle moves) represented by the indexes of the array
	private Point location; // turtle's/pen's location

	private final static int EMPTY_SPACE = 0;
	private final static int TURTLE_WAY = 1;
	private final static int TURTLE = 2;

	public Surface(int side)
	{
		if(side >= 0)
			this.floor = new int[side][side];
		else 
			this.floor = new int[20][20]; // 20 by 20 spaces - the default size of the floor 
		// suggested by the instruction to this exercise 
		// Initial value of each floor[][] element is the default 0 (EMPTY_SPACE)	}
		location = new Point(0,0);		
	}

	//updates the turtle's location 
	public void translateLocation(Point updatedLocation)
	{
		location.x = updatedLocation.x; 
		location.y = updatedLocation.y; 
	}

	/**
	 * Draws the line on the surface (or draws nothing if the updated location is the same as the previous location
	 * (updatedRow == previousRow or updatedColumn == previousColumn)
	 * @param updatedLocation the location where the pen should stop drawing (last square to draw)
	 */
	public void drawLine(Point updatedLocation)
	{
		int previousColumn = location.x;
		int previousRow = location.y;

		int updatedColumn = updatedLocation.x;
		int updatedRow = updatedLocation.y;

		if( updatedColumn >  previousColumn )  /// drawing to the EAST
		{    
			for( int space = previousColumn; 
					space <= updatedColumn &&  space < floor[previousRow].length; space++ )
			{
				floor[previousRow][space] = TURTLE_WAY;
			}
		}
		else
		{
			if( updatedColumn <  previousColumn )  /// drawing to the WEST
			{
				for( int space = previousColumn; 
						space >= updatedColumn &&  space >= 0; space-- )
				{
					floor[previousRow][space] = TURTLE_WAY;
				}
			}
			else
			{
				if( updatedRow >  previousRow )  /// drawing to the SOUTH
				{
					for( int space = previousRow; 
							space <= updatedRow &&  space < floor.length; space++ )
					{
						floor[space][previousColumn] = TURTLE_WAY;
					}
				}
				else 
				{
					if( updatedRow <  previousRow )  /// drawing to the SOUTH
					{
						for( int space = previousRow; 
								space >= updatedRow &&  space >= 0; space-- )
						{
							floor[space][previousColumn] = TURTLE_WAY;
						}
					}
				}
			}
		}
	}
	/**
	 * displays the surface, the turtle's moves so far, and the turtle's current position
	 */
	public void displayFloor()
	{
		try
		{
			floor[location.y][location.x] = TURTLE;
			
			for (int[] row : floor)
			{
				for(int element : row)
				{
					System.out.print(element);
				}

				System.out.println();
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Oops! The turtle stepped too far and fell into an abyss!");
		}
	}
}
