package com.ustrzycki.graphicsCaseStudy;

import java.awt.Color;

public class MyShapeTest {

	public static void main(String[] args) {

		  /* Tests MyShape class kiedy nie jest ona abstract
		MyShape shape1 = new MyShape();
		MyShape shape2 = new MyShape(0,20,30,40, Color.BLUE);
		MyShape shape3 = new MyShape(20,10,40,30, Color.RED);
		MyShape shape4 = new MyShape(20,10,5,7, Color.GREEN);
		MyShape shape5 = new MyShape(50,100,2,300, Color.WHITE);
		MyShape shape6 = new MyShape(-50,-100,-2,-300, Color.WHITE);
		
		System.out.printf("%s%n%s%n%s%n%s%n%s%n%s", shape1, shape2, shape3, shape4, shape5, shape6);
		
		MyShape shape7 = new MyShape();
		shape7.setUpperLeftX1(50);
		shape7.setUpperLeftY1(100);
		shape7.setX2(600);
		shape7.setY2(900);
		shape7.setColor(Color.WHITE);
		System.out.printf("%n%s", shape7);
		
		MyBoundedShape boundedShape1 = new MyBoundedShape(20,10,40,30, Color.RED, true);
		boundedShape1.setIsFilled(false);
		System.out.printf("%n%s", boundedShape1);
		
		MyShape shape8 = new MyBoundedShape();
		MyBoundedShape recastShape = (MyBoundedShape)shape8;
		//System.out.printf("%n%s", (MyBoundedShape)shape8.method()); - ten cast nie dziala !!!
		System.out.printf("%n%s", recastShape);
		
		MyRectangle rec1 = new MyRectangle(50,100,2,300, Color.WHITE, true);
		MyOval oval1 = new MyOval(50,100,2,300, Color.WHITE, false);
		MyLine line1 = new MyLine(50,100,2,300, Color.RED);
		
		System.out.printf("%n%s, %n%s, %n%s", rec1, oval1, line1);
		
		 */
		
		MyRectangle rec1 = new MyRectangle(50,100,2,300, Color.WHITE, true);
		MyOval oval1 = new MyOval(50,100,2,300, Color.BLACK, false);
		MyLine line1 = new MyLine(-50,100,2,300, Color.RED);
		MySquare square1 = new MySquare(10,30,20,40, Color.RED, true);
		MyCircle circle1 = new MyCircle(50,150,100,200, Color.RED, false);
		
		MyShape[] shapes = new MyShape[5];
		shapes[0] = rec1;
		shapes[1] = oval1;
		shapes[2] = line1;
		shapes[3] = square1;
		shapes[4] = circle1;
		
		for(MyShape currentShape : shapes)
		{
			System.out.printf("%n%s", currentShape);
		}
	}
}
