package com.manofwar.presentation;

import com.manofwar.presentation.MainMenuPanel;
import com.manofwar.utilities.InputManager;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

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
		frame.setTitle("Man of War");
        MainMenuPanel.createMainPanel(frame);
	}
}