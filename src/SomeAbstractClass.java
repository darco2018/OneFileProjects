import initialpackage;
import initialpackage.*;


interface Super {
	
	int x = 10;
	static int y = 100;
	
	  default int method(){return  1;}
}

public class SomeAbstractClass extends B implements Super   {
	
	int x = 20;
	static int y = 200;
	
	
	public int method(){return  2;}
	
	
	public static void main(String[] args) {		
		Super sup = new SomeAbstractClass();
		
		final String h = "asd";
		
		int[] arr1 = new int[2];
		arr1[0]= 1;
		arr1[1]= 1;
		
		String z = 63 + new Integer(10) + "s";
		
		
		System.out.println(z);
		
		
		//System.out.println(sup.method()); //access to static methods
		//System.out.println(sup.x); //access to static field
		//System.out.println(sup.y); //access to instance methods
		int key = 6;
		String stringKey = "sdf";
		
		switch (stringKey){ 
		default:;
		case h:; 
		}
		
		if(false)
			key = 6;
		
	}
	
	
}



	


