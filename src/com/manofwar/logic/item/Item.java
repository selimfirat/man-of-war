package com.manofwar.logic.item;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.entities.GameObject;

import java.awt.*;

/**
 * Item class is to represent an item as a game object.
 */
public class Item extends GameObject {

    private ItemGraphicsComponent graphicsComponent;
    private ItemPhysicsComponent physicsComponent;

    private int bonusHealth;
    private int bonusBluePower;
    private int bonusRedPower;
    private ItemType itemType;
    private boolean isVisible;

    /**
     * Simply, constructor
     * @param boundingBox The bounding box of the item on the map if it's visible
     * @param isVisible whether the item is visible on the map
     * @param itemType type of the item
     * @param bonusHealth bonus health to be given when the item is picked.
     * @param bonusBluePower bonus blue power to be given when the item is picked.
     * @param bonusRedPower bonus red power to be given when the item is picked.
     */
    public Item(Rectangle boundingBox, boolean isVisible, ItemType itemType, int bonusHealth, int bonusBluePower, int bonusRedPower) {
        super(boundingBox);
        this.graphicsComponent = new ItemGraphicsComponent(this);
        this.physicsComponent = new ItemPhysicsComponent(this);

        this.isVisible = isVisible;
        this.itemType = itemType;
        this.bonusHealth = bonusHealth;
        this.bonusBluePower = bonusBluePower;
        this.bonusRedPower = bonusRedPower;
    }

    /**
     * Returns the bonus health to be given when the item is picked
     * @return bonus health to be given when the item is picked
     */
    public int getBonusHealth() {
        return bonusHealth;
    }

    /**
     * Returns the bonus blue powerto be given when the item is picked
     * @return bonus blue power to be given when the item is picked
     */
    public int getBonusBluePower() {
        return bonusBluePower;
    }

    /**
     * Returns the bonus red power to be given when the item is picked
     * @return bonus red power to be given when the item is picked
     */
    public int getBonusRedPower() {
        return bonusRedPower;
    }

    /**
     * The method that is executed each iteration of game loop.
     * @param gameStateManager GameStateManager object that is in control.
     */
    @Override
    public void update(GameStateManager gameStateManager) {
        physicsComponent.update(gameStateManager);
        graphicsComponent.update(gameStateManager.getGraphicsManager());
    }

    /**
     * Returns the type of the item
     * @return the type of the item
     */
    public ItemType getItemType() {
        return itemType;
    }

    /**
     * Returns whether the item is visible on the map
     * @return whether the item is visible on the map
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Changes visibility of the item
     * @param visible new visibility a
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
