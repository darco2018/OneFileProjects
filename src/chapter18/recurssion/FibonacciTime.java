package chapter18.recurssion;

import java.math.BigInteger;

public class FibonacciTime {
	
	private static BigInteger TWO = new BigInteger("2");
	private static int fibonacciMethodCount = 0;

	public static void main(String[] args) {
		
		long startProgramTime = System.currentTimeMillis();

		for (int i = 0; i <= 40; i++) {
			//measure the time for finding each Fibonacci number
			long startTime = System.currentTimeMillis();
			BigInteger fibonacciNumber = fibonacci(BigInteger.valueOf(i));			
			long difference = System.currentTimeMillis() - startTime;
			
			System.out.printf("%2d F: %9d calls: %9d miliseconds:%5d%n", i, fibonacciNumber, fibonacciMethodCount, 
					difference);	
		}
		
		long programmRunTime = System.currentTimeMillis() - startProgramTime; 
		System.out.println("Total running time: " + programmRunTime);
		System.out.println("Calls per 1 milisecond: " + ( fibonacciMethodCount / programmRunTime));
	}
	
	private static BigInteger fibonacci (BigInteger number){
		
		fibonacciMethodCount++;
		
		if( number.compareTo(BigInteger.ZERO) <= 0 )
			return BigInteger.ZERO;
		
		if( number.compareTo(BigInteger.ONE) <= 0 )
			return BigInteger.ONE;
		
		return fibonacci(number.subtract(BigInteger.ONE)).add(
				fibonacci(number.subtract(TWO)));
	}

}
