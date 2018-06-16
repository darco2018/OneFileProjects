import java.util.Scanner;


public class Exponentiation_6_14 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int base;
		int exponent;		
		
		System.out.printf("Enter the base: ");
		base = keyboard.nextInt();
				
		System.out.printf("Enter the exponent: ");
		exponent = keyboard.nextInt();
		
		System.out.printf("%d to the power of %d is %d.%n", base, exponent, integerPower(base, exponent) );
	}
	
	static int integerPower(int base, int exponent)
	{
		int result = base;
		
		if (exponent == 1)
			result = base;
		else
		{
			for (int counter = 1; counter <= (exponent - 1); counter++)
			{
				result *= base;
			}
		}
		
		return result;
	}

}
