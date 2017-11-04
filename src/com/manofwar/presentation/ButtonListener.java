package com.manofwar.presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
/*
 * Listens Main Menu, Settings and info button
 * creates new panels to main frame
 */
public class ButtonListener {

	MainMenuPanel mainMenuP;
	SettingsPanel settingsPanel;
	GamePanel gamePanel;
	InfoPanel infoP;

	public ButtonListener() {
	}

	/**
	 * creates new game panel to frame and removes main menu panel from frame
	 */
	public ActionListener playButtonListener(JFrame frame) {
		ActionListener al1 = new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) {
			gamePanel = new GamePanel();

			mainMenuP = new MainMenuPanel();
			MainMenuPanel.removeMainPanel(frame);
			gamePanel.createGamePanel(frame);
		}
		};
		return al1;		
	}
	/**
	 * creates new settings panel to frame and removes main menu panel from frame
	 */
	public ActionListener settingsButtonListener(JFrame frame) {		
		ActionListener al2 = new ActionListener()
		{
		    public void actionPerformed(ActionEvent arg0) {
                settingsPanel = new SettingsPanel();
                MainMenuPanel.removeMainPanel(frame);
                settingsPanel.createSettingsPanel(frame);
            }
		};
		return al2;		
	}
	/**
	 * creates new info panel to frame and removes main menu panel from frame
	 */
	public ActionListener infoButtonListener(JFrame frame) {
		ActionListener al2 = new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) {
			MainMenuPanel.removeMainPanel(frame);
			InfoPanel.createInfoPanel(frame);
		}
		};
		return al2;		
	}
	/**
	 * quit from game
	 */
	public ActionListener quitButtonListener(JFrame frame) {		
		ActionListener al3 = new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		};
		return al3;		
	}
	/**
	 * creates new main menu panel to frame and removes settings panel from frame
	 */
	public ActionListener turnFromSettingsListener(JFrame frame) {		
		ActionListener al3 = new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) {
			mainMenuP = new MainMenuPanel();
			settingsPanel = new SettingsPanel();
			settingsPanel.removeSettingsPanel(frame);
			MainMenuPanel.createMainPanel(frame);
		}
		};
		return al3;		
	}
	/**
	 * creates new main menu panel to frame and removes info panel from frame
	 */
	public ActionListener turnFromInfoListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
		public void actionPerformed(ActionEvent arg0) {
			mainMenuP = new MainMenuPanel();
			infoP = new InfoPanel();
			infoP.removeInfoPanel(frame);
			MainMenuPanel.createMainPanel(frame);
		}
		};
		return al3;
	}
	
}
