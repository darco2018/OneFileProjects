
public class GradeBookTest_7_39 {

	public static void main(String[] args) 
	{

		int[][] gradesArray = {{87, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 81, 82},
                {83, 65, 85},
                {78, 87, 65},
                {85, 75, 83}, 
                {91, 94, 100},
                {76, 72, 84},
                {87, 93, 73}};
		
		GradeBook_7_39 myGradeBook = new GradeBook_7_39("Darek's Java", gradesArray);
		System.out.printf("Welcome to the grade book for %s", myGradeBook.getCourseName());
		
		System.out.println();
		System.out.println();
		
		myGradeBook.processGrades();
		
		System.out.println();
		System.out.println();
		
		GradeBook_7_39 dareksGradeBook = new GradeBook_7_39("Darek's Java 2", 4, 4);
		System.out.println();
		System.out.println();
		System.out.printf("Welcome to the grade book for %s5n", dareksGradeBook.getCourseName());
				
		dareksGradeBook.setGrade(2, 2, 70);
		System.out.println();
		dareksGradeBook.processGrades();
		

	}

}
