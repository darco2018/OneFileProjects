////Create a Polygon class. A polygon is a closed shape with lines joining the corner points.
//You will keep the points in an array list. Use object of java.awt.Point for the point.
//Polygon will have as an instance variable an ArrayList of Points to hold the points
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Polygon extends JPanel
{
	ArrayList<Point> points; 

	public Polygon()
	{
		points = new ArrayList<Point>();
	}
	
	// adds a Point to the polygon
	public void add(Point e)
	{
		points.add(e);
		
	}
	
	// returns the perimeter of the polygon
	public double perimeter()
	{
		int peri = 0;
		
		for (int c = 0; c < points.size()-1; c++)
		{
			peri += distance(points.get(c), points.get(c+1));
		}
		// add distance between the last and first point
		peri += distance( points.get(0), points.get(points.size()-1) );
		
		return peri;
	}
	
//  draws the polygon by connecting consecutive points and then
//  connecting the last point to the first.
	public void draw() 
	{
		for (int c = 0; c < points.size()-1; c++)
		{
			int x0 = (int) points.get(0).getX();  
			int x1 = (int) points.get(1).getX();	
			int y0 = (int) points.get(0).getY();  
			int y1 = (int) points.get(1).getY();
			
			Line line =  new Line (points.get(c).getX(), points.get(c).getY(),
					points.get(c+1).getX(), points.get(c+1).getY());
	        line.draw();
		}
		
		// draw the line between the first and last point
        Line line =  new Line (points.get(0).getX(), points.get(0).getY(),
					points.get(points.size()-1).getX(), points.get(points.size()-1).getY());
        
        line.draw();
	}
	
	private double distance(Point p, Point q)
	{ 
	  double dx   = p.getX() - q.getX();         //horizontal difference 
	  double dy   = p.getY() - q.getY();         //vertical difference 
	  
	  double dist = Math.sqrt( dx*dx + dy*dy ); //distance using Pythagoras theorem
	  
	  return dist;
	}
	
	public String toString()
	{
		String pointCoordinates = "";
		
		for (Point element : points)
		{
			pointCoordinates += String.format("[%1.0f, %1.0f] ", element.getX(), element.getY() );
		}
		
		return pointCoordinates;
		
	}
	
}
