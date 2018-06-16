/*Here’s another weird case I came across two times in my developer life. 
Once a couple of years ago while developing a PHP application, and once 
a few weeks ago in a Java application. If you try to run the example below 
you’ll get a StackOverflowError.*/



public class InheritanceOverflow {

  public static class Parent {

    public void foo() 
    {    	
      bar();
    }

    public void bar() 
    {    	
    }
  }

  public static class Child extends Parent {
	  
	  public static void main(String[] args) 
	  {
		    new Child().bar();
	  }
    
	@Override
    public void bar() {
      // I have no idea that foo in Parent is actually calling bar, that calls
      // this method, which will call foo againg, and so on. Infinite recursion.
      foo();
    }
  }
  

/*If, for whatever reason, you decide you want your class to be inherited, 
then make sure overridable methods don’t call other overridable methods. 
Have them use either private helper methods, or make those helper methods final 
if you want to allow more relaxed visibility rules.*/

/*public class InheritanceOverflowRevisited {

  public static class Parent {

    public void foo() {
      barHelper();
    }

    public void bar() {
      barHelper();
    }
    
    private void barHelper() {
      // do bar stuff
    }
  }

  public static class Child extends Parent {
    @Override
    public void bar() {
      foo(); // no more StackOverflowError
    }
  }

  public static void main(String[] args) {
    new Child().bar();
  }
}*/

  
}