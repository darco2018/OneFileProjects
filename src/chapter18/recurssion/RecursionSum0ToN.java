package chapter18.recurssion;

public class RecursionSum0ToN {
	private static int call = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = sum(3);
	}
	
	
	public static int sum(int n){
		System.out.printf("////CALL: %d%n", ++call );
		int value = 0;
		
		if (n == 0) {
			System.out.printf("Returning %d%n", n);
			return 0;
		} else {
			value = sum(n-1);			
			System.out.printf("Returning %d + %d%n", n, value);			
			return n + value;
		}
	}

}
