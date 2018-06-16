package com.ustrzycki.graphics;

import java.awt.Color;

public class MyCircle extends MyOval {

public MyCircle(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
		
		if( x != y)
			throw new IllegalArgumentException("x must be equal to y");
	}

}
