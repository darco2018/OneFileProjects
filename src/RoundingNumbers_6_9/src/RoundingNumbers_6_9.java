/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dar
 */
public class RoundingNumbers_6_9 {

    private static java.util.Scanner keyboard;

	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        keyboard = new java.util.Scanner(System.in);
        
        System.out.print("Enter a floating-point number or Ctrl <z> to quit: ");
        
        while(keyboard.hasNext()) 
        {
        	double x = keyboard.nextDouble();
            
            System.out.printf("The original number is %.2f%n", x);
            System.out.printf("The nearest integer is %.2f%n", roundToNearestInt(x)); 
            System.out.print("Enter a floating-point number or Ctrl <z> to quit: ");
        }          
       
        System.out.printf("%nNo double entered. Restart the program.");
        keyboard.close();
    }
    
    public static double roundToNearestInt(double x)
        {
            return Math.floor(x + 0.5);
        }
    
}
