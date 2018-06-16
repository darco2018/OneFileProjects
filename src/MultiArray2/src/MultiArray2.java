
public class MultiArray2 {

	public static void main(String[] args) {

		int[][] myArray = {{1, 2},{7, 8, 9, 5},{4, 5, 6}};
		
		for (int[] row : myArray)
		{
			System.out.printf("%s", "Row: ");
		
			for (int element : row)
			{
				System.out.printf("%5d  ", element);
			}
		
			System.out.println();
		}
		
		// set all elements to 0
		for (int row = 0; row < myArray.length; row++)
		{
			for (int column = 0; column < myArray[row].length; column++)
				myArray[row][column] = 0;
		}
			
		System.out.println();
		
		for (int[] row : myArray)
		{
			System.out.printf("%s", "Row: ");
		
			for (int element : row)
			{
				System.out.printf("%5d  ", element);
			}
		
			System.out.println();
		}

	}

}
