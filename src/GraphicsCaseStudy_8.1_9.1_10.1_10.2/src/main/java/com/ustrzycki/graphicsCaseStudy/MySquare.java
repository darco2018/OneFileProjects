package com.ustrzycki.graphicsCaseStudy;

import java.awt.Color;

public class MySquare extends MyRectangle{
	
	public MySquare()
	{
		super();
	}
	
	public MySquare(int x1, int y1, int x2, int y2, Color color, boolean isFilled)
	{
		super(x1, y1, x2, y2, color, isFilled);		
		
		if( getWidth() != getHeight())
			throw new IllegalArgumentException("A square's width must be equal to its height!");
	}
}


