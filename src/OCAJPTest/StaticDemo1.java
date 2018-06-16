package OCAJPTest;

public class StaticDemo1 {
	
	StaticDemo1() { 
		System.out.print("3 "); 
	}
	
	{ System.out.print("2 "); }
	
	public static void main(String[] args) {
		new StaticDemo1().go();
	}
	
	void go(){ 
		System.out.print("4 "); 
	}
	
	static { System.out.print("1 "); }
}

