package chapter19.searchsortbigo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {

		String[] myArray = {"john", "ale","ust","ben","dog","fly","paul","car", "sting","zorro", "ewa"};
		int[] vals = { 3, 12, 8, 1, 5, 2, 9, };
		selectionSort(vals);
		System.out.println(Arrays.toString(vals));
		///// 2 ////////// new test ////////////////
		int[] vals2 = { 3, 12, 8, 1, 5, 2, 9, };
		insertionSort(vals2);
		System.out.println(Arrays.toString(vals2));
		
		//// 3 /////////////////////////
		Random random = new Random();
		List<Integer> numsToSort = new ArrayList();
		
		for(int i=0; i < 5; i++){
			numsToSort.add(random.nextInt(100));			
		}
		
		
		Collections.sort(numsToSort);
		System.out.println(numsToSort.toString());
		
		/// 4 //////////////////////////
		String[] words = {"happy", "alien", "zoo" , "shy"};
		List<String> listOfWords = Arrays.asList(words); // w drugá stroné mamy myColl.toArray() (Collection method)
		Collections.sort(listOfWords);
		System.out.println(listOfWords);
	}
	
	public static void selectionSort(int[] vals){
		
				
		for(int initialPosiotionOfSmallestNum=0; initialPosiotionOfSmallestNum < vals.length - 1; initialPosiotionOfSmallestNum++){
			
			int indexOfSmallestNumber = initialPosiotionOfSmallestNum;			
			
			for(int higher = initialPosiotionOfSmallestNum+1; higher < vals.length; higher++){
				
				if( vals[higher] < vals[indexOfSmallestNumber] ){
					indexOfSmallestNumber = higher;
				}
			}
			
			swap(vals, indexOfSmallestNumber, initialPosiotionOfSmallestNum);
		}
	}
	
	public static void insertionSort(int[] vals){
		
		// starts with 1 here!   and now it's < vals.length, not < vals.length -1 as in the selectionSort
		for(int position=1; position < vals.length; position++){
			
			int currentIndex = position;			
			
			while(currentIndex > 0 && vals[currentIndex] < vals[currentIndex - 1]  ){
				
				swap(vals, currentIndex, currentIndex - 1);
				currentIndex = currentIndex - 1;
			}
		}
	}
	
	private static void swap(int[] vals, int num1, int num2){
		
		//System.out.println("vals[num1]: " + vals[num1] + " vals[num2]: " + vals[num2] );
		
		int temp = vals[num1];
		vals[num1] = vals[num2];
		vals[num2] = temp;
		
		//System.out.println("vals[num1]: " + vals[num1] + " vals[num2]: " + vals[num2] );
	}

}
