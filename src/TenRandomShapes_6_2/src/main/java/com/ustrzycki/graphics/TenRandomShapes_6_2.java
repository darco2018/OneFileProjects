package com.ustrzycki.graphics;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TenRandomShapes_6_2 {

	public static void main(String[] args) {
		
		DrawPanelTenRandomShapes panel = new DrawPanelTenRandomShapes();
		panel.createShapes();
		
		JLabel label = new JLabel(panel.countShapes());
		label.setOpaque(true);
		label.setBackground(Color.CYAN);
		
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.add(label, BorderLayout.SOUTH);
		application.setSize(500, 500);
		application.setVisible(true);	
		
		System.out.println();

	}

}
