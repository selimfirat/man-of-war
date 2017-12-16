package com.manofwar.presentation;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoadGame {
	static JButton button4;
	static JButton button5;
	static JButton backMenu;
	
	static JPanel settingPanel = new JPanel();
	ButtonListener bListener = new ButtonListener();
	
	public void createSettingsPanel(JFrame frame) {
		settingPanel.setLayout(null);
		settingPanel.setBackground(Color.black);
		
		
		button4 = new JButton();
		button4.setBounds(300,150,200,70);
		button5 = new JButton();
		button5.setBounds(300,250,200,70);
		backMenu = new JButton();
		backMenu.setBounds(300,350,200,70);
		settingPanel.add(button4);
		settingPanel.add(button5);
		settingPanel.add(backMenu);
		button4.setText("Settings1");
		button5.setText("Settings2");
		backMenu.setText("Back to Menu");
		
		
		frame.add(settingPanel);
		frame.repaint();
		frame.validate();
		backMenu.addActionListener(bListener.turnFromSettingsListener(frame));
	}
	
	public void removeSettingsPanel(JFrame frame) {
		frame.remove(settingPanel);
	}
}
