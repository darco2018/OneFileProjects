package OCAJPTest;

class Person{
	
	Person(){
		System.out.println("2");}
	
	static {System.out.println("1");}
}

class Manager extends Person {
		
		Manager(){
			System.out.println("4");}
		
		{System.out.println("3");}	
}

public class StaticDemo3  {
	
	public static void main(String[] args) {
		Person p = new Manager();
	}
}
