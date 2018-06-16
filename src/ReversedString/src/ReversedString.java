
public class ReversedString {

	public static void main(String[] args) {
		
		String s = "Hallo John";
		String b2 = "b";
		String reversed = "";
		
		Integer myInteger = 1;
		
				
		for(int count = s.length()-1; count >= 0; count--){
			reversed += s.charAt(count);  //lub String.format("%c", s.charAt(count));
		}
		
		System.out.println(reversed);
		System.out.println(myInteger.toString());	
		
		

	}

}


