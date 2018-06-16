package com.ustrzycki.jhtp.dateandtime;


public class DateAndTime
{
	private final static int SECONDS_IN_1_MINUTE = 60;
	private final static int SECONDS_IN_1_HOUR = 3600;
	private final static int SECONDS_IN_24_HOURS = 86400;
	
	private int totalSeconds; // 0 - ... time represented as seconds since midnight
	private Date date;
	
public DateAndTime(Date date)
{
   this(0, 0, 0, date); 
} 

public DateAndTime(int hour, Date date) 
{ 
   this(hour, 0, 0, date); 
} 

public DateAndTime(int hour, int minute, Date date) 
{ 
   this(hour, minute, 0, date); 
} 

public DateAndTime(int hour, int minute, int second, Date date) 
{ 
   if (hour < 0 || hour >= 24)
      throw new IllegalArgumentException("hour must be 0-23");

   if (minute < 0 || minute >= 60)
      throw new IllegalArgumentException("minute must be 0-59");

   if (second < 0 || second >= 60)
      throw new IllegalArgumentException("second must be 0-59");

   totalSeconds = (hour * SECONDS_IN_1_HOUR) + (minute * SECONDS_IN_1_MINUTE) + second;
   this.date = date;
} 

// DateAndTime constructor: another DateAndTime object supplied
public DateAndTime(DateAndTime dateAndTime)
{
   this(dateAndTime.getHour(), dateAndTime.getMinute(), dateAndTime.getSecond(),
		   dateAndTime.getDate());
} 

// Set Methods
// set a new time value using universal time; 
// validate the data
public void setTime(int hour, int minute, int second)
{
   if (hour < 0 || hour >= 24)
      throw new IllegalArgumentException("hour must be 0-23");

   if (minute < 0 || minute >= 60)
      throw new IllegalArgumentException("minute must be 0-59");

   if (second < 0 || second >= 60)
      throw new IllegalArgumentException("second must be 0-59");

   totalSeconds = (hour * SECONDS_IN_1_HOUR) + (minute * SECONDS_IN_1_MINUTE) + second;
} 

// validate and set hour 
public void setHour(int hour) 
{ 
   if (hour < 0 || hour >= 24)
      throw new IllegalArgumentException("hour must be 0-23");

   totalSeconds += hour * SECONDS_IN_1_HOUR;
} 

// validate and set minute 
public void setMinute(int minute) 
{ 
   if (minute < 0 || minute >= 60)
      throw new IllegalArgumentException("minute must be 0-59");

   totalSeconds +=  minute * SECONDS_IN_1_MINUTE; 
} 

// validate and set second 
public void setSecond(int second) 
{ 
   if (second < 0 || second >= 60)
      throw new IllegalArgumentException("second must be 0-59");

   totalSeconds += second; 
} 

// Get Methods
// get hour value
public int getHour() 
{ 
   return totalSeconds / SECONDS_IN_1_HOUR; 
} 

// get minute value
public int getMinute() 
{ 
   return (totalSeconds - (getHour() * SECONDS_IN_1_HOUR)) //subtract hour seconds
 		  / SECONDS_IN_1_MINUTE;  
} 

// get second value
public int getSecond() 
{ 
   return   totalSeconds 
 		   - (getHour() * SECONDS_IN_1_HOUR) // subtract the 'hour' seconds
 		   - (getMinute() * SECONDS_IN_1_MINUTE); // subtract the 'minute' seconds
} 

public Date getDate()
{
	return date;
}

// convert to String in universal-time format (HH:MM:SS)
public String toUniversalString()
{
   return String.format(
      "%02d:%02d:%02d    %s", getHour(), getMinute(), getSecond(),
      getDate() == null ? "" : getDate().toString());
} 

// convert to String in standard-time format (H:MM:SS AM or PM)
public String toString()
{
   return String.format("%d:%02d:%02d %s %s", 
      ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
      getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"), 
      getDate() == null ? "" : getDate().toString());
} 

public int getTotalSeconds()
{
	   return totalSeconds;
}

public void tick()
{
	   totalSeconds += 1;	   
	   keepSecondsWithin24Hours();
} 

public void incrementMinute()
{
	   totalSeconds += SECONDS_IN_1_MINUTE;	   
	   keepSecondsWithin24Hours();
} 

public void incrementHour()
{
	   totalSeconds += SECONDS_IN_1_HOUR;	 
	   keepSecondsWithin24Hours();
} 
// makes sure the total seconds aren't larger than the number of seconds in 24 hours
// increment day by 1
private void keepSecondsWithin24Hours()
{
	if(totalSeconds >= SECONDS_IN_24_HOURS)
	{
		totalSeconds -= SECONDS_IN_24_HOURS;
		date.nextDay();
	}
}
} // end class Time
