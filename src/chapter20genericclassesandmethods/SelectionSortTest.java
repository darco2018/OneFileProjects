// Fig. 19.6: SelectionSortTest.java
// Sorting an array with selection sort - turned into a generic method

package chapter20genericclassesandmethods;
import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSortTest
{
   // sort array using selection sort
   public static <T extends Comparable<T>> void selectionSort(T[] data)              
   {
      // loop over data.length - 1 elements      
      for (int i = 0; i < data.length - 1; i++)
      {
         int smallest = i; // first index of remaining array

         // loop to find index of smallest element              
         for (int index = i + 1; index < data.length; index++){
        	 if (data[index].compareTo(data[smallest]) < 0){ 		// if (data[index] < data[smallest])  
        		 smallest = index;   
        	 }            
         }                                   

         swap(data, i, smallest); // swap smallest element into position
         printPass(data, i + 1, smallest); // output pass of algorithm  
      }                                          
   } // end method selectionSort                                    

   
   
   
   // helper method to swap values in two elements
   private static <T> void swap(T[] data, int first, int second)
   {
      T temporary = data[first]; // store first in temporary
      data[first] = data[second]; // replace first with second
      data[second] = temporary; // put temporary in second
   } 

   
   
   
   // print a pass of the algorithm
   private static <T> void printPass(T[] data, int pass, int index)
   {
      System.out.printf("after pass %2d: ", pass);

      // output elements till selected item
      for (int i = 0; i < index; i++){
    	  String str = data[i].toString();
    	  System.out.printf("%s  ", str);    	  
      }
         
      String str = data[index].toString();
      System.out.printf("%s* ", str); // indicate swap

      // finish outputting array
      for (int i = index + 1; i < data.length; i++){
    	  String st = data[i].toString();
    	  System.out.printf("%s  ", st);
      }
         

      System.out.printf("%n               "); // for alignment

      // indicate amount of array that’s sorted
      for (int j = 0; j < pass; j++)
         System.out.print("--  ");
      System.out.println(); 
   } 

   
   
   
   
   public static void main(String[] args)
   {
      SecureRandom generator = new SecureRandom();

      Integer[] data = new Integer[10]; // create array

      for (int i = 0; i < data.length; i++) // populate array
         data[i] = 10 + generator.nextInt(90);

      System.out.printf("Unsorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
      selectionSort(data); // sort array   

      System.out.printf("Sorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
      
      /// the same for a float array
      
      Float[] floatData = new Float[10]; // create array

      for (int i = 0; i < floatData.length; i++) {
    	  	int int1 = 10 + generator.nextInt(90);
    	  	int int2 = 10 + generator.nextInt(90);	//data[i] = 10 + generator.nextInt(90));
    	  	String str = String.valueOf(int1) + "." + String.valueOf(int2);
    	  	floatData[i] = Float.valueOf(str);
   		}
         

      System.out.printf("Unsorted array:%n%s%n%n", 
         Arrays.toString(floatData)); // display array
      selectionSort(floatData); // sort array   

      System.out.printf("Sorted array:%n%s%n%n", 
         Arrays.toString(floatData)); // display array
   } 
} // end class SelectionSortTest



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