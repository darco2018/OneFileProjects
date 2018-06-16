package chapter16.genericcollections;
// Fig. 16.15: PriorityQueueTest.java
// PriorityQueue test program.
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

public class ChangePQueueSortOrder 
{
	// queue of capacity 11
	private static PriorityQueue<Double> queue; 
	private static PriorityQueue<Double> queue2; 
	
   public static void main(String[] args) 
   {
      // queue of capacity 11
	  queue = new PriorityQueue<>(); 
      queue2 = new PriorityQueue<>(Collections.reverseOrder());

      // polling from queue
      insertInQueue(queue);
      displayQueue("\nThe queue without a comparator, so ascending order", queue);
      
      // polling from queue2
      insertInQueue(queue2);
      displayQueue("\nThe reversed queue with a comparator, so descending order", queue2) ;  
   } 
   
   private static void insertInQueue(PriorityQueue que){	   
	   	  que.offer(3.2);
	      que.offer(9.8);
	      que.offer(1.7);
	      que.offer(5.4);	   
   }
   
   private static void displayQueue(String info, Queue<Double> q){
	
	   System.out.println("\n" + info);
	   while (q.size() > 0)
	      {
	         System.out.printf("%.1f    ", q.peek()); // view top element
	         q.poll(); // remove top element
	      } 
	}
} // end class PriorityQueueTest

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
