package com.ustrzycki.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyShape2D {

	
	public MyRectangle(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
	}
	
	// Draw the rectangle in the specified color
	@Override
	public void draw(Graphics g){
		
		g.setColor(getColor());
		g.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
	// Fill the rectangle in the specified color
	@Override
	public void fill(Graphics g){
		
		g.setColor(getColor());		
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}
