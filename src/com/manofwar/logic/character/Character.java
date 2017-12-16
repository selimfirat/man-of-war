package com.manofwar.logic.character;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.bullet.Bullet;
import com.manofwar.logic.entities.*;

import java.awt.*;

/**
 * Character is the game object that is to be controlled by the player.
 */
public class Character extends GameObject {


    private int power;
    private int health;
    private int maxHealth;

    private Inventory inventory;
    private Velocity velocity;

    private CharacterGraphicsComponent graphicsComponent;
    private CharacterInputComponent inputComponent;
    private CharacterPhysicsComponent physicsComponent;

    /**
     * Simply, constructor.
     * @param boundingBox Initial bounding box
     * @param power Initial  power
     * @param health Initial health
     * @param maxHealth Initial maxHealth
     * @param inventory Initial inventory containing items
     * @param velocity Initial velocity containing X and Y axises
     */
    public Character(Rectangle boundingBox, int power, int health, int maxHealth, Inventory inventory, Velocity velocity) {
        super(boundingBox);
        this.power = power;
        this.health = health;
        this.maxHealth = maxHealth;
        this.inventory = inventory;
        this.velocity = velocity;

        this.graphicsComponent = new CharacterGraphicsComponent(this);
        this.inputComponent = new CharacterInputComponent(this);
        this.physicsComponent = new CharacterPhysicsComponent(this);
    }

    /**
     * The method that is executed each iteration of game loop.
     * Executes its components' update methods.
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {

        graphicsComponent.update(gameStateManager.getGraphicsManager());
        inputComponent.update(gameStateManager);
        physicsComponent.update(gameStateManager);


        if (health <= 0)
            gameStateManager.restartLevel();
    }

    /**
     * Returns the power
     * @return the power of the character
     */
    public int getPower() {
        return power;
    }


    /**
     * Changes the blue power value
     * @param power power of the character
     */
    public void setPower(int power) {
        this.power = power;
    }


    /**
     * Returns the health value
     * @return the health of the character
     */
    public int getHealth() {
        return health;
    }

    /**
     * Changes the current health value
     * @param health Current health of the character
     */
    public void setHealth(int health) {
        this.health = health;
    }


    /**
     * Returns the max health value
     * @return the max health of the character
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Changes the max health value
     * @param maxHealth Max health of the character
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    /**
     * Returns the inventory of character
     * @return the inventory of character
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Returns the velocity of character
     * @return the velocity of character
     */
    public Velocity getVelocity() {
        return velocity;
    }

}

