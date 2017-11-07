package com.manofwar.logic.bullet;

import com.manofwar.logic.Config;
import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;
import com.manofwar.logic.entities.Velocity;

import java.awt.*;

public class Bullet extends GameObject {

    private Velocity velocity;
    private int power;

    private boolean isVisible;


    private BulletGraphicsComponent graphicsComponent;
    private BulletPhysicsComponent physicsComponent;

    /**
     * Simply constructor.
     * @param boundingBox bounding box of the bullet.
     * @param velocity velocity of the bullet
     * @param power red power of the bullet
     */
    public Bullet(Rectangle boundingBox, Velocity velocity, int power, int bluePower) {
        super(boundingBox);
        this.velocity = velocity;
        this.power = power;
        this.isVisible = true;

        this.graphicsComponent = new BulletGraphicsComponent(this);
        this.physicsComponent = new BulletPhysicsComponent(this);
    }

    public Bullet(Rectangle boundingBox, Direction direction, int power) {
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

        this.power = power;
        this.isVisible = true;

        this.graphicsComponent = new BulletGraphicsComponent(this);
        this.physicsComponent = new BulletPhysicsComponent(this);
    }

    @Override
    public void update(GameStateManager gameStateManager) {
        if (!isVisible())
            return;

        graphicsComponent.update(gameStateManager.getGraphicsManager());
        physicsComponent.update(gameStateManager);
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
