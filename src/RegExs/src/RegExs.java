
public class RegExs {

	public static void main(String[] args) {

		String address = "46  Krakow    City";
		String regEx = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s+[a-zA-Z]+)";		
		boolean isAMatch = address.matches(regEx);                     //		
		System.out.println(isAMatch);
		
		
		String string2 = " ";
											String regEx2 = " +";
		isAMatch = string2.matches(regEx2);
		System.out.println(isAMatch);
		
		String string3 = "PL83 101010230000261395100000";
										String regEx3 = "PL[0-9]{2}( ?[0-9]{4}){6}";
isAMatch = string3.matches(regEx3);
System.out.println(isAMatch);


	String computerIP = "255.255.255.255";
	String regEx4 = "([0-9]{1,3}\\.){3}([0-9]{1,3})";
	isAMatch = computerIP.matches(regEx4);
	System.out.println(isAMatch);
	
	String dateRegEx = "[1-2][0-9]{3}\\.[0-1][0-9]\\.[0-3][0-9]";
	String myDate= "1999.06.00";
	isAMatch = myDate.matches(dateRegEx);
	System.out.println(isAMatch);
	
	String weightRegEx = "\\d{1,2}(|\\.{1}\\d{1,3})"; // "\\d{1,2} (|\\.?\\d{0,3}";  correct: "\\d{1,2}\\.?\\d{0,3}"
	String catWeight= "92.2245";
	isAMatch = catWeight.matches(weightRegEx);
	System.out.println("Weight regex: " + isAMatch);
	
	//double num = 54;
	//System.out.println(num);
	
		
		
		

	}

}
