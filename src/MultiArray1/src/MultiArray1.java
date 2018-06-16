
public class MultiArray1 
{
	public static void main(String[] args)
	{
		int[][] myArray = {{1, 2, 3},{7, 8, 9, 5},{4, 5, 6}};
	
		for (int[] row : myArray)
		{
			System.out.printf("%s", "Row: ");
		
			for (int element : row)
			{
				System.out.printf("%5d  ", element);
			}
		
			System.out.println();
		}
		
		
		int smallestNumber = myArray[0][0];
		
		for (int[] row : myArray)
		{
			for (int element : row)
			{
				if (element < smallestNumber)
					smallestNumber = element;
			}
			
		}
		
		System.out.println("The smallest number is " + smallestNumber);
		
		int largestNumber = myArray[0][0];
		
		for (int[] row : myArray)
		{
			for (int element : row)
			{
				if (element > largestNumber)
					largestNumber = element;
			}
			
		}
		
		System.out.println("The smallest number is " + largestNumber);
		
		int total = 0;
		int counter = 0;
		int numberOfValues = 0;
		
		for (int[] row : myArray)
		{
			for (int element : row)
			{
				total += element;
				counter++;
			}
			
			numberOfValues += row.length;
		}
		
		System.out.println("The total is " + total);
		
		System.out.printf("The average is %.2f%n", (double) total / counter);
		System.out.printf("The average is %.2f", (double) total / numberOfValues);
		
		
	}
}
