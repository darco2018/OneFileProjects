import java.awt.Point;


public class PolygonTester {

	public static void main(String[] args) {

		Point one = new Point(0,0);
		Point two = new Point(2,0);
		Point three = new Point(2,2);
		
		Polygon poly = new Polygon();
				
		poly.add(one); 
		poly.add(two); 
		poly.add(three); 	
		
		System.out.println(poly.toString());
		
		Point four = new Point(0,2);
		poly.add(four); 
		
		System.out.println(poly.toString());
		
		System.out.println(poly.perimeter());

	}

}
