package com.ustrzycki.graphics;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawPanelWithIcons extends JFrame{
	
	JPanel panel = new JPanel();
	
	public DrawPanelWithIcons()
	{
		super("Noughts and Crosses");
		setLayout(new FlowLayout());
		
		add(panel);
		
		Icon icon = new ImageIcon("Cross.jpg");
		setIconImage(new ImageIcon("Cross.jpg").getImage());
		//frame.setIconImage(icon.getImage());
		//icon.paintIcon(panel, g, x, y);
        
		
		
		
		//topLeftCross.paintIcon(rootPane, getGraphics(), 0, 0);
		
	}
	

}
