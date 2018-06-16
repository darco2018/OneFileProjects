import java.util.Scanner;

public class DisplaySquareOfAsterisks {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
        System.out.print("Enter the side of the square: ");
        int side = input.nextInt();
        
        System.out.print("Enter the character you want to use for your square: ");
        char fillCharacter = input.next().charAt(0); //Returns the char value at the specified index. 
        
        squareOfAsterisks(side, fillCharacter);
                  
        }
        
        public static void squareOfAsterisks(int side, char fillCharacter)
        {
        	  int row = 1; 
              int column = 1;
                            
                    
              while (row <= side)
              {
                  if (row == 1 || row == side)// this is what you do for 1st and last row
                  {
                      while (column <= side) 
                      {
                          System.out.print(fillCharacter);
                          column++;
                      }
                  }            
                  else // This is what you do for a regular row
                  {            
                      while (column <= side) 
                      {
                          if (column == 1 || column == side)
                          {
                              System.out.print(fillCharacter);
                          }
                          else
                          {
                              System.out.print(" ");
                          }
                                              
                          column++;
                      }   
                  }
                  
                  System.out.println("");
                  column = 1;            
                  row++;
        	
        }
        

	}

}
