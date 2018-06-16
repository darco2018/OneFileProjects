import java.util.ArrayList;

public class ArrayListMethods
{
    ArrayList<String> list; //instance variable
    /**
     * Constructor for objects of class ArrayListMethods
     */
    public ArrayListMethods(ArrayList<String> arrayList)
    {
        // initialise instance variables
        list = arrayList;
    }

    /**
     * Determines if the array list is sorted (do not sort)
     * When Strings are sorted, they are in alphabetical order
     * Use the compareTo method to determine which string comes first
     * You can look at the String compareTo method in the Java API
     * @return true if the array list is sorted else false.
     */
    public boolean isSorted()
    {
        boolean sorted = true;
        
        for (int c = 0; c < list.size()-1; c++)
        {  
        	// a positive integer if 1st string lexicographically follows the argument string. 
        	//  zero if the strings are equal; 
        	if (list.get(c).compareTo(list.get(c+1)) > 0)
        	{
        		sorted = false;
        		break;         		
        	}       	
        }

        // TODO: Determine if the array is sorted.

        return sorted;
    }

    /**
     * Replaces all but the first and last elements with the larger of its two neighbors
     * You can use the compareTo() method to determine which string is larger (larger in alphabetical
     * order).
     * Example: if the list is originally
     *    ["cat", "ape", "dog", "horse", "zebra"]
     * after this method it should be: 
     *    ["cat", "dog", "horse", "zebra", "zebra"]
     */
    public void replaceWithLargerNeighbor()
    {
    	
    	if (list.size() > 2)
    	{
    		for (int c = 1; c < list.size()- 1; c++)
    		{
    			// a negative integer if 1st string lexicographically precedes the argument string. 
    	    	//  zero if the strings are equal; 
    	    	if (list.get(c-1).compareTo(list.get(c+1)) > 0)
    	    	{
    	    		list.set(c, list.get(c-1));    	    		
    	    	}
    	    	else
    	    	{
    	    		list.set(c, list.get(c+1)); 
    	    	}
    		}
    	}
    }

    /**
     * Gets the number of duplicates in the list.
     * Be careful to only count each duplicate once. Start at index 0. (Does it match any of the other elements?)
     * Get the next word. It is at index i. (Does it match any of the words with index > i?)
     * @return the number of duplicate words in the list
     */
    public int countDuplicates()
    {
    	int duplicates = 0;
        ArrayList<String> copyOfList = new ArrayList<String>(list);    //list;
        
        
        for (int c = 0; c < copyOfList.size(); c++)
        {
            int d = c + 1;

            while (d < copyOfList.size() )
            {
            	System.out.println(copyOfList.get(c) + " <c  d> " + copyOfList.get(d));
            	
                if ( copyOfList.get(c).equals(copyOfList.get(d)) )
                {
                	copyOfList.remove(copyOfList.get(d));                     
                    duplicates++;
                }
                else
                    d++;
            }
        }

        return duplicates;
    }

     /**
     * Moves any word that starts with x, y, or z to the front of the ArrayList, but
     * otherwise preserves the order
     * Example: if the list is orginially
     *   ["ape", "dog", "xantus", "zebra", "cat", "yak"]
     * after this method is called it should be
     *   ["xantus", "zebra", "yak", "ape", "dog", "cat"]
     */
    public void xyzToFront()
    {
        int insertAt = 0;
        String stringToCompareWith = "xyz"; 

        // TODO:  Move any word that starts with x, y, or z to the front of the ArrayList, but otherwise preserves the order
        for (int c = 0; c < list.size(); c++)
        {
        	String word = list.get(c);
        	
        	if ( stringToCompareWith.contains(word.substring(0, 1))  )
        	{
        		list.add(insertAt, list.remove(c));
        		insertAt++;
        	}
        }
        
    }

    /**
     * gets the string representation of this array list
     * @returns the string representation of this array list in
     * standard collection format
     */
    public String toString()
    {
        return list.toString();
    }
}
