package chapter16.genericcollections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortWordsWithTreeSet {
	

	public static void main(String[] args) {
		
		String text = getInput();		
		String[] wordsArr =  text.split(" ");
		
		Set<String> wordsSet = new TreeSet<>(Arrays.asList(wordsArr));
		
		displaySet("The set created by new TreeSet<>(Arrays.asList(words))."
				+ "\nThe words should be sorted \n",  wordsSet);
		
		System.out.println();
		for (Iterator iterator = wordsSet.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.print(string + " ");
		}
	}
	
	private static String getInput(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence: ");
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}
	
	private static void displaySet(String info, Set<String> set){
		
		System.out.printf("%n%s: %s", info, set);
	}
}
