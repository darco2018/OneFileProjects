package com.ustrzycki.graphics;


public class Rectangle extends Quadrilateral{
	
	// ab is the width
	// bc is the height
	
	public Rectangle(Point a, Point b, Point c, Point d)
	{
		super(a, b, c, d);
	}
	
	public double calculateArea()
	{		
		return Point.calculateDistanceBetweenPoints(getA(), getB()) * 
				Point.calculateDistanceBetweenPoints(getB(), getC());
	}
	
}
