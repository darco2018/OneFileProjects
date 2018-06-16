package chapter19.searchsortbigo;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		String[] myArray = {"ale","ben","car","dog","ewa","fly","john","paul","sting","ust","zorro"};
		String toFind = "ben";
		
		int index = binarySearch(myArray, toFind);
		System.out.println( index >= 0 ? myArray[index] + " at index " + index : index);
		
		index = binarySearch(myArray, "fly");
		System.out.println( index >= 0 ? myArray[index] + " at index " + index : index);
		
		index = binarySearch(myArray, "drink");
		System.out.println( index >= 0 ? myArray[index] + " at index " + index : index);

	}
	
	private  static int binarySearch(String[] myArray, String toFind){
		int low = 0 ;
		int high = myArray.length - 1;
		
		while(high >= low){
			
			int mid = (low + high + 1) / 2;
			
			int result = toFind.compareTo(myArray[mid]);
			
			if(result == 0){
				return mid;
			} else if (result < 0){
				high = mid - 1;				
			} else
				low = mid + 1;			
		}
		
		return -1;
	}

}
