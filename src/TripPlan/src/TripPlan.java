//Complete the class TripPlan which describes the cities that are visited by a tour conducted
//by Java Now Tours. Keep an arraylist of cities (just the string name). Have methods to add a 
//city, remove a city, to return the names of the cities in a String, and to reverse the order 
//of the elements in the array list.

//Notice that the reverse method is void.

// Need help starting this question? In the lesson titled 
// "Starting points: Problem Set Questions", go to the
// problem titled "Problem Set 6 - Question 2" for some tips on 
// how to begin.

import java.util.ArrayList;

/**
 * A TripPlan represents a trip and holds a collection of city names.
 */
public class TripPlan
{
    ArrayList<String> cities; 

    /**
     * Constructs an empty trip.
     */
    public TripPlan()
    {
    	this.cities = new ArrayList<String>();
    }

    /**
     * Add a city to the list.
     * @param cityName the city to add
     */
    public void addCity(String cityName)
    {
    	cities.add(cityName);
    }

    /**
     * Returns a string describing the object.
     * @return a string in the format "TripPlan[cityName1,cityName2,...]"
     */
    public String toString()
    {
    	String noSpacesString = cities.toString();
    	//noSpacesString.replace(" ", "");
    	
        return "TripPlan" + noSpacesString.replace(", ", ",");
    }

    /**
     * Removes a city form the this trip
     * @param cityName city to remove
     */
    public void removeCity(String cityName)
    {
    	int c = 0;
    	
        while (c < cities.size())
        {
        	
        	if  (cities.get(c).equals(cityName))
        	{
        		
        		cities.remove(c);        		
        	}
        	else
        		c++;        		
        }
    }

    /**
     * Reverses the elements in the itinerary.
     */
    public void reverse()
    {
    	//if (cities.size() % 2 == 0)
    	//{
    		int d = 1;
    		
    		for (int c = 0; c < (cities.size() / 2); c++)
    		{
    			String tempFront = cities.get(c);
    			String tempEnd = cities.get(cities.size() - d);
    			
    			cities.set(cities.size() - d, tempFront);
    			cities.set(c, tempEnd);
    			
    			d++;    			
    		}
    	//}
    	
    }
}
