import java.util.regex.Pattern;


public class RegEx2 {

	public static void main(String[] args) {

		String name1 = "5 people live with 3 dogs in 7 cities";
		String name2 = "A-RTEF";
		String name3 = "AZ'dreg";
		String regex = "[a-zA-Z]+(['-][a-zA-Z]+)*";
		
		System.out.println(name1.replaceAll("\\d", "NUMBER"));
		System.out.println(Pattern.matches(regex, name3));
		System.out.println(name2.matches(regex));
		System.out.println(name3.matches(regex));
	}

}
