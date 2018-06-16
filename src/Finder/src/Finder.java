// Complete the method in this class to return the first string that starts
// with the target. Return null if no string starts with the target.

import java.util.ArrayList;

public class Finder
{
	
    /**
     * Gets the index of the first String that starts with the target
     * @param text the array list to process
     * @param target the desired letter
     * @return the index of first string starting with target or -1 if not found
     */
     public String getIndex(ArrayList<String> text, String target)
     {
         int i = 0;
          
         String startsWith = null;
         boolean found = false;
         
         while (!found && i < text.size()) 
         {
             
                 if (text.get(i).substring(0, 1).equals(target))
                 {
                	 startsWith = text.get(i);
                     found = true;
                     break;   //c = text.size();
                 }                         
                 i++;             
         }

         return startsWith;
     }
}
