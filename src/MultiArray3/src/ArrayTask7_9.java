import java.util.Scanner;

public class ArrayTask7_9 {

	public static void main(String[] args) {

		int[][] t = new int[2][3];
		//t[1][0];  t[1][1];  t[1][2];
		//t[0][2]; t[1][2];
		//t[0][1] = 0;
		
		for (int row = 0; row < t.length; row++)
		{
			for (int column = 0; column < t[row].length; column++)
				t[row][column] = 0;
		}
		
		displayArray(t);
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int row = 0; row < t.length; row++)
		{
			for (int column = 0; column < t[row].length; column++)
			{
				System.out.print("Enter an integer: ");
				t[row][column] = keyboard.nextInt();
			}
		}
		
		displayArray(t);		
		System.out.println("The smallest value is " + getMinimum(t));
		
		System.out.printf("%d %d %d", t[0][0], t[0][1], t[0][2]);
		
		
		
		

	}
	
	public static void displayArray(int[][] array)
	{
		for (int[] row : array)
		{
			for (int element : row)
				System.out.print(element + "  ");
		}
		System.out.println();
	}
	
	public static int getMinimum(int[][] array)
	{
		int minimum = array[0][0];
		
		for (int[] row : array)
		{
			for (int element : row)
			{
				if ( element < minimum)
					minimum = element;
			}
		}	
			return minimum;
	}
	
	

}
