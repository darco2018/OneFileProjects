
public class RethrowingExceptions11_20 {

	public static void main(String[] args) {
		
		try{
			someMethod();
		}
		catch (RuntimeException e){
			e.printStackTrace();
		}
	}
	
	private static void someMethod(){
		try{
			someMethod2();
		}
		catch (RuntimeException e){
			throw e;
		}
	}
	
private static void someMethod2(){
	//System.out.println("someMethod2");
	throw new RuntimeException("I've been thrown in someMethod2");
	}
}
