// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

public class PayrollSystemTest 
{
   public static void main(String[] args) 
   {
	   
      
      // create four-element Employee array
      Employee[] employees = new Employee[5]; 

      // initialize array with Employees
      Date date1 = new Date(8, 18, 1980);
      employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111", date1, 800.00);
      Date date2 = new Date(2, 29, 1980);
      employees[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", date2, 16.75, 40);
      Date date3 = new Date(3, 31, 1980);
      employees[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", date3, 10000, .06);
      Date date4 = new Date(4, 30, 1980);
      employees[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", date4, 5000, .04, 300);
      Date date5 = new Date(5, 16, 1967);
      employees[4] = new Pieceworker("Dariusz", "Raciborski", "333-33-3333", date5, 50, 5);

      System.out.printf("Employees processed polymorphically:%n%n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) 
      {
         System.out.println(currentEmployee); // invokes toString
         System.out.printf("earned $%,.2f%n%n", currentEmployee.getPaymentAmount());
      } 
      
      for (int month = 1; month <= 12; month++)
      {
    	  Date payday = new Date(month, 1, 2014);
    	  System.out.printf("%s%s%n","Payday: ", payday );
    	  
    	  
    	  
    	  for(Employee currentEmployee : employees)
    	  {
    		  System.out.printf("%s %s, %s $%.2f", currentEmployee.getFirstName(), currentEmployee.getLastName(),
    		  		"earned: ", currentEmployee.getPaymentAmount());	
    		  
    		  if(currentEmployee.getBirthdate().getMonth() == payday.getMonth())
    		  {
    			  System.out.printf(", plus bonus $100.00 for being born in the month: %d", 
    					  currentEmployee.getBirthdate().getMonth());
    		  }
    		  
    		  System.out.println();
    	  }
    	  
    	  System.out.println();
      }
      

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++)
         System.out.printf("Employee %d is a %s%n", j, 
            employees[j].getClass().getName()); 
   } // end main
} // end class PayrollSystemTest

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

//create subclass objects
/*SalariedEmployee salariedEmployee = 
   new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
HourlyEmployee hourlyEmployee = 
   new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
CommissionEmployee commissionEmployee = 
   new CommissionEmployee(
   "Sue", "Jones", "333-33-3333", 10000, .06);
BasePlusCommissionEmployee basePlusCommissionEmployee = 
   new BasePlusCommissionEmployee(
   "Bob", "Lewis", "444-44-4444", 5000, .04, 300);
Pieceworker pieceworker = new Pieceworker("Dariusz", "Raciborski", "333-33-3333", 50, 5);
 */

/*// determine whether element is a BasePlusCommissionEmployee
if (currentEmployee instanceof BasePlusCommissionEmployee) 
{
   // downcast Employee reference to 
   // BasePlusCommissionEmployee reference
   BasePlusCommissionEmployee employee = 
      (BasePlusCommissionEmployee) currentEmployee;

   employee.setBaseSalary(1.10 * employee.getBaseSalary());

   System.out.printf(
      "new base salary with 10%% increase is: $%,.2f%n",
      employee.getBaseSalary());
} */