package com.ustrzycki.jhtp.turtlegraphics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ustrzycki.jhtp.turtlegraphics.Turtle.MobilityStatus;
import com.ustrzycki.jhtp.turtlegraphics.Turtle.PenStatus;

public class TurtleGraphicsApp {
		
	private static Scanner sc = new Scanner(System.in);	
	// new scanner as there are problems 
	// when you use nextInt() and than nextLine() on the same Scanner
	private static Scanner nextLineSc = new Scanner(System.in);		
	
	private static Turtle turtle; 
	private static Surface surface; 

	public static void main(String[] args) 
	{
		turtle = new Turtle(0, 0);
		surface = new Surface(20);
		
		int userChoice = -1;
		
		do
		{
			System.out.printf("Press 1 to enter the commands manually."
								+ "%nPress 2 to read commands from a file.");
			
			String input = getInput();
			
			if (validateMenuChoice(input))
				userChoice = Integer.valueOf(input);
			
		} while(userChoice == -1 );
		
		switch(userChoice)
		{
			case 1:
				readFromConsole();
				break;
				
			case 2:
				readFromFile();		
				break;		
		}
	}
	
	private static boolean validateMenuChoice(String menuChoice)
	{		
		return menuChoice.matches("[1-2]{1}");
	}
	
	private static String getInput()
	{
		return sc.next();
	}
	
	private static void readFromConsole()
	{
		System.out.printf("Enter the numbers of commands without spaces. 1.Pen up 2.Pen down 3.Turn right"
				+ "%n4.Turn left 5.Get ready to move (follow by number of moves) 6.Display map"
				+ "%n9.End of data ");
		// the Scanner scans a string of numbers(commands)
		sc = new Scanner(nextLineSc.nextLine());
		
		scanAllNumbers();
	}
	
	private static void readFromFile() //throws FileNotFoundException
	{
		System.out.printf("Enter the name of a file (eg. name.txt)");
		
		FileReader file;
		
		try 
		{
			file = new FileReader(nextLineSc.nextLine());
			// the Scanner scans a file
			sc = new Scanner(file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("No such file. Restart the program and enter the name of the file correctly.");
		}
		
		scanAllNumbers();
	}
	
	private static void scanAllNumbers()
	{
		while (sc.hasNextInt()) 
		{
			distributeCommands(Integer.valueOf(getInput()));
		}		
	}
	
	//Distributes variable length commands to the Turtle or Surface or terminates program
	private static void distributeCommands(int... commands)
	{
		for(int command : commands)
		{
			if ((command == Commands.DISPLAY_MAP || command == Commands.END_OF_DATA)
					&& (turtle.getMobilityStatus() == MobilityStatus.NOT_READY_TO_MOVE_FORWARD))
			{
				switch(command)
				{
					case Commands.DISPLAY_MAP:
						surface.displayFloor();
						break;
					
					case Commands.END_OF_DATA:
						System.exit(0);
						break;		
					
					default: 
						System.out.println("Unknown command: " + command);
				}
			}	
			else
			{
				// lacks validation whether the command is not a movement command that 
				// will send the turtle out of the bounds of the floor
				turtle.processSingleCommand(command);
				
				if(turtle.getPenStatus() == PenStatus.DOWN)			
					surface.drawLine(turtle.getCurrentLocation());
				
				surface.translateLocation(turtle.getCurrentLocation());
			}		
		}
	}

}
