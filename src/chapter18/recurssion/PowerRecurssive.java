package chapter18.recurssion;

public class PowerRecurssive {

	public static void main(String[] args) {

		int base = 3;
		
		for (int i = 1; i < 6; i++) {
			System.out.println("base " + base + " to the power of " + i + " is " + power(base,i));			
		}
	}
	
	private static int power(int base, int exponent){
		
		if(exponent == 1){
			return base;
		}
		else {
			return base*power(base, exponent-1);
		}
	}
}
