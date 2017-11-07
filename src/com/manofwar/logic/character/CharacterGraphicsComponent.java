package com.manofwar.logic.character;

import com.manofwar.utilities.GraphicsManager;

/**
 * CharacterGraphicsComponent is the responsible class for the graphics related business of character. In other words, draws the character in the required position.
 * Works in coherence with GraphicsManager.
 */
public class CharacterGraphicsComponent {

    private Character character;

    /**
     * Simply, constructor
     * @param character Character to be composited with this component
     */
    public CharacterGraphicsComponent(Character character) {
        this.character = character;

    }

    /**
     * The method that is executed each iteration of game loop.
     * Requests to draw character graphics.
     * @param graphicsManager The graphics manager that is in control of graphics of game
     */
    public void update(GraphicsManager graphicsManager) {

        graphicsManager.draw(graphicsManager.getResource("character_" + character.getVelocity().getDirection().name().toLowerCase() + ".png"), character.getBoundingBox());
    }
}
