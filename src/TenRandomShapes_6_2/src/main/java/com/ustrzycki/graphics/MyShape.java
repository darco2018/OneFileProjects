package com.ustrzycki.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class MyShape {
	
	private int x; // top-left coordinate
	private int y; // top-left coordinate
	private int width;
	private int height;	
	private Color color;
	
	public MyShape(int x, int y, int width, int height, Color color)
	{
		if ( x < 0 || y < 0)
			throw new IllegalArgumentException("x and y coordinates must be greater than or equal to 0");
		
		if (width <= 0 || height <= 0)
			throw new IllegalArgumentException("Width and height must be greater than 0");
			
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;		
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
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
	
	
	public void draw(Graphics g){		
		
	}
	
	public void fill(Graphics g){		
		
	}
	
	
		
	
	

}
