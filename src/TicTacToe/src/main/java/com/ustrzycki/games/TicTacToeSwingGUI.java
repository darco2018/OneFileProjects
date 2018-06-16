package com.ustrzycki.games;
import java.awt.Color;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TicTacToeSwingGUI extends JFrame 
{
	// non-graphic components
	private  final TicTacToeEngine engine = new TicTacToeEngine();
	private static final int zeroBasedCountRemover = 1;
	
	// graphic components	
	private final Container container;
	private final ButtonsPanel buttonsPanel;
	private JButton[] buttons;	// 9 buttons with O/X/BLANK icons
	private final MessagePanel messagePanel;// displays messages on a messageTextArea
	private JTextArea messageTextArea;
	private Icon crossIcon;
	private Icon naughtIcon;
	private Icon blankIcon;		
	private ButtonHandler buttonHandler;
	
	// add two JPanels (with JButtons, JTextArea and appropriate listeners) to the JFrame 
	private TicTacToeSwingGUI()
	{	
		super("Naughts and Crosses application");
		container = getContentPane();
		setLayout(new FlowLayout()); // set  layout (overwrite the default JFrame's BorderLayout)
		container.setBackground(Color.LIGHT_GRAY);		
		
		messagePanel = new MessagePanel(); 
		buttonsPanel = new ButtonsPanel();
		add(buttonsPanel);
		add(messagePanel); 	
		
		buttonHandler = new ButtonHandler();
		addActionListenerToButtons();
		addKeyListenerToFrame();
	} 	
	
	public static void main(String[] args) {
		
		TicTacToeSwingGUI frame = new TicTacToeSwingGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 540);
		frame.setVisible(true);
	}
	
	private void setButtonsClickable(boolean clickable)
	{
		for (int count = 1; count <buttons.length; count++)						
			buttons[count].setEnabled(clickable);
	}
	
	private void addActionListenerToButtons()
	{		
		for (int count = 1; count <buttons.length; count++) // buttons[0] is skipped									
			buttons[count].addActionListener(buttonHandler);
	}
	
	private void removeActionListenerFromButtons()
	{		
		for (int count = 1; count <buttons.length; count++) // buttons[0] is skipped
		    buttons[count].removeActionListener(buttonHandler);
	}
	
	private void addKeyListenerToFrame()
	{
		addKeyListener(
		    	new KeyAdapter()  
		    	{
		    		@Override
		    		public void keyPressed(KeyEvent e) 
		    		{
		    			restartGame();
		    		}
		    	}
		    ); 
	}
	
	public void restartGame()
	{
		engine.resetBoard();
		refreshBoardIcons(engine.getBoard());
		setButtonsClickable(true);
		removeActionListenerFromButtons(); // prevent multiple listeners on some buttons
		addActionListenerToButtons();
		displayWelcomingMessage();
	}
	
	// refresh the icons on the board
	private void refreshBoardIcons(Values[][] valuesBoard)
	{		
		int buttonCounter = 0;
		
		for(int row = 0; row < valuesBoard.length; row++)
		{								
			for(int column = 0; column < valuesBoard[row].length; column++)
			{
				buttonCounter++;
				
				switch(valuesBoard[row][column])
				{
					case EMPTY:	
						buttons[buttonCounter].setIcon(blankIcon);
						break;
						
					case O:
						buttons[buttonCounter].setIcon(naughtIcon);
						break;
						
					case X:	
						buttons[buttonCounter].setIcon(crossIcon);
						break;						
				}
			}			
		}
	}
	
	// four methods displaying messages for the players
	private void displayWelcomingMessage()
	{		
		messageTextArea.setText((String.format("Click a square to start a game." )));			
	}
	
	private void displayWinningMessage()
	{		
		messageTextArea.setText((String.format(engine.getWinningMessage() + "%nPlay again? Press a key.")));			
	}
	
	private void displayDrawMessage()
	{		
		messageTextArea.setText((String.format(engine.getDrawMessage() + "%nPlay again? Press a key.")));	
	}	
	
	private void displayWhoseMoveMessage()
	{		
		messageTextArea.setText(engine.getWhoseMoveMessage());
	}
	
	// private inner class for ActionEvents
	private class ButtonHandler implements ActionListener
	{
		//@Override
		public void actionPerformed(ActionEvent event)
		{		
			markClickedSquare(event);	
			refreshBoardIcons(engine.getBoard());
			continueGameIfNotWonOrDrawn();
		}
		
		private void markClickedSquare(ActionEvent event)
		{
			for (int count = zeroBasedCountRemover; count <buttons.length; count++) // buttons[0] is skipped
			{ 
				if (event.getSource() == buttons[count])
				{
					buttons[count].removeActionListener(this); //remove the action listener from this particular button
					engine.setXorOinSquare(count);					
					return;
				}
			}
		}
		
		private void continueGameIfNotWonOrDrawn()
		{
			if (engine.isTheGameWon() || engine.isTheGameDrawn())
			{		
				setButtonsClickable(false);
				requestFocusInWindow(); // the focus is moved from the buttons to the JFrame, 
				                        //so that the key listener can listen for events						
				
				if(engine.isTheGameWon())
					displayWinningMessage(); 
				else
					displayDrawMessage(); 
			}			
			else
			{
					engine.changePlayer(); 
					displayWhoseMoveMessage();
			}		
		}
	}// end class ButtonHandler	
	
	private class MessagePanel extends JPanel
	{
		MessagePanel()
		{
			messageTextArea = new JTextArea();
			messageTextArea.setText(String.format("Welcome to the TicTacToe application!%n" + 
												  "Click a square to start a game."));
			messageTextArea.setEditable(false); 
			messageTextArea.setBackground(Color.WHITE);
			messageTextArea.setMargin( new Insets(10,10,10,10) );
		    add(messageTextArea);		
		}
	}
	
	private class ButtonsPanel extends JPanel
	{
		ButtonsPanel()
		{
			crossIcon = new ImageIcon(getClass().getResource("cross.jpg")); 
			naughtIcon = new ImageIcon(getClass().getResource("naught.jpg"));
			blankIcon = new ImageIcon(getClass().getResource("blank.jpg"));
			
			setLayout(new GridLayout(3,3)); // overwrite the default FlowLayout				
			buttons = new JButton[engine.getNumberOfAllSquares() + zeroBasedCountRemover]; //9 + 1 >> buttons[0] will later be skipped)	
			
			// instantiate 9 buttons, add a blank icon, add to the buttonsPanel
			for (int count = zeroBasedCountRemover; count <buttons.length; count++) // buttons[0] is skipped
			{			
				buttons[count] = new JButton(blankIcon); 
				add(buttons[count]);
			}
		}
	}
}
