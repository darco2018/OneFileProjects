import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import pl.kobietydokodu.koty.domain.Kot;

public class IOHelper
{
	static Scanner sc = new Scanner(System.in);
	
	// Reads and validates a date
	public void enterDate()
	{
	//Kot kot = new Kot();
    
    Pattern dateRegex = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    String input;
    do {
        System.out.print("Enter the cat's birth date in this format: RRRR.MM.DD: ");
        input = getUserInput();
        if (dateRegex.matcher(input).matches()) {
        	try {
        		//kot.setDataUrodzenia(sdf.parse(dataUrodzeniaWczytana));
        	} catch (ParseException pe) {
        		System.out.println("Error with the date! Example of correct date: 2014.01.05");
        	}
        }
    } while (); // kot.getDataUrodzenia()==null);
    
    public static String getUserInput() {
        return sc.nextLine().trim();
    }
}
