package com.ustrzycki.jhtp.geometry.rectangle;

public class Rectangle_8_4 {
	
	private double length = 1.0;
	private double width = 1.0;
	
	public void setLength(double length)
	{
		if (length <= 0.0 || length >= 20.0)		
			throw new IllegalArgumentException("The length " + length + " is not a float > 0.0 and < 20.0 ");
		
		this.length = length;		
	}
	
	public void setWidth(double width)
	{
		if (width <= 0.0 || width >= 20.0)		
			throw new IllegalArgumentException("The width " + width + " is not a float > 0.0 and < 20.0 ");
		
		this.width = width;		
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double calculatePerimeter()
	{
		return 2 * getLength() +  2 * getWidth();
	}
	
	public double calculateArea()
	{
		return getLength() * getWidth();
	}

}
