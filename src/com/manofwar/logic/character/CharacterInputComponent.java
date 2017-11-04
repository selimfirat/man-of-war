package com.manofwar.logic.character;

import com.manofwar.logic.Config;
import com.manofwar.utilities.InputManager;

import java.awt.event.KeyEvent;

/**
 * CharacterInputComponent is the responsible class for the input related business of character.
 * Works in coherence with InputManager.
 */
public class CharacterInputComponent {

    private Character character;

    /**
     * Simply, constructor
     * @param character Character to be composited with this component
     */
    public CharacterInputComponent(Character character) {
        this.character = character;
    }

    /**
     * The method that is executed each iteration of game loop.
     * Changes character's velocity according to the inputs.
     * @param inputManager The InputManager instance that tracks user inputs.
     */
    public void update(InputManager inputManager) {

        character.getVelocity().setX(0);
        character.getVelocity().setY(0);

        boolean isUP = inputManager.isPressed(KeyEvent.VK_UP);
        boolean isDOWN = inputManager.isPressed(KeyEvent.VK_DOWN);
        boolean isLEFT = inputManager.isPressed(KeyEvent.VK_LEFT);
        boolean isRIGHT = inputManager.isPressed(KeyEvent.VK_RIGHT);

        double mult = ((isUP || isDOWN) && (isLEFT || isRIGHT)) ? 1/Math.sqrt(2) : 1;

        if (isUP)
            character.getVelocity().setY(-Config.VELOCITY * mult);

        else if (isDOWN)
            character.getVelocity().setY(Config.VELOCITY * mult);

        if (isLEFT)
            character.getVelocity().setX(-Config.VELOCITY * mult);

        else if (isRIGHT)
            character.getVelocity().setX(Config.VELOCITY * mult);

    }

}
