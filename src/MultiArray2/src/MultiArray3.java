
public class MultiArray3 {

	public static void main(String[] args) {

		int[][] myArray = {{12, 24},{78, 81, 92, 26},{89, 82, 60}};
		
		for (int[] row : myArray)
		{
			System.out.printf("%s", "Row: ");
		
			for (int element : row)
			{
				System.out.printf("%5d  ", element);
			}
		
			System.out.println();
		}
		
		int[] frequency = new int[10];
		
		
		
		for (int[] row : myArray )
		{
			for (int element : row)
			{
				++frequency[element / 10];
			}
		}
		
		for (int element : frequency)
		{
				System.out.printf("%n%d", element);
		}
		
	}

}
