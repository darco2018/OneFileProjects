// Fig. 8.6: Time2Test.java
// Overloaded constructors used to initialize Time2 objects.

public class Time2Test 
{
   public static void main(String[] args)
   {
	   Time2 t1 = new Time2(); // 00:00:00
	   System.out.printf("Total seconds before increment: %d%n", t1.getTotalSeconds());
	   displayTime("t1: ", t1); 
	   t1.incrementHour();
	   displayTime("t1: after incrementHour", t1);
	   System.out.printf("Total seconds after incrementHour: %d%n", t1.getTotalSeconds());
	   System.out.println();
	   
	   Time2 t7 = new Time2(23, 40, 10); // 23:40:10
	   System.out.printf("Total seconds before increment: %d%n", t7.getTotalSeconds());
	   displayTime("t7: ", t7); 
	   t7.incrementHour();
	   displayTime("t7: after incrementHour", t7);
	   System.out.printf("Total seconds after incrementHour: %d%n", t7.getTotalSeconds());
	   System.out.println();
	   
	   Time2 t8 = new Time2(23, 59, 59); // 23:59:59
	   System.out.printf("Total seconds before increment MINUTE: %d%n", t8.getTotalSeconds());
	   displayTime("t8: ", t8); 
	   t8.incrementMinute();
	   displayTime("t8: after increment MINUTE", t8);
	   System.out.printf("Total seconds after increment MINUTE: %d%n", t8.getTotalSeconds());
	   System.out.println();
	   
	   Time2 t9 = new Time2(23, 59, 59); // 23:59:59
	   System.out.printf("Total seconds before TICK: %d%n", t9.getTotalSeconds());
	   displayTime("t9: ", t9); 
	   t9.tick();
	   displayTime("t9: after TICK", t9);
	   System.out.printf("Total seconds after TICK: %d%n", t9.getTotalSeconds());
	   System.out.println();
	   
	   
      
      
      
      /*Time2 t4 = new Time2(12, 25, 42); // 12:25:42
      System.out.printf("Total seconds: %d%n", t4.getTotalSeconds());
      Time2 t5 = new Time2(t4); // 12:25:42

      System.out.println("Constructed with:");
      
      
      
      displayTime("t4: hour, minute and second specified", t4);
      displayTime("t5: Time2 object t4 specified", t5);
      
      t5.tick();
      displayTime("t5: after tick method", t5);
      t5.incrementMinute();
      displayTime("t5: after incrementMinute", t5);
      t5.incrementHour();
      displayTime("t5: after incrementHour", t5);
      // attempt to initialize t6 with invalid values
      try
      {
         Time2 t6 = new Time2(27, 74, 99); // invalid values
      } 
      catch (IllegalArgumentException e)
      {
         System.out.printf("%nException while initializing t6: %s%n",
            e.getMessage());
      } */
   } 

   // displays a Time2 object in 24-hour and 12-hour formats
   private static void displayTime(String header, Time2 t)
   {
      System.out.printf("%s%n   %s%n   %s%n",
         header, t.toUniversalString(), t.toString());
   } 
} // end class Time2Test


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
