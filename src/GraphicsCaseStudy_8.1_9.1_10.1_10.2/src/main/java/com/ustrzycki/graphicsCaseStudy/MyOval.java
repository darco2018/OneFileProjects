package com.ustrzycki.graphicsCaseStudy;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape{
	
	public MyOval()
	{
		super();
	}
	
	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean isFilled)
	{
		super(x1, y1, x2, y2, color, isFilled);				
	}
	
	@Override
	public void draw(Graphics g)
	{
		g.setColor(getColor());
		
		if(getIsFilled() == true)
			g.fillOval(getUpperLeftX1(), getUpperLeftY1(), getWidth(), getHeight());
		else
			g.drawOval(getUpperLeftX1(), getUpperLeftY1(), getWidth(), getHeight());
	}

}
