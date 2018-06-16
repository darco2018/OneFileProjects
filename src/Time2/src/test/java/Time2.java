// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.  

public class Time2
{
	private final static int SECONDS_IN_1_MINUTE = 60;
	private final static int SECONDS_IN_1_HOUR = 3600;
	private final static int SECONDS_IN_24_HOURS = 86400;
	
	private int totalSeconds; // 0 - ... time represented as seconds since midnight
	
   // Time2 no-argument constructor: 
   // initializes each instance variable to zero
   public Time2()
   {
      this(0, 0, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2(int hour) 
   { 
      this(hour, 0, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2(int hour, int minute) 
   { 
      this(hour, minute, 0); // invoke constructor with three arguments
   } 

   // Time2 constructor: hour, minute and second supplied
   public Time2(int hour, int minute, int second) 
   { 
      if (hour < 0 || hour >= 24)
         throw new IllegalArgumentException("hour must be 0-23");

      if (minute < 0 || minute >= 60)
         throw new IllegalArgumentException("minute must be 0-59");

      if (second < 0 || second >= 60)
         throw new IllegalArgumentException("second must be 0-59");

      totalSeconds = (hour * SECONDS_IN_1_HOUR) + (minute * SECONDS_IN_1_MINUTE) + second;
   } 

   // Time2 constructor: another Time2 object supplied
   public Time2(Time2 time)
   {
      // invoke constructor with three arguments
      this(time.getHour(), time.getMinute(), time.getSecond());
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

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format(
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
   } 

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return String.format("%d:%02d:%02d %s", 
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
   } 
   
   public int getTotalSeconds()
   {
	   return totalSeconds;
   }
   
   public void tick()
   {
	   totalSeconds += 1;
	   
	   if(totalSeconds >= SECONDS_IN_24_HOURS)
	   {
		   totalSeconds -= SECONDS_IN_24_HOURS;
	   }
   } 
   
   public void incrementMinute()
   {
	   totalSeconds += SECONDS_IN_1_MINUTE;
	   
	   if(totalSeconds >= SECONDS_IN_24_HOURS)
	   {
		   totalSeconds -= SECONDS_IN_24_HOURS;
	   }
   } 
   
   public void incrementHour()
   {
	   totalSeconds += SECONDS_IN_1_HOUR;
	   
	   if(totalSeconds >= SECONDS_IN_24_HOURS)
	   {
		   totalSeconds -= SECONDS_IN_24_HOURS;
	   }
   } 
} // end class Time2
