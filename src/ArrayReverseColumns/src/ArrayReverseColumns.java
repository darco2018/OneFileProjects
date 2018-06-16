
public class ArrayReverseColumns {

	public static void main(String[] args) {

		int [][] testedArray =  {
								{1, 2, 50, 3, 4, },
								{5, 6, 60, 7, 8, },
								{9, 10,70, 11, 12, }
								};
		
		for (int i = 0; i < testedArray.length; i++)
		{
			
			for(int j = 0; j < testedArray[0].length; j++)
			{
				System.out.printf("%2d  ", testedArray[i][j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < testedArray.length; i++)
		{
			
			for(int j = 0; j < (testedArray[i].length) / 2; j++)
			{
				System.out.println("value of i: " + i + " value of j: " + j);
				int temp = testedArray[i][testedArray[j].length - 1 - j];
				System.out.println(temp);
				testedArray[i][testedArray[j].length - 1 - j] =  testedArray[i][j];
								
				System.out.println(testedArray[i][testedArray[j].length - 1]);
				testedArray[i][j] = temp;
				
				System.out.println(testedArray[i][j]);
								
				System.out.print("Befor new iteration: " + testedArray[0][0] + 
						testedArray[0][1] + 
								testedArray[0][2] + 
										testedArray[0][3]);
				System.out.println();
				System.out.println("New iterition");
			}
			
			System.out.println();
			System.out.println("Let's move to the next row:");
		}
		
		
		
		System.out.println("And now the new array:");
		
		for (int i = 0; i < testedArray.length; i++)
		{
			
			for(int j = 0; j < testedArray[0].length; j++)
			{
				System.out.printf("%2d  ", testedArray[i][j]);
			}
			System.out.println();
		}
		

	}

}
