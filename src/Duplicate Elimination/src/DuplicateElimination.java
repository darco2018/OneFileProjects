import java.util.Scanner;
public class DuplicateElimination {

	public static void main(String[] args) {

		int[] notDuplicates = new int[5];
		Scanner keyboard = new Scanner(System.in);
		
		for (int counter = 0; counter <5; counter++)
		{
			System.out.print("Enter a number between 10 and 100: ");
			int number = keyboard.nextInt();
			boolean isDuplicate = false;
			
			// loop through all indexes of notDuplicates to check if number is a duplicate
			for (int c = 0; c < notDuplicates.length; c++)
			{
				if (number == notDuplicates[c]) 
				{
					isDuplicate = true; // if duplicate is found stop the for loop
					break;
				}				
			}
			
		// place number in notDuplicates in the first position not equal to the initial default value 0
			if (isDuplicate == false)
			{
				for (int c = 0; c < notDuplicates.length; c++)
				{
					if (notDuplicates[c] == 0)
					{	
						notDuplicates[c]= number;
						break;
					}
				}
			}
			
			System.out.print("Not duplicates: ");
			
			for ( int element : notDuplicates)
			{
				if ( element != 0)
					System.out.print(element + " ");
			}
				
			
			//System.out.printf("number: %d", number);
			//System.out.printf("%nnumber: %b", isDuplicate);
			
			
			
			System.out.println();
				
				
			
			
			
		}

	}

}
