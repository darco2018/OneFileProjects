package chapter19.searchsortbigo;

public class BinarySearchRecursive19_9 {
	
	static String[] myArray = {"ale","ben","car","dog","ewa","fly","john","paul","sting","ust","zorro"};

	public static void main(String[] args) {
		
		String toFind = "ben";		
		int index = binarySearch(myArray, toFind);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);			
		index = binarySearchRecursive(toFind, 0, myArray.length -1);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);	
		
		toFind = "fly";		
		index = binarySearch(myArray, toFind);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);				
		index = binarySearchRecursive(toFind, 0, myArray.length -1);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);	
		
		toFind = "zorro";		
		index = binarySearch(myArray, toFind);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);			
		index = binarySearchRecursive(toFind, 0, myArray.length -1);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);	
		
		toFind = "sdfgh";		
		index = binarySearch(myArray, toFind);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);			
		index = binarySearchRecursive(toFind, 0, myArray.length -1);
		System.out.println(index >= 0 ? myArray[index] + " at index " + index : index);	
		

	}
	
	private  static <T extends Comparable<T>> int binarySearchRecursive(T searchKey, int low, int high){
		
		if (low >= high) 
			return -1;		
		
		int mid = (low + high + 1) / 2;
		int result = searchKey.compareTo((T)myArray[mid]); 
		
		if( result == 0)
		{
			return mid;
		}			
		else 
		{
			if (result < 0)
				high = mid - 1;				
			else
				low = mid + 1;	
			
			return binarySearchRecursive(searchKey, low, high);
		}
		
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
