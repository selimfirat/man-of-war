package com.manofwar.logic.block;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;

import java.awt.*;

/**
 * Block is the game object that represents restricted tile in the map.
 */
public class Block extends GameObject {
    public Block(Rectangle boundingBox) {
        super(boundingBox);
    }

    /**
     * The method that is executed each iteration of game loop.
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {

    }
}
