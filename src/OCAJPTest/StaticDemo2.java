package OCAJPTest;

public class StaticDemo2 {

	public static void main(String[] args) {
		StaticDemo2 obj = new StaticDemo2();
	}
	
	{ System.out.println("2. Nonstatic Hello");}
	
	static { System.out.println("1. Static Hello");}
}
