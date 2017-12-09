package com.manofwar.logic.item;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.character.Character;

/**
 * The physics component of the item.
 * Works in coherence with other game objects' physics components.
 */
public class ItemPhysicsComponent {

    private Item item;

    /**
     * Simply, constructor.
     * @param item Character to be composited with this component
     */
    public ItemPhysicsComponent(Item item) {
        this.item = item;
    }


    /**
     * The method that is executed each iteration of game loop.
     * Resolves collisions with character. If it happens, character picks the item and item removed from the game scene.
     * @param gameStateManager the GameStateManager instance that is in control of the game.
     */
    public void update(GameStateManager gameStateManager) {
        Character character = gameStateManager.getCharacter();
        if (item.isVisible() && character.getBoundingBox().intersects(item.getBoundingBox())) {
            character.setHealth(character.getHealth() + item.getBonusHealth());

            item.setVisible(false);
        }
    }
}
