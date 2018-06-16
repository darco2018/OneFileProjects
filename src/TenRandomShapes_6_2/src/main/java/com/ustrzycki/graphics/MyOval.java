package com.ustrzycki.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyShape2D{

	public MyOval(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
	}
	
	
	// Draw the oval in the specified color
	@Override
	public void draw(Graphics g){
		
		g.setColor(getColor());
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
	
	// Fill the oval in the specified color
	@Override
	public void fill(Graphics g){
		
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}

}
