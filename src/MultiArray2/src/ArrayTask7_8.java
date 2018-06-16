
public class ArrayTask7_8 {

	public static void main(String[] args) {
		
		double[] w = new double[99];
		
		double increment = 0.3;
		
		
		for (int c = 1; c < w.length; c++)
		{
			w[c] += w[c-1]+ increment;
		}
		
		w[10] = 30.6;
		w[80] = 39.2;
		w[10] = 30.6;
		w[0] = 0.5;
		w[29] = 0.2;
		w[89] = 0.1;
		
		System.out.print("This is array w: ");
		
		for (double element : w)
			System.out.printf("%.1f  ", element);
		
		System.out.println();
		System.out.printf("The maximum is %.1f", getMaximum(w));
		
		System.out.println();
		System.out.printf("The minimum is %.1f", getMinimum(w));
	}
	
	public static double getMaximum(double[] array)
	{
		double max = array[0];
		
		for (double element : array)
		{
			if (element > max )
				max = element;			
		}
		
		return max;
	}
	
	public static double getMinimum(double[] array)
	{
		double min = array[0];
		
		for (double element : array)
		{
			if (element < min )
				min = element;			
		}
		
		return min;
	}
}
