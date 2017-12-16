package com.manofwar.logic.mob;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.*;

import java.awt.*;

/**
 * Mob class that represents various mobs in game
 */
public class Mob extends GameObject {

    private int power;
    private int health;
    private int maxHealth;

    private boolean isVisible;

    private Inventory itemsToDrop;
    private Velocity velocity;

    private MobType type;

    private MobGraphicsComponent graphicsComponent;
    private MobInputComponent inputComponent;
    private MobPhysicsComponent physicsComponent;


    /**
     * Simply, constructor
     * @param boundingBox Bounding box of the mob
     * @param type the type of the mob
     * @param power power of the mob
     * @param health health of the mob
     * @param maxHealth maximum (initial) health of the mob
     * @param itemsToDrop items to drop from the mob
     * @param velocity velocity of the mob
     */
    public Mob(Rectangle boundingBox, MobType type, int power, int health, int maxHealth, Inventory itemsToDrop, Velocity velocity) {
        super(boundingBox);
        this.type = type;
        this.power = power;
        this.health = health;
        this.maxHealth = maxHealth;
        this.itemsToDrop = itemsToDrop;
        this.velocity = velocity;
        this.isVisible = true;

        this.graphicsComponent = new MobGraphicsComponent(this);
        this.inputComponent = new MobInputComponent(this);
        this.physicsComponent = new MobPhysicsComponent(this);
    }

    /**
     * Game loop update method
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {
        if (!this.isVisible)
            return;

        graphicsComponent.update(gameStateManager.getGraphicsManager());
        inputComponent.update(gameStateManager);
        physicsComponent.update(gameStateManager);

    }

    /**
     * This method is used to give damage to the mob
     * @param amount The amount of the damage
     */
    public void takeDamage(int amount) {
        this.health -= amount;

        if (this.health <= 0)
            this.isVisible = false;
    }

    /**
     * Gives the visibility of the mob
     * @return the visibility of the mob
     */
    public boolean isVisible() {
        return isVisible;
    }


    /**
     * Returns the maximum (initial) health of the mob.
     * @return the maximum (initial) health of the mob.
     */
    public int getMaxHealth() {
        return maxHealth;
    }


    /**
     * Returns the current health of the mob.
     * @return the current health of the mob.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the type of the mob.
     * @return the type of the mob.
     */
    public MobType getType() {
        return type;
    }


    /**
     * Gives the velocity of the mob
     * @return the velocity of the mob
     */
    public Velocity getVelocity() {
        return velocity;
    }


    /**
     * Returns the power of the mob
     * @return the power of the mob
     */
    public int getPower() {
        return power;
    }
}
