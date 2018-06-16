
public class ArrayTasks {

	public static void main(String[] args) {
		
		final int ARRAY_SIZE = 10;
		
		double[] array = new double [ARRAY_SIZE];
		
		// array[4];
		array[9] = 1.667;
		array[6] = 3.333;
		
		double total = 0;
		
		for (int x = 0; x < array.length; x++)
			total += array[x];
		
		System.out.printf("%.2f", total);
			
			
		
		
	}

}
