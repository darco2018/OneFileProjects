package chapter16.genericcollections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DuplicateElimination {

	public static void main(String[] args) {
		
		List<String> namesList = new LinkedList<>();
		Set<String> namesSet = new LinkedHashSet<>();
		
		Scanner sc = new Scanner(System.in);
		
		boolean moreData = true;
		
		while (moreData) {
			
			System.out.println("Enter a name or -1 to quit: ");
			String input = sc.next();
			
			if("-1".equals(input))
				break;
			
			namesList.add(input);
			namesSet.add(input);
		}
		
		System.out.printf("%nThe names in the LinkedList in the insertion order: %s", namesList);
		System.out.printf("%nThe names in the LinkedHashSet should have no duplicates as Sets don't allow dupliacates: %s", namesSet);
		
		moreData = true;
		
		while (moreData) {
			
			System.out.println("\nSearch for a name or -1 to quit: ");
			String input = sc.next();
			
			if("-1".equals(input))
				break;
			
			System.out.println("\nThe LinkedHashSet " + (namesSet.contains(input) ? "contains " : "doesn't contain ") + input);
			namesList.contains(input);
			;
		}

	}

}
