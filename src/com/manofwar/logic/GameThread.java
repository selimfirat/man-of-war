package com.manofwar.logic;

import com.manofwar.presentation.GamePanel;

/**
 * GameThread class is the responsible of the game loop. Executes update methods of the game objects through GameStateManager and repaints the GamePanel.
 */
public class GameThread extends Thread {

    private GameStateManager gameStateManager;
    private GamePanel gamePanel;


    /**
     * Simply, constructor
     * @param gameStateManager the GameStateManager instance
     * @param gamePanel the GamePanel instance
     */
    public GameThread(GameStateManager gameStateManager, GamePanel gamePanel) {
        this.gameStateManager = gameStateManager;
        this.gamePanel = gamePanel;
    }

    /**
     * The method to be runned when thread starts.
     */
    @Override
    public void run() {
        long delay = Config.UPDATE_DELAY;

        while (true) {
            gameStateManager.update(delay / 1000.0);
            gamePanel.repaint();

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {

            }
        }
    }
}
