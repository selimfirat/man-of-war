package com.manofwar.logic.squeezer;

import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;

import java.awt.*;

/**
 * Squeezer game object in the game
 * Hurts the character while colliding with it
 */
public class Squeezer extends GameObject {

    private SqueezerGraphicsComponent graphicsComponent;
    private SqueezerPhysicsComponent physicsComponent;

    private Direction direction;
    private Rectangle originalBoundingBox;

    /**
     * Simply, constructor
     * @param boundingBox the bounding box for the squeezer
     * @param direction the direction squeezing of the squeezer
     */
    public Squeezer(Rectangle boundingBox, Direction direction) {
        super(boundingBox);
        originalBoundingBox = (Rectangle) boundingBox.clone();
        this.graphicsComponent = new SqueezerGraphicsComponent(this);
        this.physicsComponent = new SqueezerPhysicsComponent(this);
        this.direction = direction;
    }

    /**
     * Gives the direction of squeezer
     * @return the direction of the squeezer
     */
    public Direction getDirection() {
        return direction;
    }


    /**
     * The method that is executed each iteration of game loop.
     * Executes its components' update methods.
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {
        physicsComponent.update(gameStateManager);
        graphicsComponent.update(gameStateManager.getGraphicsManager());
    }

    /**
     * @return the original bounding box where it is placed.
     * It can be used when the bounding box changes for squeezing process.
     */
    public Rectangle getOriginalBoundingBox() {
        return originalBoundingBox;
    }
}