package com.ustrzycki.graphics;


public class Square extends Rectangle{
	
	// ab is the width
	// bc is the height
	
	public Square(Point a, Point b, Point c, Point d)
	{
		super(a, b, c, d);
		
		if ( Point.calculateDistanceBetweenPoints(getA(), getB()) != 
				Point.calculateDistanceBetweenPoints(getB(), getC()) )
		{
			throw new IllegalArgumentException("The side AB must be equal to the side BC!");
		}
	}
	
	public double calculateArea()
	{		
		return Math.pow(Point.calculateDistanceBetweenPoints(getA(), getB()), 2);
	}
	
}