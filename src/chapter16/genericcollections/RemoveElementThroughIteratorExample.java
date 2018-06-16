package chapter16.genericcollections;

/*
Remove an element from Collection using Java Iterator Example
This Java Example shows how to remove an element from underlying Collection using
Java Iterator's remove method.
*/

import java.util.Iterator;
import java.util.ArrayList;

public class RemoveElementThroughIteratorExample {

public static void main(String[] args) {
	
  ArrayList aList = new ArrayList();
  
  aList.add("1");
  aList.add("2");
  aList.add("3");
  aList.add("4");
  aList.add("5");
 
 
  System.out.println("ArrayList before removal : ");
  for(int i=0; i< aList.size(); i++)
    System.out.println(aList.get(i));
 
  //remove "2" from ArrayList using Iterator's remove method.
  Iterator itr = aList.iterator();
  String strElement = "";
  
  while(itr.hasNext()){
	  /*  Iterator's next method returns an Object so we need to cast it into
      appropriate class before using it.*/    
    strElement = (String)itr.next(); // you must call next() before you call remove()
    if(strElement.equals("2"))
    {
      /* Remove method removes an element from underlying collection and
        it may throw a UnsupportedOperationException if the remove
        operation is not supported.*/
      itr.remove();
      break;
    }
  }
 
  System.out.println("ArrayList after removal : ");
  for(int i=0; i< aList.size(); i++)
    System.out.println(aList.get(i));

}
}

