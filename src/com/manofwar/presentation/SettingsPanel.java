package com.manofwar.presentation;

import com.manofwar.presentation.ButtonListener;
import com.manofwar.utilities.FileManager;
import com.manofwar.utilities.GraphicsManager;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingsPanel {

	JButton defaultKeys;
	JButton ijklKeys;
	JButton numPadKeys;
	JButton backMenu;

	JButton EasyButton;
	JButton NormalButton;
	JButton HardButton;

	static JPanel settingPanel = new JPanel() {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(MainMenuPanel.graphicsManager.getResource("main_menu_background.png"), 0, 0, null);
		}
	};
	ButtonListener bListener = new ButtonListener();

	public void createSettingsPanel(JFrame frame) {
		settingPanel.setLayout(null);
		settingPanel.setBackground(Color.black);


		defaultKeys = new JButton();
		defaultKeys.setBounds(150,150,200,70);
		ijklKeys = new JButton();
		ijklKeys.setBounds(150,250,200,70);
		numPadKeys = new JButton();
		numPadKeys.setBounds(150,350,200,70);
		backMenu = new JButton();
		backMenu.setBounds(300,450,200,70);
		EasyButton = new JButton();
		EasyButton.setBounds(450,150,200,70);
		NormalButton = new JButton();
		NormalButton.setBounds(450,250,200,70);
		HardButton = new JButton();
		HardButton.setBounds(450,350,200,70);


		settingPanel.add(defaultKeys);
		settingPanel.add(ijklKeys);
		settingPanel.add(numPadKeys);
		settingPanel.add(backMenu);
		settingPanel.add(EasyButton);
		settingPanel.add(NormalButton);
		settingPanel.add(HardButton);


		defaultKeys.setText("Default Keys");
		ijklKeys.setText("i,j,k,l Keys");
		numPadKeys.setText("numpad Keys");
		backMenu.setText("Back to Menu");
		EasyButton.setText("Easy");
		NormalButton.setText("Normal");
		HardButton.setText("Hard");


		defaultKeys.addActionListener(bListener.defaultKeysButtonListener(frame));
		ijklKeys.addActionListener(bListener.ijklKeysButtonListener(frame));
		numPadKeys.addActionListener(bListener.numPadKeysButtonListener(frame));

		EasyButton.addActionListener(bListener.easyKeysButtonListener(frame));
		NormalButton.addActionListener(bListener.normalKeysButtonListener(frame));
		HardButton.addActionListener(bListener.hardKeysButtonListener(frame));

		frame.add(settingPanel);
		frame.repaint();
		frame.validate();
		backMenu.addActionListener(bListener.turnFromSettingsListener(frame));
	}

	public void removeSettingsPanel(JFrame frame) {
		frame.remove(settingPanel);
	}
}
