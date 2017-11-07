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
    }

    @Override
    public void update(GameStateManager gameStateManager) {
        if (!this.isVisible)
            return;

        graphicsComponent.update(gameStateManager.getGraphicsManager());
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
}
