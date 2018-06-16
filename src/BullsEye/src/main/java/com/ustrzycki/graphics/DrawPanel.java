package com.ustrzycki.graphics;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.security.SecureRandom;

public class DrawPanel extends JPanel{
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int radius = getHeight();
		int decrement = 20; // defines how the topLeftX, topLeftY and radius will decrement in each loop
		int topLeftX = 0;
		int topLeftY = 0;
		
		SecureRandom randomNumbers = new SecureRandom();
		
		/*Color color1 = Color.BLUE;
		Color color2 = Color.RED;*/
		Color color1 = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
		Color color2 = new Color(randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));
		
		for(int counter = 0; radius - (decrement * 2)* counter > 0; counter++)
		{			
			// alternates between two colors
			if(counter % 2 == 0)
			{
				g.setColor(color1);
			}
			else
				g.setColor(color2);
			
			g.fillOval(topLeftX + decrement * counter,
					   topLeftX + decrement * counter,
					   radius - (decrement * 2)* counter,
					   radius - (decrement * 2)* counter);			
		}
	}
}
