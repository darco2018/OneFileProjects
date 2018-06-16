package chapter16.genericcollections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CalculateAverage {

	public static void main(String[] args) {

		
		List<Integer> list = new LinkedList<>();
		
		for (int i = 0; i < 25; i++) {
			
			Random numGenerator = new Random();
			int number = numGenerator.nextInt(101);
			list.add(number);			
		}
		
		displayList("Original list: ", list);
		Collections.sort(list);
		displayList("List after sorting: ", list);
		
		// calculate sum
		int sum = 0;		
		Iterator<Integer> it = list.iterator();
		
		while (it.hasNext()) {
			sum += it.next();			
		}
		
		System.out.print(String.format("%nThe sum is %s %nThe average is %.2f", sum, sum/25.0));
				
	}
	
	private static void displayList(String info, List<Integer> list){
		
		System.out.printf("%n%s: %s", info, list);
	}

}
