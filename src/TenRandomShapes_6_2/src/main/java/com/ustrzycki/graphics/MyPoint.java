package com.ustrzycki.graphics;

public class MyPoint {
	
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
	

}
