package com.manofwar.presentation;

import com.manofwar.presentation.ButtonListener;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * Creates main menu and its buttons when player
 * first enter the game he/she will interact with this panel
 * he will be able to choose settings 
 */
public class MainMenuPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	static JButton playButton;
	static JButton settingsButton;
	static JButton quitButton;
	static JButton infoButton;
	static JPanel mainPanel = new JPanel();
	static ButtonListener bListener = new ButtonListener();
		
	public MainMenuPanel() {}
	public void createFrame(JFrame frame) {
		frame.setResizable(false);
        frame.setSize(815,660);
        frame.setMinimumSize(new Dimension(815,660));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //frame.setLayout(new BoxLayout());
        frame.setResizable(true);
	}
	
	public static void createMainPanel(JFrame frame) {
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		playButton = new JButton();
		playButton.setBounds(300,100,200,70);
		settingsButton = new JButton();
		settingsButton.setBounds(300,200,200,70);
		infoButton = new JButton();
		infoButton.setBounds(300,300,200,70);
		quitButton = new JButton();
		quitButton.setBounds(300,400,200,70);
		mainPanel.add(playButton);
		mainPanel.add(settingsButton);
		mainPanel.add(quitButton);
		mainPanel.add(infoButton);
		playButton.setText("Play The Game");
		settingsButton.setText("Settings");
		infoButton.setText("Info");
		quitButton.setText("QUIT");
		
		playButton.addActionListener(bListener.playButtonListener(frame));
		settingsButton.addActionListener(bListener.settingsButtonListener(frame));
		quitButton.addActionListener(bListener.quitButtonListener(frame));
		infoButton.addActionListener(bListener.infoButtonListener(frame));
		frame.add(mainPanel);
		frame.repaint();
		frame.validate();
	}
		
	public static void removeMainPanel(JFrame frame) {
		frame.remove(mainPanel);
	}
	
}
