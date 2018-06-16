package chapter20genericclassesandmethods;

public class GenericMethodVsObject {

	public static void main(String[] args) {
		
		Integer myInt1 = doSomethingGeneric(5);//no need to cast
		
		Integer myInt2 = (Integer) doSomethingObject(5); // correct but you need to downcast
		
		Integer myInt3 = (Integer) doSomethingObject("Hallo"); 
		//compiler only makes sure you downcast to Integer
		// but doesn't warn you that  can't downcast from String to Integer
		// as a result, at runtime you get
		// "java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer"		
		
		// remove the comment to see the compiler warning for:     Integer myInt4 = (Integer) doSomethingGeneric("Hallo"); 
		// compile type-safety: compiler warns you
		// "java.lang.Error: Unresolved compilation problem:
		// Cannot cast from String to Integer"
		
		// Another example:
		// String response = doSomething("hello world"); - is ok but this:  
		// (String) doSomething(5.6);  would cast exception with no warning from compiler
		
		// All in all, in the Object version, the compiler doesn't make sure that 
		// what you return from the method will be able to be downcast into what the calling methods wants
	}
	
	private static <T> T doSomethingGeneric(T t){ return t;}
	
	private static Object doSomethingObject(Object obj){return obj;}

}
