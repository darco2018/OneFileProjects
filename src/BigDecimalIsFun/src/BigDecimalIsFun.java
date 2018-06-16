import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalIsFun {

	public static void main(String[] args) {
		
		// create 3 BigDecimal objects
        BigDecimal bg1, bg2, bg3, number1, number0, divisionResult;

        bg1 = new BigDecimal("3.5");
        bg2 = new BigDecimal("1.75");
        number1 = BigDecimal.valueOf(3.5);
        number0 = BigDecimal.valueOf(1.75);
		

        // divide bg1 with bg2 with 3 scale
	bg3 = bg1.divide(bg2, 3, RoundingMode.HALF_EVEN);
	divisionResult = number0.divide(number1, 3, RoundingMode.HALF_EVEN);

        String str = "Division result is " + bg3;
        String str3 = "Division result is " + divisionResult;

	// print bg3 value
	System.out.println( str );
	System.out.println( str3 );
	System.out.println();
	System.out.println();
	
	NumberFormat polishLocale = NumberFormat.getCurrencyInstance();
	
	
	System.out.println( NumberFormat.getCurrencyInstance(Locale.UK).format(divisionResult));
	System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(divisionResult));
	System.out.println(NumberFormat.getCurrencyInstance().format(divisionResult));
	
	System.out.println();
	System.out.println();
		
		
		BigDecimal number2 = BigDecimal.valueOf(4.34111);
		BigDecimal number3 = BigDecimal.valueOf(4.34777);
		BigDecimal number4 = new BigDecimal("123.12556");
		int scale = number4.scale();
		System.out.println("Scale of number 123.12556 is " + scale );
		System.out.println("BigDecimal 123.12556 toString() " + number4.toString() );
		
		
		System.out.printf("%nDividing %s by %s yields %s", number1, number0, 
				divisionResult.doubleValue()				
		);
		
		
		//BigDecimal total = number1 + number2;
		BigDecimal numberRescaled = number2.setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(numberRescaled);
		System.out.println(number3);
		
		////////////////////////////////////////////////
		// create 2 BigDecimal Objects
        BigDecimal bg10;
        BigDecimal bg20;

        bg10 = new BigDecimal("123.12556");

	// set scale of bg1 to 2 in bg2 using floor as rounding mode
        bg20 = bg10.setScale(2, RoundingMode.HALF_EVEN);

	String str2 = bg10 + " after changing the scale to 2 and rounding is " + bg20;

	// print bg2 value
        System.out.println( str2 );

	}

}
