package com.ustrzycki.graphics;

import java.awt.geom.Point2D;

public class Point {
	
	private double x;
	private double y;
	
	public Point(double x, double y)
	{
		if(x < 0 || y < 0)
		{
			throw new IllegalArgumentException("X and Y must be greater than or equal to 0!");
		}
		
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	/* removing these setters makes the Point object immutable
	 * public void setX(double x)
	{
		if(x < 0)
		{
			throw new IllegalArgumentException("X must be greater than or equal to 0!");
		}
		
		this.x = x;
	}
	
	public void setY(double y)
	{
		if(y < 0)
		{
			throw new IllegalArgumentException("X must be greater than or equal to 0!");
		}
		
		this.y = y;
	}*/
	
	
	public static double getDistanceBetweenPoints(double x1, double x2, double y1, double y2)
	{
		return Point2D.distance(x1, y1, x2, y2);
	}
	
	public static double calculateDistanceBetweenPoints(Point from, Point to)
	{
		return Point2D.distance(from.getX(), from.getY(), to.getX(), to.getY());
	}
	

}
