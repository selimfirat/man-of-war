package com.manofwar.presentation;

import com.manofwar.presentation.ButtonListener;

import javax.swing.*;
import java.awt.Color;


/*
 * Inform user about game
 * How to play, how to change settings etc.
 */

public class InfoPanel {
	static JPanel infoPanel = new JPanel();
	static ButtonListener bListener = new ButtonListener();
	static JButton backMenu;
	
	public static void createInfoPanel(JFrame frame) {
		infoPanel.setLayout(null);
		infoPanel.setBackground(Color.black);
		
		backMenu = new JButton();
		backMenu.setBounds(300,500,150,50);
		
		infoPanel.add(backMenu);
		backMenu.setText("Back to Menu");
		
		frame.add(infoPanel);
		backMenu.addActionListener(bListener.turnFromInfoListener(frame));
		frame.repaint();
		frame.validate();
		
	}

	/**
	 * removes from frame when its needed
	 */
	public void removeInfoPanel(JFrame frame) {
		frame.remove(infoPanel);
	}

}
