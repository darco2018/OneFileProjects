package com.ustrzycki.graphicsCaseStudy;

import java.awt.Color;
import java.awt.Graphics;

//public class MyShape {
public abstract class MyShape {
	
	private int x1; 
	private int y1; 
	private int x2;
	private int y2;	
	private Color color;
	
	public MyShape()
	{
		this.x1 = 0;
		this.y1 = 0;
		this.x2 = 0;
		this.y2 = 0;
		this.color = Color.BLACK;
	}

	public MyShape(int x1, int y1, int x2, int y2, Color color) 
	{
		setUpperLeftX1(Math.min(x1, x2));
		setUpperLeftY1(Math.min(y1, y2));
		setX2(Math.max(x1, x2));
		setY2(Math.max(y1, y2));
		setColor(color);		
	}

	/**
	 * @return the upperLeftX1
	 */
	public int getUpperLeftX1() {
		return x1;
	}

	/**
	 * @param upperLeftX1 the upperLeftX1 to set
	 */
	public void setUpperLeftX1(int x1) {		
		this.x1 = Math.max(x1, 0); // upperLeftX1 must be greater than or equal to 0.
													// If it's not, it is set to 0
	}

	/**
	 * @return the upperLeftY1
	 */
	public int getUpperLeftY1() {
		return y1;
	}

	/**
	 * @param upperLeftY1 the upperLeftY1 to set
	 */
	public void setUpperLeftY1(int y1) {
		this.y1 = Math.max(y1, 0); // upperLeftY1 must be greater than or equal to 0.
													// If it's not, it is set to 0
	}

	/**
	 * @return the x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * @param x2 the x2 to set
	 */
	public void setX2(int x2) {
		this.x2 = Math.max(x2, 0); // x2 must be greater than or equal to 0.
								   // If it's not, it is set to 0
	}

	/**
	 * @return the y2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * @param y2 the y2 to set
	 */
	public void setY2(int y2) {
		this.y2 = Math.max(y2, 0); // y2 must be greater than or equal to 0.
		   						  // If it's not, it is set to 0
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	
	@Override
	public String toString()
	{	return String.format("%s, %d, %d, %d, %d, %s", getClass().getSimpleName(), 
			getUpperLeftX1(), getUpperLeftY1(), getX2(), getY2(), getColor());
	}
}
