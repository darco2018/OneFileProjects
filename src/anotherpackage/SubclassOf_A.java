package anotherpackage;
import initialpackage.A;

public class SubclassOf_A extends A {
			
	public static void main(String[] args) {
		
		A superclassInstanceInAnotherPackage = new A();
		//int var1 = superclassInstanceInAnotherPackage.x; // COMPILE ERROR error THE FIELD A.x is not visible
		                        // as it is "protected" in a different package
		
		SubclassOf_A subclassInstance = new SubclassOf_A();
		int var2 = subclassInstance.x; // x is visible here because it is inherited by the Whiz subclass
	}
	
	public void getWhiz(){
		
		A superclassInstanceInAnotherPackage = new A();
		//int var12 = superclassInstanceInAnotherPackage.x; // COMPILE ERROR - as above
	}
}

 
