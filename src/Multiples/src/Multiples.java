import java.util.Scanner;

public class Multiples {
	
	private enum Input {UNFINISHED, FINISHED };

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int firstNumber = 0;
		int secondNumber = 0;
		Input flag = Input.UNFINISHED;
		
		while (flag == Input.UNFINISHED)
		{		
			System.out.print("Enter the first number or 0 to quit: ");
			firstNumber = keyboard.nextInt();
			
			if (firstNumber == 0)
			{
				flag = Input.FINISHED;
				break;
			}
			else
			{
				System.out.print("Enter the second number or 0 to quit: ");
				secondNumber = keyboard.nextInt();
				
				if (secondNumber == 0)
				{
					flag = Input.FINISHED;
					break;
				}				
				else
				{				
					if (isMultiple(firstNumber, secondNumber))
						System.out.printf("%d is a multiple of %d", firstNumber, secondNumber);
					else
						System.out.printf("%d is NOT a multiple of %d", firstNumber, secondNumber);
				}
			}
			
			System.out.println();
			System.out.println();
		
		} // end of while
		
		System.out.println();
		System.out.println("Run the programme again.");
	}
	
	public static boolean isMultiple(int firstNumber, int secondNumber)
	{
		boolean isMultiple;
		
		if ( (secondNumber != 0) && (firstNumber % secondNumber == 0))
			isMultiple = true;
		else
			isMultiple = false;
		
		return isMultiple;
		
	}

}
