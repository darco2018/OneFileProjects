
public class PerfectNumbers {
	
	
	

	public static void main(String[] args) {

		int number;
				
		for (number = 0; number <= 10000; number++)
		{	
		if ( isPerfect(number))
		{
			System.out.println(number + " is a perfect number.");
			System.out.println();
		}
		//else
			//System.out.println("\t" + number + " is NOT a perfect number.");
		}
	}
	
	public static boolean isPerfect(int number)
	{
		int runnningTotal = 0;
		int divisor = number - 1;
		String divisorsOfPerfectNumber = "";
					
		for (; divisor >= 1 ; divisor--)
		{
			//System.out.println(divisor + " is a divisor before if");
			if (number % divisor == 0)
			{
				runnningTotal += divisor;
				//System.out.println(divisor + " is a divisor inside if so a real divisor of number " + number);
				divisorsOfPerfectNumber += divisor + "  ";
			}
		}
		
		//System.out.println( "This is the runing total: " + (runnningTotal));
		if (number == runnningTotal && number != 0)
		{
			System.out.println(divisorsOfPerfectNumber + " are divisors of number " + number + ". ");
			return true;
		}
		else
			return false;
			
	}

}
