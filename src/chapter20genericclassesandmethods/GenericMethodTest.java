package chapter20genericclassesandmethods;

public class GenericMethodTest 
{
   public static void main(String[] args) 
   {
      // create arrays of Integer, Double and Character
      Integer[] integerArray = {1, 2, 3, 4, 5, 6};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
      String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight"};

      System.out.print("Array integerArray contains:\n");
      printArray(integerArray); // pass an Integer array 
      System.out.printf("%nArray doubleArray contains:%n");
      printArray(doubleArray); // pass a Double array
      System.out.printf("%nArray characterArray contains:%n");
      printArray(characterArray); // pass a Character array
      
      System.out.printf("%nArray stringArray contains:%n");
      printArray(stringArray); // pass a String array
   } 

   // generic method printArray
   public static <T> void printArray(T[] inputArray)
   {
      // display array elements
      for (T element : inputArray)
         System.out.printf("%s ", element);

      System.out.println();
   }
   
   // overloaded generic method
   public static void printArray(String[] inputArray)
   {
      // display array elements
      for (int i = 0; i < inputArray.length; i++){
    	  
    	  if (i%4 == 0 && i != 0)
    		  System.out.println(); 
    	  
    	  System.out.printf("%-10s ", inputArray[i]);
      }
   }
} // end class GenericMethodTest

