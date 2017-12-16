package com.manofwar.presentation;

import com.manofwar.presentation.ButtonListener;
import com.manofwar.utilities.FileManager;
import com.manofwar.utilities.GraphicsManager;

import javax.swing.*;
import java.awt.*;


public class InfoPanel {


	static JPanel infoPanel = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(MainMenuPanel.graphicsManager.getResource("info.jpg"), 0, 0, null);
		}
	};
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
	
	public void removeInfoPanel(JFrame frame) {
		frame.remove(infoPanel);
	}

}
