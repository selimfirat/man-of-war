package com.manofwar.logic.character;

import com.manofwar.logic.Config;
import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.bullet.Bullet;
import com.manofwar.utilities.InputManager;
import com.manofwar.presentation.Settings;
import java.awt.*;
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


    private int bulletUpdateCounter = 0;

    /**
     * The method that is executed each iteration of game loop.
     * Changes character's velocity according to the inputs.
     * @param gameStateManager The Game State Manager instance that is in control.
     */
    public void update(GameStateManager gameStateManager) {

        InputManager inputManager = gameStateManager.getInputManager();

        character.getVelocity().setX(0);
        character.getVelocity().setY(0);


        boolean isLEFT = inputManager.isPressed(Settings.getInstance().getKeys().get(0));
        boolean isUP = inputManager.isPressed(Settings.getInstance().getKeys().get(1));
        boolean isRIGHT = inputManager.isPressed(Settings.getInstance().getKeys().get(2));
        boolean isDOWN = inputManager.isPressed(Settings.getInstance().getKeys().get(3));


        double mult = ((isUP || isDOWN) && (isLEFT || isRIGHT)) ? 1/Math.sqrt(2) : 1;

        if (isUP)
            character.getVelocity().setY(-Config.VELOCITY * mult);

        else if (isDOWN)
            character.getVelocity().setY(Config.VELOCITY * mult);

        else if (isLEFT)
            character.getVelocity().setX(-Config.VELOCITY * mult);

        else if (isRIGHT)
            character.getVelocity().setX(Config.VELOCITY * mult);


        boolean isFIRE = inputManager.isPressed(KeyEvent.VK_SPACE);

        if (isFIRE && bulletUpdateCounter <= 0) {
            Rectangle bb = (Rectangle) character.getBoundingBox().clone();
            bb.height *= 0.25;
            bb.width *= 0.25;
            bb.x += bb.width * 2;
            bb.y += bb.height * 2;

            Bullet bullet = new Bullet(bb, character.getVelocity().getDirection(), character.getPower(), false);
            gameStateManager.getBullets().add(bullet);
            bulletUpdateCounter = Config.BULLET_UPDATE_LIMIT;
        }

        bulletUpdateCounter--;
    }

}