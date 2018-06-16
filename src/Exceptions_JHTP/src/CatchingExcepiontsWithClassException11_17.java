import java.io.IOException;


public class CatchingExcepiontsWithClassException11_17 {

	public static void main(String[] args) {
		
		try{
			throw new ExceptionA(); }
		catch(Exception e){
			System.out.println("catch(Exception e) has handled ExceptionA"); }
		
		try{
			throw new ExceptionB(); }
		catch(Exception e){
			System.out.println("catch(Exception e) has handled ExceptionB"); }
		
		try{
			throw new NullPointerException(); }
		catch(Exception e){
			System.out.println("catch(Exception e) has handled NullPointerException"); }
		
		try{
			throw new IOException(); }
		catch(Exception e){
			System.out.println("catch(Exception e) has handled IOException"); }
		
		System.out.println("Program continues after the exceptions have been handled"); 
	}
}

class ExceptionA extends Exception{
	void print()
	{
		System.out.println("Welcome to ExceptionA");
	}
}
class ExceptionB extends ExceptionA{
	void print()
	{
		System.out.println("Welcome to ExceptionB");
	}
}

