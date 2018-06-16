package chapter18.recurssion;

public class MysteryRecursion_18_7 {
	
	private static int call = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mystery(3, 4);

	}
	
	public static Integer mystery(int a, int b){
		
		System.out.printf("////CALL: %d%n", ++call );
		System.out.printf("a: %d, b: %d%n", a, b );
		int value = 0;
		
		if (b==1){
			System.out.printf("Returning a : %d%n", a);
			return a;
		}
			
		else {
			value = a + mystery(a, b-1);
			System.out.printf("Returning value=%d%n", value);
			return value;
		}
			 
	}

}
