package chapter20genericclassesandmethods;

public class CastErasureCheck {

	public static void main(String[] args) {

		// System.out.printf();
		int num = someMethod(4);
		System.out.println(num);

		// int num2 = someMethod2(4); Type mismatch: cannot convert from
		// Comparable to int
		int num2 = (int) someMethod2(4); // albo Comparable num2 = (int)
											// someMethod2(4); te¿ zadzia³a
											// mo¿na tez zmieniæ return type

		System.out.println(num2);

	}

	private static <T extends Comparable<T>> T someMethod(T obj) {
		return obj;
	}

	private static Comparable someMethod2(Comparable obj) {
		return obj;
	}

}
