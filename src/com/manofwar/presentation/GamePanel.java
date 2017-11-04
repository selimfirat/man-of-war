package com.manofwar.presentation;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.GameThread;
import com.manofwar.utilities.FileManager;
import com.manofwar.utilities.GraphicsManager;
import com.manofwar.utilities.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
/*
 * Our Game Panels GUI
 * When its added to frame it generates new GamePanel 
 */
public class GamePanel extends JPanel{

    private FileManager fileManager;
    private GraphicsManager graphicsManager;
    private InputManager inputManager;
    private GameStateManager gameStateManager;
    private GameThread gameThread;

    /**
     * Simply, constructor
     */
    public GamePanel() {
        this.setFocusable(true);
        this.setLayout(new BorderLayout());
        fileManager = new FileManager();
        inputManager = new InputManager();
        graphicsManager = new GraphicsManager(fileManager);
        gameStateManager = new GameStateManager(fileManager, graphicsManager, inputManager);
	    gameThread = new GameThread(gameStateManager, this);
	}

    /**
     * creates the game panel and starts the game
     */
    public void createGamePanel(JFrame frame) {

        frame.add(this);
        frame.addKeyListener(inputManager);
		frame.repaint();
		frame.validate();

		graphicsManager.resetFullImage();
		graphicsManager.setFullImage(graphicsManager.getResource("level1.jpg"));

		gameStateManager.startGame();
		gameThread.start();
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(graphicsManager.getFullImage(), 0, 0, this);
    }

}