public class CatchingExceptionsWithSuperclass_11_16 {

	public static void main(String[] args) {
		
		try
		{
			System.out.println("Welcome");
			throw new ExceptionB();
		}
		catch(ExceptionA e)
		{
			System.out.println("catch(ExceptionA e) has handled successfully ExceptionB");
		}
		
		try
		{
			throw new ExceptionC();
		}
		catch(ExceptionA e)
		{
			System.out.println("catch(ExceptionA e) has handled successfully ExceptionC");
		}
	}
}

class ExceptionA extends Exception {
	void print()
	{
		System.out.println("Welcome to ExceptionA");
	}
}

class ExceptionB extends ExceptionA {
	void print()
	{
		System.out.println("Welcome to ExceptionB");
	}
}

class ExceptionC extends ExceptionB
{
	void print()
	{
		System.out.println("Welcome to ExceptionV");
	}
}