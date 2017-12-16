package com.manofwar.presentation;

import javax.swing.*;

import com.manofwar.logic.SaveLoad;
import com.manofwar.utilities.InputManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ButtonListener {

	MainMenuPanel mainMenuP;
	SettingsPanel settingsPanel;
	GamePanel gamePanel;
	InfoPanel infoP;
	SaveLoad saveloadGame;
	public ButtonListener() {
	}

	public ActionListener loadButtonButtonListener(JFrame frame) {
		ActionListener al1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				gamePanel = new GamePanel();
				mainMenuP = new MainMenuPanel();
				MainMenuPanel.removeMainPanel(frame);
				try {
					gamePanel.loadGamePanel(frame);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		};
		frame.addKeyListener(new InputManager() {

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 83) {
					try {
						gamePanel.saveGame();
					} catch (UnsupportedEncodingException e1) {
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
				else if(e.getKeyCode() == 27) {
					gamePanel.removeGamePanel(frame);
					frame.repaint();
					frame.validate();
					MainMenuPanel.createMainPanel(frame);
				}
			}
		});
		return al1;
	}

	public ActionListener playButtonListener(JFrame frame) {
		ActionListener al1 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				gamePanel = new GamePanel();
				gamePanel.setFocusable(true);
				gamePanel.requestFocus();

				mainMenuP = new MainMenuPanel();
				MainMenuPanel.removeMainPanel(frame);
				gamePanel.createGamePanel(frame);

				frame.addKeyListener(new InputManager() {

					@Override
					public void keyPressed(KeyEvent e) {
						//System.out.println(e.getKeyCode());
						if(e.getKeyCode() == 83) {
							try {
								gamePanel.saveGame();
							} catch (UnsupportedEncodingException | FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
						else if(e.getKeyCode() == 27) {
							gamePanel.removeGamePanel(frame);
							frame.repaint();
							frame.validate();
							MainMenuPanel.createMainPanel(frame);
						}
					}
				});

			}
		};
		return al1;
	}
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
	public ActionListener quitButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		};
		return al3;
	}
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

	public ActionListener turnFromPauseListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				//pmp.removePausePanel(frame);
				MainMenuPanel.createMainPanel(frame);
			}
		};
		return al3;
	}

	public ActionListener defaultKeysButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().changeKeys(0);
			}
		};
		return al3;
	}

	public ActionListener ijklKeysButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().changeKeys(1);
			}
		};
		return al3;
	}

	public ActionListener numPadKeysButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().changeKeys(2);
			}
		};
		return al3;
	}

	public ActionListener easyKeysButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().changeDiffculty(0);
			}
		};
		return al3;
	}

	public ActionListener normalKeysButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().changeDiffculty(1);
			}
		};
		return al3;
	}

	public ActionListener hardKeysButtonListener(JFrame frame) {
		ActionListener al3 = new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				Settings.getInstance().changeDiffculty(2);
			}
		};
		return al3;
	}
}
