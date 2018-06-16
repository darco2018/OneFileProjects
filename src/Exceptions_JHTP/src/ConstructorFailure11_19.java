
public class ConstructorFailure11_19 {

	public static void main(String[] args) {
		
		SomeClass obj = new SomeClass();	
	}
}

class SomeClass //throws Exception
{
	SomeClass() 
	{
		try{
			throw new Exception();
		}
		catch(Exception e){
			
			System.out.println("the object has not been initialized");
		};
	}
}
