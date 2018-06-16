
public class SalesComission_7_10 {

	public static void main(String[] args) {
		
		int[] grossSales = {2468, 2000, 2543, 500, 1200, 
				           3000, 3498, 3000, 3000, 4000, 
				           9000, 2345, 14340, 4568, 6756};
		
		int[] frequency = new int[13];
		
			for (int counter = 0; counter < grossSales.length; counter++)
			{
				int comission = (int) ((grossSales[counter]*10) / 100);
				
				if (comission > 1000)
					comission = 1000; // prevent the frequency index in the next statement to become more than 10,
								      // all commissions over 1000 will increment frequency[10] 		
				else
					if (comission < 200)
						comission = 100; // all commissions in the range 0-200 will increment frequency[1] in the next statement
				
				try
				{
					++frequency[comission / 100 ];  // frequency should never be out of bounds because all indexes below 2 and over 10 
													// are handled by the above if statement
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println(e);
					System.out.printf("grossSales[%d]:%d", counter, grossSales[counter] );
				}
			}
			
			System.out.printf("How many salespeople earned saleries in each of the following ranges:%n%n");
		
		for (int counter = 1; counter <=10; counter++)
		{
			if (counter == 10)
				System.out.printf("over $%d:", (counter * 100));
			else
				System.out.printf("  $%d-%d:", (counter * 100), (counter * 100) + 99);
			
			System.out.printf(" %d%n", frequency[counter]);
		}
	}

}
