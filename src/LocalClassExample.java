/*The example validates a phone number by first removing all characters from the phone number
except the digits 0 through 9. After, it checks whether the phone number contains exactly 
ten digits (the length of a phone number in North America).*/ 


public class LocalClassExample {
	
	static String regularExpression = "[^0-9]";
	
	
	  
    public static void validatePhoneNumber( String phoneNumber1, String phoneNumber2) {
      
        final int numberLength = 10;
        
        // Valid in JDK 8 and later:       
        //int numberLength = 10;
       
        class PhoneNumber {
        	
        	// static int number = 45; inner casses cannot declare static members
            
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                //numberLength = 7; >> compile error, not effectively final variable
                
            	String currentNumber = phoneNumber.replaceAll(
                  regularExpression, "");
            	
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            } // end constructor

            public String getNumber() {
                return formattedPhoneNumber;
            }
            
            // Valid in JDK 8 and later:

            public void printOriginalNumbers() {
            System.out.println("Original numbers are " + phoneNumber1 + // can access method parameters
                  " and " + phoneNumber2);
           }
        }

        
        
        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
        
        // Valid in JDK 8 and later:
//        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null) 
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }

}
