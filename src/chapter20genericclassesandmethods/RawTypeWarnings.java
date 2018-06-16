package chapter20genericclassesandmethods;

public class RawTypeWarnings {

	public static void main(String[] args) {
		
		Stack s1 = new Stack();
		Stack s2 = new Stack <String>();
		Stack <Integer> s3 = new Stack ();
	}

}

class Stack<T>{
	
	
}
