package com.ustrzycki.graphics;

public class MyPoint implements java.lang.Cloneable{
	
	private int x;
	private int y;
	
	public MyPoint(int x, int y) 
	{
		if(x < 0 || y < 0)
		{
			throw new IllegalArgumentException("X and Y must be greater than or equal to 0!");
		}
		
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		if(x < 0)
		{
			throw new IllegalArgumentException("X must be greater than or equal to 0!");
		}
		
		this.x = x;
	}
	
	public void setY(int y)
	{
		if(y < 0)
		{
			throw new IllegalArgumentException("X must be greater than or equal to 0!");
		}
		
		this.y = y;
	}
	
	/*@Override
	public MyPoint clone()
	{
		return new MyPoint(getX(), getY());
	}*/
	
	@Override
	public MyPoint clone()
	{
		try {
			return (MyPoint)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 		
	}
	
	
	@Override
	public String toString()
	{    // oto implementacja toString:  getClass().getName() + '@' + Integer.toHexString(hashCode())
		return "Evoked with super.toString(): \n"  + super.toString() 
				+ "\noto implementacja toString:  getClass().getName() + '@' + Integer.toHexString(hashCode())"
				+ "\n (the unsigned hexadecimal representation of the hash code)"
				+ "\nplus my addition x: " + getX() + " y: " + getY();		
	}	

}
