// Fig. 11.2: DivideByZeroNoExceptionHandling.java
// Integer division without exception handling.
import java.util.Scanner;

public class DivideByZeroNoExceptionHandling
{
   // demonstrates throwing an exception when a divide-by-zero occurs
   public static double quotient(double numerator, double denominator)
   {
      return numerator / denominator; // possible division by zero
   }

   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in); 

      System.out.print("Please enter an integer numerator: ");
      double numerator = scanner.nextDouble();
      System.out.print("Please enter an integer denominator: ");
      double denominator = scanner.nextDouble();

      double result = quotient(numerator, denominator);
      System.out.printf(
         "%nResult: %.2f / %.2f = %.2f%n", numerator, denominator, result);
      
      System.out.println(result + 2);
      isDouble(result);
      System.out.println("Is is a Nan? using Double.isNan(double number): " + Double.isNaN(result));
   }
   
   
   		static void isDouble(double number) 
   		{
   			try {
    	   System.out.println(number + " is a double");
   				} catch (IllegalArgumentException e) {
    	   System.out.println(e + ": " + number + "is NOT a double");
       }
       
       
   }
} // end class DivideByZeroNoExceptionHandling


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
