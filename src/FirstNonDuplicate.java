import java.util.Scanner;

public class FirstNonDuplicate {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = "";

		do {

			System.out.println("Enter a text or Q to quit:");
			input = sc.nextLine();

			// firstNonDuplicate(input);

		} while (!"q".equalsIgnoreCase(input));

		sc.close();

	}

	private static String firstNonDuplicate(String text) {

		return "";
	}

}
