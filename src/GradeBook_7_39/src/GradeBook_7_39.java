import java.util.Arrays;


public class GradeBook_7_39 
{
	private String courseName;
	private int numberOfStudents;
	private int numberOfExams;
	final private int noGradeIndicator = -1; // indicates that student got no grade on a particular exam
	                                         // eg he was absent
	private int[][] grades;
	
	// first constructor with a preinitialized 2D array
	public GradeBook_7_39(String courseName, int[][] grades)
	{
		this.courseName = courseName;
		this.grades = grades;
	}
	
	// second constructor with data to build a 2D array
	public GradeBook_7_39(String courseName, int numberOfStudents, int numberOfExams)
	{
		this.courseName = courseName;
		grades = new int[numberOfStudents][numberOfExams];
		
		// set each element in grades to -1 to indicate no grade has been entered for that student on this exam
		
		for (int row = 0; row < grades.length; row++)
			Arrays.fill(grades[row], noGradeIndicator ); 
		
		
		/* manual method of filling an array with -1
		for (int row = 0; row < grades.length; row++)
		{
			for (int column = 0; column < grades[row].length; column++)
			{
				grades[row][column] = noGradeIndicator;
			}
		}
		*/
		
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public int getNumberOfStudents() 
	{
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) 
	{
		this.numberOfStudents = numberOfStudents;
	}

	public int getNumberOfExams() 
	{
		return numberOfExams;
	}

	public void setNumberOfExams(int numberOfExams) 
	{
		this.numberOfExams = numberOfExams;
	}
	
	// sets one grade for a particular student ona particular exam
	public void setGrade(int student, int exam, int singleGrade)
	{
		grades[student][exam] = singleGrade;
	}
	
	public int getGrade(int student, int exam)
	{
		return grades[student][exam];
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

	public double getAverage(int[] studentsGrades)
	{
		double total = 0.0;
		
		for (int element : studentsGrades)
		{
				total += element;
		}
		
		return total / studentsGrades.length;
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

	public void outputBarChart()
	{
		int[] frequency = new int[11];
		
		for (int[] row : grades)
		{
			for (int element : row)
			{
				if (element != noGradeIndicator)
					++frequency[element / 10];
			}
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

	public void processGrades()
	{
		outputGrades();
		
		System.out.println();
		System.out.printf("Lowest grade in the gradebook is %d", getMinimum());
		System.out.println();
		System.out.printf("Highest grade in the gradebook is %d", getMaximum());
		
		outputBarChart();
		
		
	}

}
