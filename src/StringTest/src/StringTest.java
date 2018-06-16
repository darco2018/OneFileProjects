
public class StringTest {

	public static void main(String[] args) {

		String myString = "Darek";
		
		System.out.println("Inside the main(), before foo: " + myString);
		System.out.println(" myString  has code " + myString.hashCode());
		System.out.println();
		foo(myString);
		System.out.println();
		System.out.println("Inside the main(), after foo: " + myString);
	}
	
	public static void foo(String someString)
	{
		System.out.println("Inside the foo method, before the assignement: " 
				+ someString);	// czy tu wyświetla się ten sam string co zostął przesłany w main?! 
								// czy może raczej powstał nowy string, tylko ma te sam tekst co ten z main?
		// TEN SAM OBJEKT Mozesz to zawsze zweryfikowac wywolujac I wyswietlajac resultat metody hashCode() 
		// two objects which equals() says are equal must report the same hash value. 
		System.out.println(" someString  has code " + someString.hashCode());
				
		someString = "Tomek"; // czy w tym momencie powstał nowy string, 
						      // czy moze zastapilem tylko tekst w tym poprzednim?
		// Jest to nowy obiekt. Ale przypisany do tego samego reference. 
		// someString – to jest reference do obiektu w pamieci. 
		// Wczesniej wskazywal na obiekt o wartosci Darek, a teraz na Tomek.
		System.out.println(" someString  has code " + someString.hashCode());		
		System.out.println("Inside the foo method, after the assignement:" + someString);
		
		someString = new String("Julcia"); // tu na pewno powstał nowy string, ale co się stało ze stringiem 
		// który miał w sobie tekst "Tomek"?! Przestał istnieć?
		System.out.println("Inside the foo method, after new String():" + someString);
		// Jesli nie ma reference, ktore na niego wskazuje, to przestal istniec. Teoretycznie moze jeszce przez 
		//chwile byc w pamieci zanim go zje tzw. garbage collector, ale traktuj go jako nieistniejacy.
		System.out.println(" someString  has code " + someString.hashCode());
	}
	
	
}
