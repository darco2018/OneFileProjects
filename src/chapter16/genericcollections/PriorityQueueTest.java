package chapter16.genericcollections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {

		Queue<String> q = new PriorityQueue<String>();
		q.offer("hi");
		q.offer("ala");
		q.offer("zoon");
		q.offer("kater");
		
		Iterator<String> i = q.iterator();
		while ( i.hasNext()) {
			String string = (String) i.next();
			System.out.print(string + " ");
		}
		System.out.println(">> the iterator is not guaranteed to iterate in any particular order. \nFor an ordered traversal consider " 
							+ "Arrays.sort(queue.toArray)");
				
		
		System.out.println("\nLooking at the highest-priority element: " + q.peek() + "\n");
		System.out.println("Corretly removing the head element one by one with the poll() method - "
				+ "\nThe elements are sorted in a natural ordering of compareTo method from Comparable interface: ");
		while(q.size()>0){
			System.out.println(q.poll() + "\n");
		}
		
		//queue is empty now:
		System.out.println(q.peek() + "\n");
		
		// add again to a new queue the queue will insert the elements in sorted order again		
		// initialize the queue with a Comparator that will sort them according to the element's length
		System.out.println("Sorting by the element's length using the specified custom Comparator:\n");
		Queue<String> q1 = new PriorityQueue<String>(new CompareBySize());
		q1.offer("hi");
		q1.offer("ala");
		q1.offer("zoon");
		q1.offer("kater");
		
		while(q1.size()>0){
			System.out.println(q1.poll() + "\n");
		}
		
			
	}
}

class CompareBySize implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		
		return s1.length() - s2.length();
	}
	
	
}
