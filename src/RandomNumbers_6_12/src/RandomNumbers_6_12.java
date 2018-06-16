
public class RandomNumbers_6_12 {

	public static void main(String[] args) {
		
		java.security.SecureRandom randomNumbers = new java.security.SecureRandom();
		
		int n;
		
		for (int count = 1; count <= 1000; count++)
		{
		  n = 6 + 4 * randomNumbers.nextInt(5);
		  System.out.println(n);
		  
		  if(  n < 6 || n > 22)
		  {
			  System.out.println("alarm");
			  break;
		  }
		}
		
		

	}

}
