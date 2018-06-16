import java.util.Random;


public class DiceRolling {
	
	final static Random randomNumbers = new Random();

	public static void main(String[] args) {

		int[] frequency = new int[13];
		
		for (int c = 1; c <= 6000000; c++)
			++frequency[rollDice() + rollDice()];
		
		for ( int counter = 2; counter < frequency.length; counter++)
		{
			System.out.printf("Sum %2d: %,9d%n",counter, frequency[counter] );
		}
	}
	
	private static int rollDice()
	{
		return 1 + randomNumbers.nextInt(6);
	}


}
