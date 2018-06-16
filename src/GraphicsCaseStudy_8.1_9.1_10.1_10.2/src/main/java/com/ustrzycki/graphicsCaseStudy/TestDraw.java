// Exercise 10.1 and 10.2 Java How to Program 10th edition (p. 435)
// It modifies exercise 8.1 and is a solution to exercise 9.1 as well
// I optionally added classes MyCircle and MySquare
// Possible improvements: handling exceptions
// Possible enhancements: add methods for measuring areas, perimeters, lengths

package com.ustrzycki.graphicsCaseStudy;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestDraw {

	public static void main(String[] args) {
		
		int shapesNumber = Integer.parseInt( JOptionPane.showInputDialog("How many shapes do you want?") );
		DrawPanel_10_1 panel = new DrawPanel_10_1(shapesNumber);
		
		int panelWidth = 750;
		panel.setPanelWidth(panelWidth);
		panel.createShapes();
		
		//add a label with a status bar
		JLabel label = new JLabel(panel.countShapes());
		label.setOpaque(true);
		label.setBackground(Color.CYAN);
		
		JFrame application = new JFrame();		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.add(label, BorderLayout.SOUTH);
		application.setSize(panel.getPanelWidth(), panel.getPanelWidth());
		application.setVisible(true);	
	}

}
