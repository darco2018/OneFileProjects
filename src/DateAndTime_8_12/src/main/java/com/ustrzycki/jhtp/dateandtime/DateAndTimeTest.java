package com.ustrzycki.jhtp.dateandtime;

public class DateAndTimeTest
{
	public static void main(String[] args)
	{
		Date date1 = new Date(12, 29, 2015);
		DateAndTime d1 = new DateAndTime(23, 59, 59, date1);
		System.out.println(d1.toString());
		System.out.println(d1.toUniversalString());
		
		d1.incrementHour();
		System.out.println("Time and date after incrementHour(): " );
		System.out.println(d1.toString());
		System.out.println(d1.toUniversalString());
		System.out.println();
		
		System.out.println("New date and time: " );
		Date date2 = new Date(12, 31, 2015);
		DateAndTime d2 = new DateAndTime(23, 59, 59, date2);
		System.out.println(d2.toString());
		System.out.println(d2.toUniversalString());
		
		d2.incrementMinute();
		System.out.println("Time and date after incrementMinute(): " );
		System.out.println(d2.toString());
		System.out.println(d2.toUniversalString());
		System.out.println();
		
		System.out.println("New date and time: " );
		Date date3 = new Date(2, 29, 2016);
		DateAndTime d3 = new DateAndTime(23, 59, 59, date3);
		System.out.println(d3.toString());
		System.out.println(d3.toUniversalString());
		
		d3.tick();
		System.out.println("Time and date after tick(): " );
		System.out.println(d3.toString());
		System.out.println(d3.toUniversalString());
	}
	
} // end class 
