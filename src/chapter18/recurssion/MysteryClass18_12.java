package chapter18.recurssion;

public class MysteryClass18_12 {
	
	public static int mystery(int[] arr, int size){
		
		if(size == 1)
			return arr[0];
		else{
			return arr[size - 1] + mystery(arr, size - 1);
		}
	}

	public static void main(String[] args) {
		
		int[] array = {1,2,3,4};		
		System.out.println(mystery(array, array.length));
		
		System.out.println(someMethod(array, 0));
	}
	
	public static String someMethod(int[] arr, int x){
		

		if (x < arr.length)
			return String.format("%s%d ", someMethod(arr, x + 1), arr[x]);
		else
			return "";
	}
}
