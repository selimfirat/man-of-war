package com.manofwar.presentation;

import com.manofwar.presentation.MainMenuPanel;

import javax.swing.JFrame;

/*
 * Inform user about game
 * How to play, how to change settings etc.
 */

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public MainFrame() {}
	static JFrame frame;
	static MainMenuPanel mainMenuP;
	
	public static void main(String[] args) {
		frame = new MainFrame();
		frame.setFocusable(true);
		mainMenuP = new MainMenuPanel();
		mainMenuP.createFrame(frame);
        MainMenuPanel.createMainPanel(frame);
        
	}
}
