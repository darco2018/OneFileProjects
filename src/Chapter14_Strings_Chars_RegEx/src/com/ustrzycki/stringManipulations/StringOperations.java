package com.ustrzycki.stringManipulations;

public class StringOperations {
	
	
	
	public static String compareTwoStrings(String s1, String s2)
	{
		String comparisonResult = String.format("Word1 is %s Word2", s1.compareTo(s2) < 0 ? "less than" : 
							(s1.compareTo(s2) == 0 ? "equal to" : "greater than"));		
		
		return comparisonResult;
	}
	
	public static String comparePortionsOfTwoStrings(String s1, String other, int [] lengthAndOffset)
	{
		boolean equal = s1.regionMatches(true, lengthAndOffset[1], other, lengthAndOffset[1], lengthAndOffset[0]);
		
		return String.format("The substrings are %s", equal ? "equal" : "not equal");  
	}

}
