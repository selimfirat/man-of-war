package com.manofwar.logic.door;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;

import java.awt.*;

/**
 * Door is the game object that represents the situation when user is in, level changes.
 */
public class Door extends GameObject {

    private int targetLevelNum;

    private DoorPhysicsComponent physicsComponent;

    /**
     * Simply, constructor
     * @param boundingBox the bounding box of the door game object
     * @param targetLevelNum the level of game to be changed when user is goes in the door
     */
    public Door(Rectangle boundingBox, int targetLevelNum) {
        super(boundingBox);
        this.targetLevelNum = targetLevelNum;
        this.physicsComponent = new DoorPhysicsComponent(this);
    }

    /**
     * The method that is executed each iteration of game loop.
     * Executes its components
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {
        physicsComponent.update(gameStateManager);
    }

    /**
     * Returns the target level number
     * @return the target level number
     */
    public int getTargetLevelNum() {
        return targetLevelNum;
    }
}