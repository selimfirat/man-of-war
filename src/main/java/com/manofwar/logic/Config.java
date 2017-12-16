package com.manofwar.logic;

/**
 * Config class contains the constants of the game.
 * This class provides an easy interface to change and play with important constants of the game.
 */
public class Config {

    /**
     * The delay between each iteration of game loop.
     */
    public static final long UPDATE_DELAY = 5;

    /**
     * The velocity of the character. It is high because it is also multiplied with seconds passed in each game loop iteration like green.001
     */
    public static final double VELOCITY =  1500;

    /**
     * The width of each tile in game.
     */
    public static final int TILE_WIDTH = 50;

    /**
     * The height of each tile in game.
     */
    public static final int TILE_HEIGHT = 50;

    /**
     * Bullet Speed of each bullet. It is high because it is also multiplied with seconds passed in each game loop iteration like green.001
     */
    public static final int BULLET_SPEED = 2500;


    /**
     * Minimum number of frames that a bullet can be shot by character.
     */
    public static final int BULLET_UPDATE_LIMIT = 15;

    /**
     * Minimum number of frames that a bullet can be shot by a mob.
     */
    public static final int MOB_BULLET_UPDATE_LIMIT = 45;

    /**
     * The speed of the animation. Be careful! It is reverse correlated with the animation per frame.
     * Not actually a speed!!
     */
    public static final int ANIMATION_SPEED = 3;


    /**
     * Speed of each mob. It is high because it is also multiplied with seconds passed in each game loop iteration like green.001
     */

    public static final int MOB_SPEED = 1000;
}
