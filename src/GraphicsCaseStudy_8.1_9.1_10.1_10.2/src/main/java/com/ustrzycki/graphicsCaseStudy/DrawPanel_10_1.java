package com.ustrzycki.graphicsCaseStudy;

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class DrawPanel_10_1 extends JPanel{
	
	private int panelWidth;	
	private MyShape[] shapes;
	
	private int RectCount = 0;
	private int OvalCount = 0;
	private int SquareCount = 0;
	private int CircleCount = 0;
	private int LineCount = 0;
	
	public DrawPanel_10_1(int numberOfShapes)
	{
		setNumberOfShapes(numberOfShapes);
		this.panelWidth = 750;		
	}
	
	protected void setPanelWidth(int windowSize)
	{
		this.panelWidth = windowSize;
	}
	
	protected int getPanelWidth()
	{
		return panelWidth;
	}
	
	protected void setNumberOfShapes(int numberOfShapes)
	{
		shapes = new MyShape[numberOfShapes];	
	}
	
	protected void createShapes()
	{
		//fill the shapes array with various shapes
				for(int counter = 0; counter < shapes.length; counter++)
				{
					SecureRandom randomNumbers = new SecureRandom();
					// generate random arguments for the shapes' constructors
					int x1 = randomNumbers.nextInt(getPanelWidth() - 100); // subtract 100 to reduce the number of shapes going beyond the visible panel
					int y1 = randomNumbers.nextInt(getPanelWidth() - 100);
					int x2 = randomNumbers.nextInt(getPanelWidth() - 100);
					int y2 = randomNumbers.nextInt(getPanelWidth() - 100);					
					Color currentColor = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), 
											randomNumbers.nextInt(256));
					boolean isFilled;
					
					/*if (randomNumbers.nextInt(2) == 0 )
						isFilled = true;
					else
						isFilled = false;*/
					
					isFilled = randomNumbers.nextInt(2) == 0 ? true : false;
					
					//generate a random shape option
					int choice = randomNumbers.nextInt(5);
					
					switch(choice)
					{
					case 0:
						shapes[counter] = new MyRectangle(x1, y1, x2, y2, currentColor, isFilled);
						RectCount++;
						break;
					case 1:
						shapes[counter] = new MyOval(x1, y1, x2, y2, currentColor, isFilled);
						OvalCount++;
						break;
					case 2:
						y2 = Math.abs(x1 - x2) + y1; // make the width equal to the height
						shapes[counter] = new MySquare(x1, y1, x2, y2, currentColor, isFilled);
						SquareCount++;
						break;
					case 3:
						y2 = Math.abs(x1 - x2) + y1; // make the width equal to the height
						shapes[counter] = new MyCircle(x1, y1, x2, y2, currentColor, isFilled);
						CircleCount++;
						break;
					case 4:
						shapes[counter] = new MyLine(x1, y1, x2, y2, currentColor);
						LineCount++;
					}
				} // end for-loop		
	}
	
	public String countShapes()
	{
		return  "Rectagles: " + RectCount + " Ovals: " + OvalCount + " Squares: " + SquareCount +
				" Circles: " + CircleCount + " Lines: " + LineCount;		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		
		for(MyShape shape : shapes)
			shape.draw(g);
	}
}
