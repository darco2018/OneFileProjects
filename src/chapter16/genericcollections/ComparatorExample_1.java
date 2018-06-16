package chapter16.genericcollections;

import java.util.*;
	

	class Dog implements Comparator<Dog>, Comparable<Dog>{
	   private String name;
	   private int age;
	   Dog(){}

	   Dog(String n, int a){
	      name = n;
	      age = a;
	   }

	   public String getDogName(){
	      return name;
	   }

	   public int getDogAge(){
	      return age;
	   }
	   
	   /*Comparable
	   A comparable object is capable of comparing itself with another object. The class itself must 
	   implements the java.lang.Comparable interface in order to be able to compare its instances.
	   Lots of classes implement it, eg String, Time, BigDecimal,Integer, Double, Character, etc.
	   When you run your own class you can define in a given class compareTo(MyClass c) method (eg decide that natural ordering
	   for an Employee will be by id rather than name or age)
	   
	   If we need to sort using other fields of the employee, we’ll have to change the Employee class’s compareTo() method 
	   to use those fields. But then we’ll loose this empId based sorting mechanism. This is not a good alternative 
	   if we need to sort using different fields at different occasions. But no need to worry; Comparator is there to save us.
	   
Following EmpSortByName class is used to sort Employee instances according to the name field. In this class, inside the compare() method 
sorting mechanism is implemented. In compare() method we get two Employee instances and we have to return which object is greater.

public class EmpSortByName implements Comparator<Employee>{

	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

List coll = Util.getEmployees(); 
Collections.sort(coll, new EmpSortByName());

Even the ordering by empId (previously done using Comparable) can be implemented using Comparator; following class
does that.

public class EmpSortByEmpId implements Comparator<Employee>{

public int compare(Employee o1, Employee o2) {
return o1.getEmpId() - o2.getEmpId();
}
}

Explore further
Do not stop here. Work on the followings by yourselves and sharpen knowledge on these concepts.

    Sort employees using name, age, empId in this order (ie: when names are equal, try age and then next empId)
    Explore how & why equals() method and compare()/compareTo() methods must be consistent.
	   Comparator
	   A comparator object is capable of comparing two different objects. The class is not comparing its instances, 
	   but some other class’s instances. This comparator class must implement the java.util.Comparator interface. */
	   
// The type Dog must implement the inherited abstract method Comparable<Dog>.compareTo(Dog
	   // Overriding the compareTo method
	   public int compareTo(Dog d){
	      return (this.name).compareTo(d.name); // using the String implementation of compareTo(String anotherString)
	   }
/*
	   @FunctionalInterface
	   public interface Comparator<T>

		A comparison function, which imposes a total ordering on some collection of objects. Comparators
	   can be passed to a sort method (such as Collections.sort or Arrays.sort) to allow precise control over the sort order. 
	   Comparators can also be used to control the order of certain data structures 
	   (such as sorted sets or sorted maps), or to provide an ordering for collections of objects that 
	   don't have a natural ordering.
*/	
	   
// The type Dog must implement the inherited abstract method Comparator<Dog>.compare(Dog, Dog)
	   // Overriding the compare method to sort the age 
	   public int compare(Dog d, Dog d1){
	      return d.age - d1.age;
	   }
	}

	public class ComparatorExample_1{

	   public static void main(String args[]){
	      // Takes a list o Dog objects
	      List<Dog> list = new ArrayList<Dog>();

	      list.add(new Dog("Shaggy",3));
	      list.add(new Dog("Lacy",2));
	      list.add(new Dog("Roger",10));
	      list.add(new Dog("Tommy",4));
	      list.add(new Dog("Tammy",1));
	      Collections.sort(list);// Sorts the array list; this method works on objects that implement Comparable interface

	      for(Dog a: list)//printing the sorted list of names
	         System.out.print(a.getDogName() + ", ");

	      // Sorts the array list using comparator; now it uses compare(Dog d, Dog d1) of the provided Comparator interface
	      // rather than compareTo(Dog d)of the Comparable interface
	      Collections.sort(list, new Dog());
	      System.out.println(" ");
	      for(Dog a: list)//printing the sorted list of ages
	         System.out.print(a.getDogName() +"  : "+
			 a.getDogAge() + ", ");
	   }
	}


