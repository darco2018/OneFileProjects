package chapter16.genericcollections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CopyReverseList {
	
	private static List<Character> list;
	private static List<Character> copyList;
	private static List<Character> copyList_2;

	public static void main(String[] args) {
		
		list = new LinkedList<>();
		create10charsList();
		displayList("Original list: ", list);
		
		createReversedCopy();
		displayList("Original list after reversing of the COPY is unchanged: ", list);
		displayList("Copylist after reversing with reversed letters: ", copyList);
	}
	
	private static void create10charsList(){
		
		Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','w','v','x','y','z'};
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {
			list.add( alphabet[generator.nextInt(alphabet.length)] );
		}
	}
	
	private static void createReversedCopy(){
		
		copyList = new LinkedList<>(list);
		Collections.reverse(copyList);
	}
	
	private static void displayList(String info, List<Character> list){
		
		System.out.printf("%n%s: %s", info, list);
	}

}
