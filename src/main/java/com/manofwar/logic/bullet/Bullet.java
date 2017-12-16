package com.manofwar.logic.bullet;

import com.manofwar.logic.Config;
import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;
import com.manofwar.logic.entities.Velocity;

import java.awt.*;

/**
 * Bullet is a GameObject that is used by Character and Enemy instances to attack and harm the opponent.
 */
public class Bullet extends GameObject {

    private Velocity velocity;
    private int power;

    private boolean isVisible;
    private boolean isMobFire;

    private BulletGraphicsComponent graphicsComponent;
    private BulletPhysicsComponent physicsComponent;

    /**
     * Simply constructor.
     * @param boundingBox bounding box of the bullet.
     * @param power red power of the bullet
     */
    public Bullet(Rectangle boundingBox, Direction direction, int power, boolean isMobFire) {
        super(boundingBox);
        switch (direction) {
            case LEFT:
                velocity = new Velocity(-Config.BULLET_SPEED, 0);
                break;
            case RIGHT:
                velocity = new Velocity(Config.BULLET_SPEED, 0);
                break;
            case UP:
                velocity = new Velocity(0, -Config.BULLET_SPEED);
                break;
            case DOWN:
                velocity = new Velocity(0, Config.BULLET_SPEED);
                break;
            default:
                velocity = new Velocity(0, 0);
        }

        this.isMobFire = isMobFire;
        this.power = power;
        this.isVisible = true;

        this.graphicsComponent = new BulletGraphicsComponent(this);
        this.physicsComponent = new BulletPhysicsComponent(this);
    }

    /**
     * Game loop update method for bullet
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {
        if (!isVisible())
            return;

        graphicsComponent.update(gameStateManager.getGraphicsManager());
        physicsComponent.update(gameStateManager);
    }

    /**
     * Returns velocity of the bullet
     * @return velocity of the bullet
     */
    public Velocity getVelocity() {
        return velocity;
    }


    /**
     * Returns power of the bullet
     * @return the power of the bullet
     */
    public int getPower() {
        return power;
    }


    /**
     * Returns whether the bullet is visible
     * @return whether the bullet is visible
     */
    public boolean isVisible() {
        return isVisible;
    }


    /**
     * Set visibility of the bullet
     * @param visible visibility of the bullet
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }


    /**
     * Return whether the bullet belongs to the mob
     * @return whether the bullet belongs to the mob
     */
    public boolean isMobFire() {
        return isMobFire;
    }
}
