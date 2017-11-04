package com.manofwar.logic;

/**
 * Config class contains the constants of the game.
 * This class provides an easy interface to change and play with important constants of the game.
 */
public class Config {

    /**
     * The delay between each iteration of game loop.
     */
    public static final long DELAY = 5;

    /**
     * The velocity of the character. It is high because it is also multiplied with seconds passed in each game loop iteration like 0.001
     */
    public static final double VELOCITY =  2000;

    /**
     * The width of each tile in game.
     */
    public static final int TILE_WIDTH = 50;

    /**
     * The height of each tile in game.
     */
    public static final int TILE_HEIGHT = 50;

}
