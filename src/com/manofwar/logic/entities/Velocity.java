package com.manofwar.logic.entities;

/**
 * Velocity class contains x and y components of the velocity to be composited on a game object.
 */
public class Velocity {

    private double xVelocity;
    private double yVelocity;

    /**
     * Simply, constructor
     * @param xVelocity x component of velocity
     * @param yVelocity y component of velocity
     */
    public Velocity(double xVelocity, double yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }


    /**
     * A constructor that initiates x and y components of the velocity to 0.0
     */
    public Velocity() {
        this.xVelocity = 0.0;
        this.yVelocity = 0.0;
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
        this.yVelocity = yVelocity;
    }
}
