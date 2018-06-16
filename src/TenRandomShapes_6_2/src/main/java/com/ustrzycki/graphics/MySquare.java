package com.ustrzycki.graphics;

import java.awt.Color;

public class MySquare extends MyRectangle{

	public MySquare(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
		
		if( x != y)
			throw new IllegalArgumentException("x must be equal to y");
	}

}
