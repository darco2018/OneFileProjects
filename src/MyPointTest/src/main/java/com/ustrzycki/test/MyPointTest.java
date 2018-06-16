package com.ustrzycki.test;

import com.ustrzycki.graphics.MyPoint;

public class MyPointTest implements java.lang.Cloneable{

	public static void main(String[] args) {
		
		MyPoint point1 = new MyPoint(5, 10);
		
		System.out.printf("%s", point1);
		System.out.println();
		System.out.println();
		
		MyPoint point2 = (MyPoint)point1.clone();
		System.out.printf("MyPoint point2 created with point.clone(): " + point2.toString());	
		System.out.println();
		
		System.out.printf("%s%n", "hashCode for point1: " + point1.hashCode() + "hashCode for point2: " + point2.hashCode());
		System.out.printf("point1.equals(point2): " + point1.equals(point2));				
		System.out.printf("%n%s%b%n", "x.clone().getClass() == x.getClass(): ", point1.getClass() == point2.getClass() );	

	}
	
	void method()
	{
		
	}

}
