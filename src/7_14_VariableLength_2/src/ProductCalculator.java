// improvement to make: Don't let it display "The product of these numbers is " + product"
// if uers entered only 1 number

import java.util.ArrayList;
import java.util.Scanner;

public class ProductCalculator 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> intList = new ArrayList<>();
		Integer[] copy = new Integer[1];
		LoopForInput inputLoop = new LoopForInput();
		
		intList = inputLoop.getInputIntCollection();
		
		if (!(intList.isEmpty()))
		{
			int product = calculateProduct(intList.toArray(copy));
			System.out.println("The product of these numbers is " + product);
		}	
		else
		{
			System.out.println("No numbers have been entered. You've decuded to quit the program." );
		}
	}
	
	public static int calculateProduct (Integer... numbers) 
	{
		int total = 1;
		
		for (Integer element : numbers) // numbers is treated like an array
			total *= element;
		
		return total;
	}
}

// Reads input from Scanner and validates input. If input is not an integer or Q/q for quit
// it displays an error message. Keeps looping until an integer or or Q/q for quit is entered
// Returns an ArrayList<Integer> of input integers
class LoopForInput
{
	private enum Input {CONTINUE, DISCONTINUE};
	Scanner keyboard = new Scanner(System.in);
	Input userInput = Input.CONTINUE;
	
	//Returns an array of input integers
	ArrayList<Integer> getInputIntCollection()
	{
		ArrayList<Integer> aList = new ArrayList<>();
		
		do
		{
			System.out.print("Enter an integer or 'q' to quit: " );
			String input;
			
			if (keyboard.hasNextInt())
			{
				int number = Integer.parseInt(keyboard.next());
				aList.add(number);
			}
			else
			{
				try
				{					
					input = keyboard.next();					
					
					if (input.equalsIgnoreCase("q"))
						userInput = Input.DISCONTINUE;
					else
						throw new IllegalArgumentException("You didn't enter 'q' or an integer. Try again!");
				}
				catch (IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
			}
		} while (userInput == Input.CONTINUE);
		
		return aList;
	}
	
	
	// return a boolean collection
	ArrayList<Boolean> getInputBooleanCollection()
	{
		ArrayList<Boolean> aList = new ArrayList<>();
		
		do
		{
			System.out.print("Enter an integer or 'q' to quit: " );
			String input;
			
			if (keyboard.hasNextInt())
			{
				boolean value = Boolean.parseBoolean(keyboard.next());
				aList.add(value);
			}
			else
			{
				try
				{					
					input = keyboard.next();					
					
					if (input.equalsIgnoreCase("q"))
						userInput = Input.DISCONTINUE;
					else
						throw new IllegalArgumentException("You didn't enter 'q' or an integer. Try again!");
				}
				catch (IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
			}
		} while (userInput == Input.CONTINUE);
		
		return aList;
	}
}
