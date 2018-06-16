/**
 * 
 */
package com.ustrzycki.graphicsCaseStudy;

import java.awt.Color;

/**
 * @author dar
 *
 */
//public class MyBoundedShape extends MyShape
public abstract class MyBoundedShape extends MyShape
{
	private boolean isFilled;
	
	public MyBoundedShape()
	{
		super();
		this.isFilled = false;
	}
	
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean isFilled)
	{
		super(x1, y1, x2, y2, color);
		this.isFilled = isFilled;		
	}
	
	public void setIsFilled(boolean isFilled){
		this.isFilled = isFilled;
	}
	
	public boolean getIsFilled(){
		return isFilled;
	}
	
	public int getWidth()
	{
		return Math.abs(getX2() - getUpperLeftX1());
	}
	
	public int getHeight()
	{
		return Math.abs(getY2() - getUpperLeftY1());
	}
	
	@Override
	public String toString()
	{	return String.format("%s, width: %s, height: %s, filled: %b", super.toString(), 
								getWidth(), getHeight(), getIsFilled());
	}
}
