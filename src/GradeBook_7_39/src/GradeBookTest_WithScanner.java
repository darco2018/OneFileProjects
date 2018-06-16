import java.util.Scanner;



public class GradeBookTest_WithScanner {
	
	private static int flag = 0;
	private static boolean loopRepeat = true;

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);		
		
		System.out.print("Enter the name of the course: ");
		String nameOfCourse = keyboard.nextLine(); // don't use nextLine() AFTER using nextInt() with the same scanner
		
		System.out.print("Enter the number of students: ");
		int numberOfStudents = keyboard.nextInt();
				
		System.out.print("Enter the number of exams: ");
		int numberOfExams = keyboard.nextInt();
		
		GradeBook_7_39 anotherGradeBook = new GradeBook_7_39(nameOfCourse, numberOfStudents, numberOfExams);
		
		// loop to enter grades one at a time
		while(flag != -1)
		{
			System.out.println();
			System.out.println("Press 1 to ENTER A GRADE or -1 TO QUIT: ");
			int input = keyboard.nextInt();
			
			if (input == -1)
				flag = -1;	
			
			// enter and validate the number of the student for whom grades are to be entered
			loopRepeat = true;
			int student = 0;		
			
			while (flag != -1 && loopRepeat)  
			{
				System.out.print("Enter the number of the STUDENT: ");
				input = keyboard.nextInt();
				
				if (validateInput(input, numberOfStudents, "student"))
					student = input - 1;
			}
			
			// enter and validate the number of the exam for whom grades are to be entered
			loopRepeat = true;
			int exam = 0;		
			
			while (flag != -1 && loopRepeat)
			{
				System.out.println();
				System.out.println("Student #: " + (student + 1));
				System.out.print("Enter the number of the EXAM: ");
				input = keyboard.nextInt();
				
				if (validateInput(input, numberOfExams, "exam"))
					exam = input - 1;
			}
			
			// enter and validate the grade 
			loopRepeat = true;
			int grade = -1; // must be -1 as "empty places" for grades are pre-initialized to this value 
			
			while (flag != -1 && loopRepeat)
			{
				System.out.println();
				System.out.println("Student #" + (student + 1));
				System.out.println("Exam #" + (exam + 1));
				System.out.print("Enter the GRADE: ");
				
				input = keyboard.nextInt();
				
				if (validateInput(input, 0, "grade")) //the 0 value makes no work in validateInput() when validating grade
					grade = input;
			}
			
			if (flag != -1)
			{
				System.out.println();
				System.out.println("Student #" + (student + 1));
				System.out.println("Exam #" + (exam + 1));
				System.out.println("Grade: " + grade);
				
				anotherGradeBook.setGrade(student, exam, grade);
			}
		}
		
		System.out.println();
		System.out.printf("Welcome to the grade book for %s", anotherGradeBook.getCourseName());
		System.out.println();
		anotherGradeBook.processGrades();
	}
	
	private static boolean validateInput(int input, int arrayLimit, String field)
	{
		boolean correctInput = false;
		
		if (input == -1)		
			flag = -1;	
		else 
		{
			switch (field)
			{
				case "grade":
					
					if (input < 0)
						errorMessage();
					else
					{
						loopRepeat = false;
						correctInput = true;				
					}
					break;
				
				case "student": case "exam" :
					
					if (input <= 0 || input > arrayLimit)
						errorMessage();	
					else
					{
						loopRepeat = false;
						correctInput = true;				
					}
					
					break;
					
				default:
					System.out.println("Wrong parameter in the switch.");
			}
		}
		
		return correctInput;
	}
	
	private static void errorMessage()
	{
		System.out.printf("%nThe number you entered is out of the valid range. Please try again.%n");
	}

}
