package chapter19.searchsortbigo;

public class LinearSearchRecursive19_8 {
	
	static String[] arr = {"ala", "zero", "take", "big", "long"};

	public static void main(String[] args) {
		
		String key1 = "take";
		
		System.out.println("Search key: " + key1 + " Linear search result: " + 
						linearSearch(key1, 0) );
		
		String key2 = "big";
		
		System.out.println("Search key: " + key2 + " Linear search result: " + 
						linearSearch(key2, 0) );
		
		String key3 = "wrong";
		
		System.out.println("Search key: " + key3 + " Linear search result: " + 
						linearSearch(key3, 0) );
		
	}
	
	private static <T> int linearSearch(T searchKey, int startIndex){
		
		if (arr[startIndex].equals(searchKey))
			return startIndex;
		
		if (startIndex == arr.length - 1){
			return -1;
		} 
		else{
			return linearSearch(searchKey, startIndex + 1);
		}
	}

}
