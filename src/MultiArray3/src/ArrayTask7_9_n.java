
public class ArrayTask7_9_n {

	public static void main(String[] args) {
		
		int[][] array = {{1,2,3}, {4,5,6}};
		
		// header for column numbers
			System.out.printf("     ");
		
			for (int column = 0; column < array[0].length; column++)
				System.out.printf("%8s%d ", "Column ", column);
			
			for (int row = 0; row < array.length; row++)
			{
				//header for row indices
				System.out.printf("%nRow %d:", row);
				
				// contents of array in tablular format
				for (int column = 0; column < array[row].length; column++)
				{
					System.out.printf("%8d  ",array[row][column]);					
				}
			}
	}

}
