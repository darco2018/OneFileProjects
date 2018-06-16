package chapter20genericclassesandmethods;

public class isEqualToTest {

	public static void main(String[] args) {

		System.out.println(isEqualTo(new Object(), new Object()));
		System.out.println(isEqualTo(new Integer(5), new Integer(4)));
		System.out.println(isEqualTo(new Integer(5), new Integer(5)));
		System.out.println(isEqualTo(new String("a"), new String("b")));
		System.out.println(isEqualTo(new String("a"), new String("a")));

		System.out.println(isEqualTo(new String("a"), new Integer(4)));
		System.out.println(isEqualTo(new Integer(5), new Object()));
		System.out.println(isEqualTo(new Integer(5), new Double(5.0)));
	}

	/*
	 * private static <T> boolean isEqualTo(T arg1, T arg2){
	 * 
	 * return arg1.equals(arg2); }
	 */

	private static <T, V> boolean isEqualTo(T arg1, V arg2) {

		return arg1.equals(arg2);
	}

}
