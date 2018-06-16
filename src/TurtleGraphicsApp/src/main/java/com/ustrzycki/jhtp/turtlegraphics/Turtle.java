package com.ustrzycki.jhtp.turtlegraphics;

import java.awt.Point;

public class Turtle {
	
	private Point currentLocation;  // the turtle's current location after each command
	private Direction turtleFace; // shows where the turtle's facing currently
		
	public enum PenStatus {UP, DOWN}; // pen down can draw
	private PenStatus pen;
		
	public enum MobilityStatus {READY_TO_MOVE_FORWARD, NOT_READY_TO_MOVE_FORWARD}; // pen down can draw
	private MobilityStatus readinessToMove;
	
	public Turtle(int x, int y)
	{
		if(x >= 0 && y >= 0)
			currentLocation = new Point(x, y); // the turtle starts at these coordinates
		else
			currentLocation = new Point(0, 0); // if a negative value was passed as an argument
		                                       // the turtle starts at the default position (0, 0)
		
		pen = PenStatus.UP; // the pen is not in a drawing position when a turtle is created
		readinessToMove = MobilityStatus.NOT_READY_TO_MOVE_FORWARD; // pen is not ready to draw in the next "move"
		turtleFace = Direction.EAST; // initially the turtle faces East
	}
	
	
	public Point getCurrentLocation() {
		return currentLocation;
	}
	
	public PenStatus getPenStatus() {
		return pen;
	}
	
	public MobilityStatus getMobilityStatus() {
		return readinessToMove;
	}
	
	/**
	 * transforms an input number into an appropriate command
	 * @param number the number of the command
	 */
	public void processSingleCommand(int number)
	{
		
		
		
		if(readinessToMove == MobilityStatus.READY_TO_MOVE_FORWARD) 
		{
			
			setNewCurrentPosition(number);
			disableReadinessToMoveForward();
		}
		else
		{			
			switch(number)
			{
				case Commands.PUT_PEN_UP:
					putPenUp(); // Puts the pen up
					break;
				case Commands.PUT_PEN_DOWN:
					putPenDown(); // Puts the pen down
					break;
				case Commands.TURN_RIGHT:
					turnRight();// Turn right
					break;
				case Commands.TURN_LEFT:
					turnLeft();// Turn left
					break;
				case Commands.READY_TO_MOVE:
					enableReadinessToMoveForward(); // Signal that the next command will be "Move forward X spaces" (X is the next number in the input )
					break;				
				default:
					System.out.println("The turtle does not know how to interpret this command: " + number 
							+ "Restart the program.");
			}			
		}
	}
	
	private void putPenUp()
	{
		pen = PenStatus.UP;
	}
	
	private void putPenDown()
	{
		pen = PenStatus.DOWN;
	}
	
	private void turnRight()
	{
		turtleFace = Direction.rotateDirectionsClockwise(turtleFace);
	}
	
	private void turnLeft()
	{
		turtleFace = Direction.rotateDirectionsAntiClockwise(turtleFace);
	}
	
	private void enableReadinessToMoveForward()
	{
		readinessToMove = MobilityStatus.READY_TO_MOVE_FORWARD;
	}
	
	private void disableReadinessToMoveForward()
	{
		readinessToMove = MobilityStatus.NOT_READY_TO_MOVE_FORWARD;
	}
	
	/**
	 * @param number the number of steps the turtle has made
	 */
	private void setNewCurrentPosition(int number)
	{
		switch(turtleFace)
		{
			case EAST:				
				currentLocation.translate(number, 0);
				break;
			case WEST:
				currentLocation.translate(-number, 0);
				break;
			case NORTH:
				currentLocation.translate( 0, -number);
				break;
			case SOUTH:
				currentLocation.translate(0, number);
				break;
		}
	}
}
