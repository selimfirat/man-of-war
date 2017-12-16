package com.manofwar.presentation;

import com.manofwar.presentation.ButtonListener;
import com.manofwar.utilities.FileManager;
import com.manofwar.utilities.GraphicsManager;

import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;

public class MainMenuPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	static JButton playButton;
	static JButton settingsButton;
	static JButton loadButton;
	static JButton quitButton;
	static JButton infoButton;

	static FileManager fileManager = new FileManager();
	static GraphicsManager graphicsManager = new GraphicsManager(fileManager);

	static JPanel mainPanel = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(graphicsManager.getResource("main_menu_background.png"), 0, 0, null);
		}
	};
	static ButtonListener bListener = new ButtonListener();

	public MainMenuPanel() {
		// Code below is copied from oracle docs: https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

	}
	public void createFrame(JFrame frame) {
		frame.setResizable(false);
        frame.setSize(800,650);
        frame.setMinimumSize(new Dimension(800,650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //frame.setLayout(new BoxLayout());
        frame.setResizable(false);
	}
	
	public static void createMainPanel(JFrame frame) {
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.LIGHT_GRAY);

		playButton = new JButton();
		playButton.setBounds(300,100,200,70);
		loadButton = new JButton();
		loadButton.setBounds(300,200,200,70);
		settingsButton = new JButton();
		settingsButton.setBounds(300,300,200,70);
		infoButton = new JButton();
		infoButton.setBounds(300,400,200,70);
		quitButton = new JButton();
		quitButton.setBounds(300,500,200,70);
		mainPanel.add(playButton);
		mainPanel.add(settingsButton);
		mainPanel.add(quitButton);
		mainPanel.add(infoButton);
		mainPanel.add(loadButton);
		playButton.setText("Play The Game");
		settingsButton.setText("Settings");
		infoButton.setText("Info");
		loadButton.setText("Load Last Save");
		quitButton.setText("QUIT");
		
		playButton.addActionListener(bListener.playButtonListener(frame));
		settingsButton.addActionListener(bListener.settingsButtonListener(frame));
		quitButton.addActionListener(bListener.quitButtonListener(frame));
		infoButton.addActionListener(bListener.infoButtonListener(frame));
		loadButton.addActionListener(bListener.loadButtonButtonListener(frame));
		frame.add(mainPanel);
		frame.repaint();
		frame.validate();
	}
		
	public static void removeMainPanel(JFrame frame) {
		frame.remove(mainPanel);
	}
	
}
