// Fig. 3.8: Account.java
import java.math.BigDecimal;

public class Account
{   
   private String name; // instance variable 
   private BigDecimal balance; // instance variable 

   // Account constructor that receives two parameters  
   public Account(String name, double balance) 
   {
      this.name = name; // assign name to instance variable name

      // validate that the balance is greater than 0.0; if it's not,
      //  default it to 0.0
      //if (new BigDecimal(balance).compareTo(BigDecimal.ZERO)== 1) // 1 means first value is greater
      // czy ta oryginalna validacja if (balance > 0.0) nie powinna tez byc jakos zastapiona powyzszą?
      // PIOTREK: Nie. To wychodzi na to samo, a bez tworzenia nowego obiektu.

      if(balance > 0.0)   
    	  this.balance = new BigDecimal(balance); // assign it to instance variable balance
      else
    	  this.balance = BigDecimal.ZERO;
      //ostatnia linijka lepsza od 
      // this.balance = new BigDecimal(BigDecimal.ZERO); bo PIOTREK:
      // objekty klasy BigDecimal (tak jak np. Stringi) sa immutable !!!
      
 
   }

   // method that deposits (adds) only a valid amount to the balance
   public void deposit(double depositAmount) 
   {      
      if (depositAmount > 0.0) // if the depositAmount is valid
         balance = balance.add(new BigDecimal(depositAmount)); // add it to the balance 
   }

   // method returns the account balance
   public BigDecimal getBalance()
   {
      return balance; 
   } 

   // method that sets the name
   public void setName(String name)
   {
      this.name = name; 
   } 

   // method that returns the name
   public String getName()
   {
      return name; 
   } 
} // end class Account

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
