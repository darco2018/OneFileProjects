import java.util.Scanner;


public class RoundingNumbers_6_10 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a floating-point number or type the end-of-file indicator to terminate input.\n(On Windows type <Ctrl> z then press Enter.):  ");
		
		while (keyboard.hasNext())
		{
		double number = keyboard.nextDouble();
		
		System.out.println("The original number is " + number);
		System.out.println("The number after rounding to the nearest integer " + roundToInteger(number));
		System.out.println("The number after rounding to the tenths position " + roundToTenths(number));
		System.out.println("The number after rounding to the hundredths position " + roundToHundredths(number));
		System.out.println("The number after rounding to the thousandths position " + roundToThousandths(number));
		System.out.print("\nEnter a floating-point number: ");
		}
		
		System.out.print("\nNo number has been entered. Restart the programme.");
		keyboard.close();
	}
	
	public static double roundToInteger(double x)
    {
        return Math.floor(x + 0.5);
    }
	
	public static double roundToTenths(double number)
	{
		return Math.floor(number * 10 + 0.5) / 10.0;
	}
	
	public static double roundToHundredths(double number)
	{
		return Math.floor(number * 100 + 0.5) / 100.0;
	}
	
	public static double roundToThousandths(double number)
	{
		return Math.floor(number * 1000 + 0.5) / 1000.0;
	}
	

}
