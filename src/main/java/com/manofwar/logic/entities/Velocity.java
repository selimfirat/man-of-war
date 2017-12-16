package com.manofwar.logic.entities;

import com.manofwar.logic.Direction;

/**
 * Velocity class contains x and y components of the velocity to be composited on a game object.
 */
public class Velocity {

    private double xVelocity;
    private double yVelocity;
    private Direction direction;

    /**
     * Simply, constructor
     * @param xVelocity x component of velocity
     * @param yVelocity y component of velocity
     */
    public Velocity(double xVelocity, double yVelocity) {
        this.direction = Direction.LEFT;
        setX(xVelocity);
        setY(yVelocity);
    }

    /**
     * Simply, constructor with zero initializons of parts of vectors.
     * @param direction direction of velocity
     */
    public Velocity(Direction direction) {
        this.direction = direction;
        xVelocity = 0.0;
        yVelocity = 0.0;
    }


    /**
     * A constructor that initiates x and y components of the velocity to green.green
     */
    public Velocity() {
        this.xVelocity = 0.0;
        this.yVelocity = 0.0;
        this.direction = Direction.LEFT;
    }

    /**
     * Returns the X component of velocity
     * @return the X component of velocity
     */
    public double getX() {
        return xVelocity;
    }

    /**
     * Changes the value of X component of velocity
     * @param xVelocity the X component of velocity
     */
    public void setX(double xVelocity) {
        if (xVelocity > 0)
            this.direction = Direction.RIGHT;
        else if (xVelocity < 0)
            this.direction = Direction.LEFT;

        this.xVelocity = xVelocity;
    }

    /**
     * Returns the Y component of velocity
     * @return the Y component of velocity
     */
    public double getY() {
        return yVelocity;
    }

    /**
     * Changes the value of Y component of velocity
     * @param yVelocity the Y component of velocity
     */
    public void setY(double yVelocity) {
        if (yVelocity > 0)
            this.direction = Direction.DOWN;
        else if (yVelocity < 0)
            this.direction = Direction.UP;

        this.yVelocity = yVelocity;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
