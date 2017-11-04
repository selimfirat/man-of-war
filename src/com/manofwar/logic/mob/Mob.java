package com.manofwar.logic.mob;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.*;

import java.awt.*;

public class Mob extends GameObject {

    private int bluePower;
    private int redPower;
    private int health;
    private int maxHealth;

    private Inventory itemsToDrop;
    private Velocity velocity;

    private MobType type;

    private MobGraphicsComponent graphicsComponent;

    public Mob(Rectangle boundingBox, MobType type, int bluePower, int redPower, int health, int maxHealth, Inventory itemsToDrop, Velocity velocity) {
        super(boundingBox);
        this.type = type;
        this.bluePower = bluePower;
        this.redPower = redPower;
        this.health = health;
        this.maxHealth = maxHealth;
        this.itemsToDrop = itemsToDrop;
        this.velocity = velocity;

        this.graphicsComponent = new MobGraphicsComponent(this);
    }

    @Override
    public void update(GameStateManager gameStateManager) {
        graphicsComponent.update(gameStateManager.getGraphicsManager());
    }
}
