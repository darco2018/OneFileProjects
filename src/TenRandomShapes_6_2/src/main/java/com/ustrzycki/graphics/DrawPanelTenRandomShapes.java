package com.ustrzycki.graphics;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

public class DrawPanelTenRandomShapes extends JPanel
{
	
	private int windowWidth = 500;
	private int windowHeight = windowWidth;		
	private SecureRandom randomNumbers = new SecureRandom();	
	private MyShape[] shapes = new MyShape[10];
	
	private int RectCount = 0;
	private int OvalCount = 0;
	private int SquareCount = 0;
	private int CircleCount = 0;
	/*private MyShape[] shapes = {new MyRectangle(0, 0, 20, 50, Color.BLUE),
								new MyOval(100, 100, 120, 150, Color.RED)};*/
	
	protected void createShapes()
	{
		
		
		//fill the shapes array with various shapes
				for(int counter = 0; counter < 10; counter++)
				{
					int x = randomNumbers.nextInt(windowWidth);
					int y = randomNumbers.nextInt(windowWidth);
					int width = Math.max(1, randomNumbers.nextInt(windowWidth / 2)) ;
					int height = Math.max(1, randomNumbers.nextInt(windowWidth / 2)) ;
					Color currentColor = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), 
											randomNumbers.nextInt(256));
					//Chooses the shape
					int choice = randomNumbers.nextInt(4);
					
					switch(choice)
					{
					case 0:
						shapes[counter] = new MyRectangle(x, y, width, height, currentColor);
						RectCount++;
						break;
					case 1:
						shapes[counter] = new MyOval(x, y, width, height, currentColor);
						OvalCount++;
						break;
					case 2:
						x = y;
						shapes[counter] = new MySquare(x, y, width, height, currentColor);
						SquareCount++;
						break;
					case 3:
						x = y;
						shapes[counter] = new MyCircle(x, y, width, height, currentColor);
						CircleCount++;
						break;
					}
				} // end for-loop		
	}
	
	public String countShapes()
	{
		return  "Rectagles: " + RectCount + " Ovals: " + OvalCount + " Squares: " + SquareCount +
				" Circles: " + CircleCount;		
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);	
		
		
		for(MyShape shape : shapes)
			shape.fill(g);
	}


}
