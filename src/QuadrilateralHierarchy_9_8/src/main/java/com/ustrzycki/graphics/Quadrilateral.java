package com.ustrzycki.graphics;

public class Quadrilateral {
	
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	
	public Quadrilateral(Point a, Point b, Point c, Point d)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;		
	}

	/**
	 * @return the a
	 */
	public Point getA() {	
		
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(Point a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public Point getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(Point b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public Point getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Point c) {
		this.c = c;
	}

	/**
	 * @return the d
	 */
	public Point getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(Point d) {
		this.d = d;
	}
	
	public Point[] getAllPoints()
	{
		Point[] points = {a, b, c, d};
		return points;
	}
	
	public void setAllPoints(Point a, Point b, Point c, Point d)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;	
	}
	
	/*public double calculateArea()
	{
		
	}*/

}
