
public class SeparatingDigits_version2 {

	public static void main(String[] args) {
		
		//Inputs an integer and calls displayDigits() by passing the integer entered
		int number = 0;
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
					
		
		do
		{
			System.out.print("Enter an integer between 1 and 99999: ");
			number = keyboard.nextInt();
		
			if (number >= 1 && number <= 99999)		
				displayDigits(number);	
			else
				System.out.print("Try again. ");
		}
		while (!(number >= 1 && number <= 99999));
		
		keyboard.close();
		
	} // main end

			// Calculates the integer part of the quotient when integer a is divided by integer b
			public static int calculateIntegerPart(int a)
			{
				int integerPart = a / 10;				
				return integerPart;
			}
			
			// Calculates the integer remainder when integer a is divided by integer b
			public static int calculateRemainderPart(int a)
			{
				int remainderPart = a % 10;				
				return remainderPart;				
			}
			
			// Displays a number as a sequence of digits, separating each pair of digits by two spaces
			public static void displayDigits(int numberToSplit)
			{
				int number = numberToSplit;
				String numberAsString = "";
				int integerPart;
				int remainderPart;
				
				System.out.printf("Number to split: %d%n", numberToSplit);
								
				do
				{
					integerPart = calculateIntegerPart(number);
					remainderPart = calculateRemainderPart(number);
					numberAsString = remainderPart + "  " + numberAsString;
					number = integerPart;	
					
				} while (number >= 10);
				
				if (integerPart != 0)
					numberAsString = integerPart + "  " + numberAsString;								
				
				System.out.printf("The number after splitting represented as a String: %s", numberAsString);				
				System.out.println();		
				
			}
			
			

}
