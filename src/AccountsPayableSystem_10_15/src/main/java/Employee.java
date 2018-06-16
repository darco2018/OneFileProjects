// Fig. 10.4: Employee.java
// Employee abstract superclass.

public abstract class Employee implements Payable
{
   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthdate;

   // constructor
   public Employee(String firstName, String lastName, 
      String socialSecurityNumber, Date birthdate)
   {
      this.firstName = firstName;                                    
      this.lastName = lastName;                                    
      this.socialSecurityNumber = socialSecurityNumber;   
      this.birthdate = birthdate;
   } 

// return first name
   public String getFirstName()
   {
      return firstName;
   } 

   // return last name
   public String getLastName()
   {
      return lastName;
   } 

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } 
   
   /**
    * @return the birthdate
    */
   public Date getBirthdate() {
   	return birthdate;
   }

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%nborn: %s%nsocial security number: %s", 
         getFirstName(), getLastName(), getBirthdate(), getSocialSecurityNumber());
   }



    /*Interface method getPaymentAmount() must be overridden by concrete subclasses
    or the method and class must be declared abstract
    the method is below:
   
    public double getPaymentAmount(){ return 0;}*/
   
} // end abstract class Employee


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