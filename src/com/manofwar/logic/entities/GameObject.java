package com.manofwar.logic.entities;

import com.manofwar.logic.GameStateManager;
import java.awt.*;


/**
 * GameObject class is a main template of the objects in the game. Common properties of objects in the game are represented in this class.
 */
public abstract class GameObject {


    /**
     * Simply constructor.
     * @param boundingBox bounding box of the game object.
     */
    public GameObject(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }


    /**
     * Bounding box of the game object.
     */
    protected Rectangle boundingBox;


    /**
     * Returns the bounding box of the game object.
     * @return the bounding box of the game object.
     */
    public Rectangle getBoundingBox() {
        return boundingBox;
    }


    /**
     * The method that is executed each iteration of game loop.
     * @param gameStateManager GameStateManager object that is in control.
     */
    public abstract void update(GameStateManager gameStateManager);
}
