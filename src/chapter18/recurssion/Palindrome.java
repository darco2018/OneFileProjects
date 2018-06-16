package chapter18.recurssion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindrome {

	public static void main(String[] args) {
		
		System.out.println("Palindromes: (expected: true");
		String[] palindromes = {"b", "rr", "radar", "ysy", "im yoy mi", "ra d,ar!", "  im,, yoy; mi"};
		
		for (String s : palindromes) {
			System.out.println(isPalindrome(s));
		}
		
		System.out.println("Non-palindromes: (expected: false");
		String[] nonPalindromes = {"ba", "rr1", "radbr", " ysy t"};
		for (String s : nonPalindromes) {
			System.out.println(isPalindrome(s));
		}
		
	}
	
public static boolean isPalindrome(String text){
		
		// remove non-word characters
		String cleanText = "";	
				
		Pattern pattern = Pattern.compile("\\w");
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()){
			cleanText += matcher.group();
		}
		
		// turn each character into an element of an array
		char[] textAsChars = cleanText.toCharArray();
		
		
		return recursivePalindromeCheck(textAsChars, 0, textAsChars.length - 1);
	}
	
	private static boolean recursivePalindromeCheck(char[] arr, int zero, int size){
		
		// alternative: use substring method to shorten the array each time it's called. Then you dont need 2nd and 3rd argument
		if( zero >= size)
			return true;
		
		boolean palindrome = false;
		
		if( (String.valueOf(arr[zero])).equals(String.valueOf(arr[size])))
			palindrome = recursivePalindromeCheck(arr, zero+1, size-1);
		else
			return false;
		
		return palindrome;
	}
}
