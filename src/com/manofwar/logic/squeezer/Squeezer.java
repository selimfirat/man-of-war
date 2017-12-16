package com.manofwar.logic.squeezer;

import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;

import java.awt.*;

public class Squeezer extends GameObject {

    private SqueezerGraphicsComponent graphicsComponent;
    private SqueezerPhysicsComponent physicsComponent;

    private Direction direction;
    private Rectangle originalBoundingBox;

    public Squeezer(Rectangle boundingBox, Direction direction) {
        super(boundingBox);
        originalBoundingBox = (Rectangle) boundingBox.clone();
        this.graphicsComponent = new SqueezerGraphicsComponent(this);
        this.physicsComponent = new SqueezerPhysicsComponent(this);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void update(GameStateManager gameStateManager) {
        physicsComponent.update(gameStateManager);
        graphicsComponent.update(gameStateManager.getGraphicsManager());
    }

    public Rectangle getOriginalBoundingBox() {
        return originalBoundingBox;
    }
}