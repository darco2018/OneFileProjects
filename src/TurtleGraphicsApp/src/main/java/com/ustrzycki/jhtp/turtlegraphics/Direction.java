package com.ustrzycki.jhtp.turtlegraphics;

public enum Direction {
	
	//declare constants of enum type
	NORTH("North", 0), 	
	EAST("East", 1), 
	SOUTH("South", 2), 
	WEST("West", 3);
	
	//instance fields
	private final String directionName;
	private final int directionNumber;
	private Direction currentDirection;
	
	Direction(String directionName, int directionNumber)
	{
		this.directionName = directionName;
		this.directionNumber = directionNumber;		
	}	

	/**
	 * @return the directionName
	 */
	public String getDirectionName() {
		return directionName;
	}

	/**
	 * @return the directionNumber
	 */
	public int getDirectionNumber() {
		return directionNumber;
	}
	
	
	/**
	 * @param direction which is to be changed into the next one while moving clockwise
	 * @return direction the new direction to the right of the old direction (clockwise)
	 */
	public static Direction rotateDirectionsClockwise(Direction direction)
	{
		Direction[] directions = Direction.values();
		
		int newDirectionNumber = direction.getDirectionNumber() + 1;
		
		switch (newDirectionNumber)
		{
			case 0: 
				direction = directions[0]; // return North 
				break;
			case 1: 
				direction = directions[1]; // return East 
				break;
			case 2: 
				direction = directions[2]; // return South 
				break;
			case 3: 
				direction = directions[3]; // return West
				break;
			case 4: 
				direction = directions[0]; // return North
				break;
		}
		
		return direction;
	}
	
	public static Direction rotateDirectionsAntiClockwise(Direction direction)
	{
		Direction[] directions = Direction.values();
		
		int newDirectionNumber = direction.getDirectionNumber() - 1;
		
		switch (newDirectionNumber)
		{
			case 0: 
				direction = directions[0]; // return North 
				break;
			case 1: 
				direction = directions[1]; // return East 
				break;
			case 2: 
				direction = directions[2]; // return South 
				break;
			case 3: 
				direction = directions[3]; // return West
				break;
			case -1: 
				direction = directions[3]; // return West
				break;
		}
		
		return direction;
	}

}
