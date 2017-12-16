package com.manofwar.logic.mob;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.*;

import java.awt.*;

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

    @Override
    public void update(GameStateManager gameStateManager) {
        if (!this.isVisible)
            return;

        graphicsComponent.update(gameStateManager.getGraphicsManager());
        inputComponent.update(gameStateManager);
        physicsComponent.update(gameStateManager);

    }

    public void takeDamage(int amount) {
        this.health -= amount;

        if (this.health <= 0)
            this.isVisible = false;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public MobType getType() {
        return type;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public int getPower() {
        return power;
    }
}
