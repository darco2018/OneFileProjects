package com.ustrzycki.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPanelWithIconTest {

	public static void main(String[] args) {

		
		 
		    JFrame frame = new JFrame();
		    ImagePanel panel = new ImagePanel();
		    frame.add(panel);		    
		    
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(500, 500); 
		    frame.setVisible(true); 
	}

}

 class ImagePanel extends JPanel{

    private BufferedImage image;
    private JPanel panel_1;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("Cross.jpg"));
          
          setBackground(Color.YELLOW);
          
          panel_1 = new JPanel();
          panel_1.setBackground(Color.RED);
          panel_1.setSize(200, 200);
          add(panel_1, 0);
          
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        
    	super.paintComponent(g);
        
    	
    	g.drawImage(image, 100, 100, null); // see javadoc for more info on the parameters 
    	g.drawImage(image, 300, 300, null); 
    }

}
