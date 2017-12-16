package com.manofwar.presentation;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.GameThread;
import com.manofwar.logic.SaveLoad;
import com.manofwar.logic.character.Character;
import com.manofwar.utilities.FileManager;
import com.manofwar.utilities.GraphicsManager;
import com.manofwar.utilities.InputManager;
import java.awt.*;
//import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.*;

public class GamePanel extends JPanel{

    private FileManager fileManager;
    private GraphicsManager graphicsManager;
    private InputManager inputManager;
    private GameStateManager gameStateManager;
    private GameThread gameThread;
    private SaveLoad load;
    private Character ch;
	private InformationBar infoBar;

	public GamePanel() {
        this.setFocusable(true);
        this.setLayout(null);
        fileManager = new FileManager();
        inputManager = new InputManager();
        graphicsManager = new GraphicsManager(fileManager);
        gameStateManager = new GameStateManager(fileManager, graphicsManager, inputManager);
        load = new SaveLoad(gameStateManager);
	    gameThread = new GameThread(gameStateManager, this);
		infoBar = new InformationBar();
	}
	
	public void saveGame() throws UnsupportedEncodingException, FileNotFoundException {
		load.writeSave(gameStateManager.getLevelNum(),ch.getHealth(),ch.getPower(),ch.getBoundingBox().x,ch.getBoundingBox().y);
	}

	public void createGamePanel(JFrame frame) {

        frame.add(this);
        frame.addKeyListener(inputManager);
		this.add(infoBar);
		frame.repaint();
		frame.validate();

		gameStateManager.startGame(1);
		ch = gameStateManager.getCharacter();
		gameThread.start();
	}
	
	public void loadGamePanel(JFrame frame) throws FileNotFoundException {

        frame.add(this);
        frame.addKeyListener(inputManager);
		
		//graphicsManager.resetFullImage();
		//graphicsManager.setFullImage(graphicsManager.getResource("level1.jpg"));
		this.add(infoBar);


		frame.repaint();
		frame.validate();

		gameStateManager.startGame(load.getLevel());
		ch = gameStateManager.getCharacter();
		ch.setHealth(load.getHealth());
		ch.setPower(load.getAttack());
		ch.getBoundingBox().setLocation(load.getPlayerX(), load.getPlayerY());
		System.out.println(load.getPlayerX());
		System.out.println(load.getPlayerY());
		gameThread.start();
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(graphicsManager.getFullImage(), 0, 0, this);
    }
    
    public static void removeGamePanel(JFrame frame) {
		frame.getContentPane().removeAll();
	}

}