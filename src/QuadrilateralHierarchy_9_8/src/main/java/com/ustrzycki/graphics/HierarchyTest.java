package com.ustrzycki.graphics;

public class HierarchyTest {

	public static void main(String[] args) {
		
		Point a = new Point(0,0);
		Point b = new Point(0,10);
		Point c = new Point(20,10);
		Point d = new Point(20,0);		
		Rectangle rec1 = new Rectangle (a, b, c, d);		
		
		Point e = new Point(0,0);
		Point f = new Point(0,10);
		Point g = new Point(10,10);
		Point h = new Point(10,0);			
		Square sqr1 = new Square (e, f, g, h);
		
		/*Quadrilateral shapes[] = 
		int area=0;
		for(int i=0;i<shapes.length;i++)
		{
		area = shapes[i].calculateArea();*/
		System.out.println("Area of " + shapes[i].getClass() + " : " + area);
		System.out.printf("The area ot the rectangle is %.2f", rec1.calculateArea());
		System.out.printf("%nThe area ot the square is %.2f", sqr1.calculateArea());

	}

}
