// Fig. 20.3: GenericMethodTest.java
// Printing array elements using generic method printArray.
// second version of printArray by Dariusz Ustrzycki
package chapter20genericclassesandmethods;

public class GenericMethodTest1 {
	public static void main(String[] args) {
		// create arrays of Integer, Double and Character
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.print("Array integerArray contains:\n");
		printArray(integerArray); // pass an Integer array
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray); // pass a Double array
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray); // pass a Character array

		//////////

		System.out.println("\nArray integerArray from 0-3:");
		printArray(integerArray, 0, 3); // pass an Integer array
		System.out.printf("%nArray doubleArray from 4-6:%n");
		printArray(doubleArray, 4, 6); // pass a Double array
		System.out.printf("%nArray characterArray from 2-3:%n");
		printArray(characterArray, 2, 3); // pass a Character array

		try {
			printArray(integerArray, -1, 3);

		} catch (InvalidSubscriptException e) {
			System.err.println();
			e.printStackTrace();
		}

		try {

			printArray(doubleArray, 4, 20);

		} catch (InvalidSubscriptException e) {
			System.err.println();
			e.printStackTrace();
		}

	}

	// generic method printArray
	public static <T> void printArray(T[] inputArray) {
		// display array elements
		for (T element : inputArray)
			System.out.printf("%s ", element);

		System.out.println();
	}

	// overloaded generic method printArray
	public static <T> void printArray(T[] inputArray, int lowSub, int highSub) {

		if (lowSub < 0 || highSub > inputArray.length)
			throw new InvalidSubscriptException(
					"\nSubscripts can't be less than 0 or greater than array's length:\nlowSub: " + lowSub
							+ " highSub: " + highSub);

		for (int i = lowSub; i < highSub; i++) {
			System.out.printf("%s ", inputArray[i]);
		}

		System.out.println();
	}
} // end class GenericMethodTest

@SuppressWarnings("serial")
class InvalidSubscriptException extends RuntimeException {

	InvalidSubscriptException() {
		this("The subscript is either less than 0 or greater than the array's length.");
	}

	InvalidSubscriptException(String message) {
		super(message);
	}
}
