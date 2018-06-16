
public class GradeBook 
{
	
	private String courseName;
	private int[][] grades;
	
	public GradeBook(String courseName, int[][] grades)
	{
		this.courseName = courseName;
		this.grades = grades;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public void processGrades()
	{
		outputGrades();
		
		System.out.println();
		System.out.printf("Lowest grade in the gradebook is %d", getMinimum());
		System.out.println();
		System.out.printf("Highest grade in the gradebook is %d", getMaximum());
		
		outputBarChart();
		
		
	}
	
	public int getMinimum()
	{
		int mimimumValue = grades[0][0];
		
		for (int[] row : grades)
		{
			for(int element : row)
			{
				if (element < mimimumValue)
					mimimumValue = element;
			}
		}
		
		return mimimumValue;
	}
	
	public int getMaximum()
	{
		int maximumValue = grades[0][0];
		
		for (int[] row : grades)
		{
			for(int element : row)
			{
				if (element > maximumValue)
					maximumValue = element;
			}
		}
		
		return maximumValue;
	}
	
	public void outputGrades()
	{
		// display the header
		System.out.println("The grades are:");
		System.out.println();
		
		// heading with the number of tests
		System.out.printf("%10s", ""); // align column heads
		
		for (int counter = 0; counter < grades[0].length; counter++)
		{
				System.out.printf("  Test %d", counter + 1 );
		}
		
		System.out.printf("  Average");
		
		//output grades in a tabular format
		System.out.println();
		
		for (int row = 0; row < grades.length; row++)
		{
			System.out.printf("Student %2d", row + 1 );
			
			for (int column = 0; column < grades[row].length; column++)
			{
				System.out.printf("%8d", grades[row][column]);
			}
			
			// display average
			System.out.printf("%9.2f", getAverage(grades[row]));
			
			System.out.println();
				
		}
		
		//display the minimum and maximum value
		
	}
	
	public double getAverage(int[] studentsGrades)
	{
		double total = 0.0;
		
		for (int element : studentsGrades)
		{
				total += element;
		}
		
		return total / studentsGrades.length;
	}
	
	public void outputBarChart()
	{
		int[] frequency = new int[11];
		
		for (int[] row : grades)
		{
			for (int element : row)
				++frequency[element / 10];
		}
		
		System.out.printf("%n%nOverall grade distribution:%n");
		
		for (int counter = 0; counter < frequency.length; counter++)
		{
			if (counter == 10)
				System.out.printf("  100: ");
			else
				System.out.printf("%02d-%02d: ", counter * 10, counter * 10 + 9);
			
			for (int stars = 0; stars < frequency[counter]; stars++)
				System.out.printf("*");
				
				System.out.println();
		}
	}

}
