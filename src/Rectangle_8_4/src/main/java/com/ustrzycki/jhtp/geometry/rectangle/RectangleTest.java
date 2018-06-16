package com.ustrzycki.jhtp.geometry.rectangle;

public class RectangleTest {

	public static void main(String[] args) {

		Rectangle_8_4 rec1 = new Rectangle_8_4();
		System.out.printf("Length: %s Width %s%n", rec1.getLength(), rec1.getWidth());
		
		rec1.setLength(2);
		rec1.setWidth(5);
		System.out.printf("Length: %s Width %s%n", rec1.getLength(), rec1.getWidth());
		System.out.printf("Expected perimeter: 14, expected area: 10.%n");
		System.out.printf("Actual perimeter: %s, "
				+ "expected area: %s.%n", 
				rec1.calculatePerimeter(),
				rec1.calculatePerimeter());
		
		System.out.printf("%nSetting a new rectangle with invalid length -2: %n");
		Rectangle_8_4 rec2 = new Rectangle_8_4();
		
		try
		{
			rec2.setLength(-2);
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf("Exception while initializing rec2: %s", e.getMessage());
		}
		
		System.out.printf("%nLength: %s Width %s%n", rec2.getLength(), rec2.getWidth());
		System.out.printf("Calculate perimeter: %f", rec2.calculatePerimeter());
		
		
		System.out.printf("%n%nSetting a new rectangle with invalid width 30: %n");
		Rectangle_8_4 rec3 = new Rectangle_8_4();
		
		try
		{
			rec3.setWidth(30);
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf("Exception while initializing rec3: %s", e.getMessage());
		}
		
		System.out.printf("%nLength: %s Width %s%n", rec3.getLength(), rec3.getWidth());
		System.out.printf("Calculate area: %f",rec3.calculateArea());
		
		
		
	}
}
