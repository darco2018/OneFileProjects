
public class ArrayTask7_4 {

	public static void main(String[] args) {
		
		final int ARRAY_SIZE = 3;
		int[][] table = new int[ARRAY_SIZE][ARRAY_SIZE];
		
		for (int row = 0; row < table.length; row++)
		{
			for (int column = 0; column < table[row].length; column++)
				table[row][column]= row + column;
		}
		
		for (int[] row : table)
		{
			for (int element : row)
				System.out.print(element + " ");
			
			System.out.println();
		}
		
		int[] myArray = new int[100];
		

	}

}
