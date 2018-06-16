
public class SeparatingDigits {

	public static void main(String[] args) {
		
		//Inputs an integer and calls displayDigits() by passing the integer entered
		
		//java.util.Scanner keyboard = new Scanner(System.in);
		//System.out.println("Enter an integer between 1 and 99999");
		int a = 100;
		int b = 26;
		
		int integerPart = calculateIntegerPart(a, b);
		int remainderPart = calculateRemainderPart(a, b);
		
		System.out.printf("Number %d is divided by %d.%n", a, b);
		System.out.printf("The integer part is %d, the remainder part is %d.", integerPart, remainderPart);
		
		System.out.println();
	} // main end

	// Calculates the integer part of the quotient when integer a is divided by integer b
			public static int calculateIntegerPart(int a, int b)
			{
				int integerPart = a / b;
				
				return integerPart;
			}
			
			// Calculates the integer remainder when integer a is divided by integer b
			public static int calculateRemainderPart(int a, int b)
			{
				int remainderPart = a % b;
				
				return remainderPart;
				
			}
			
			// Displays a number as a sequence of digits, separating each pair of digits by two spaces
			public static void displayDigits()
			{
				
			}

}
