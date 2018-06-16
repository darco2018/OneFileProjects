
public class DateTest {

	public static void main(String[] args) {

		Date d1 = new Date(4, 1, 2015);
		d1.toString();
		d1.nextDay();
		System.out.println("After nextDay() is called: " + d1);
		System.out.println();
		
		Date d2 = new Date(2, 28, 2015);
		d2.toString();
		d2.nextDay();
		System.out.println("After nextDay() is called: " + d2);
		System.out.println();
		
		Date d3 = new Date(2, 28, 2016);
		d3.toString();
		d3.nextDay();
		System.out.println("After nextDay() is called: " + d3);
		System.out.println();
		
		Date d3b = new Date(2, 29, 2016);
		d3b.toString();
		d3b.nextDay();
		System.out.println("After nextDay() is called: " + d3b);
		System.out.println();
		
		Date d4 = new Date(2, 29, 2016);
		d4.toString();
		d4.nextDay();
		System.out.println("After nextDay() is called: " + d4);
		System.out.println();
		
		Date d5 = new Date(12, 30, 2016);
		d5.toString();
		d5.nextDay();
		System.out.println("After nextDay() is called: " + d5);
		System.out.println();
		
		Date d6 = new Date(12, 31, 2016);
		d6.toString();
		d6.nextDay();
		System.out.println("After nextDay() is called: " + d6);
		System.out.println();
		
		Date d7 = new Date(12, 27, 2014);
		
		for (int c = 1; c < 450; c++)
		{
			d7.nextDay();
			System.out.println(d7);
		}

	}

}
