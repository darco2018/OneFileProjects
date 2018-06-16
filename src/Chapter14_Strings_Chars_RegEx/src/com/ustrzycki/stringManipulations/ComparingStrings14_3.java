package com.ustrzycki.stringManipulations;

import java.util.Scanner;

public class ComparingStrings14_3 {
	
	static Scanner sc = new Scanner(System.in);
	private static String s1 = "";
	private static String s2 = "";

	public static void main(String[] args) 
	{
		
		// menu
		boolean continueMenuLoop = true;
		
		do {			
			System.out.printf("Choose an option and press ENTER: %n" +
					"1 Compare if a string is equal, less than or greater than another%n" +
					"2 Compare portions of two strings%n" +
					"3 Display a sentence with its words reversed%n" +
					"Press any other key to quit the program%n");			
			String input =  sc.next();		
			
			switch(input)
			{
			case "1":
				getTwoStringInputs();
				System.out.print(StringOperations.compareTwoStrings(s1, s2));
				break;
			case "2":
				getTwoStringInputs();
				System.out.print(StringOperations.comparePortionsOfTwoStrings(s1, s2, getLengthAndOffset()));
				break;
			case "3":
				break;
			default:
				continueMenuLoop = false;
			}
			
			System.out.printf("%n%n");
					
		} while (continueMenuLoop);
	}	
		
	private static void getTwoStringInputs()
	{
		System.out.print("Enter a word: ");		
		s1 = sc.next();
		System.out.print("Enter another word: ");		
		s2 = sc.next();
	}
	
	private static int[] getLengthAndOffset()
	{
		System.out.print("Enter the number of characters to be compared: ");		
		s1 = sc.next();
		System.out.print("Enter the starting index of the comparison: ");		
		s2 = sc.next();
		int []lengthAndOffset = {Integer.parseInt(s1), Integer.parseInt(s2)};
		
		return lengthAndOffset;
	}
	
	private static void getOneSentenceInput()
	{
		System.out.print("Enter a sentence: ");		
		s1 = sc.nextLine();
	}
	
	
}
