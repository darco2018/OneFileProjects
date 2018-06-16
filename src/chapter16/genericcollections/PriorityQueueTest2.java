package chapter16.genericcollections;
import java.util.PriorityQueue;

public class PriorityQueueTest2 {

	public static void main(String[] args) {

		PriorityQueue<Double> pQueue = new PriorityQueue<>();
		
				
		pQueue.add(48.5);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		pQueue.add(19.4);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		pQueue.add(6.5);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		
		for (Double number : pQueue) {
			   System.out.printf("%f    ", number);
		}
		pQueue.add(99.4);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		
		for (Double number : pQueue) {
			   System.out.printf("%f    ", number);
		}
		pQueue.add(50.5);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		pQueue.add(17.5);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		pQueue.add(14.5);
		System.out.printf("Peek the head: %f%n", pQueue.peek());
		
		for (Double number : pQueue) {
			   System.out.printf("%f    ", number);
		}
		
		System.out.printf("%n");

		
		while (!pQueue.isEmpty()) {
			System.out.printf("Peek the head: %f%n", pQueue.peek());
			System.out.printf("Remove the head: %f%n%n", pQueue.poll());			
		}
		
		
	}

}
