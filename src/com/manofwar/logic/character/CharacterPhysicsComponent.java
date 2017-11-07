package com.manofwar.logic.character;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.block.Block;
import com.manofwar.logic.mob.Mob;

import java.awt.*;

/**
 * The physics component of the character.
 * Works in coherence with other game objects' physics components.
 */
public class CharacterPhysicsComponent {

    private Character character;

    /**
     * Simply, constructor.
     * @param character Character to be composited with this component
     */
    public CharacterPhysicsComponent(Character character) {
        this.character = character;
    }


    /**
     * The method that is executed each iteration of game loop.
     * Resolves collisions with other game objects. For example, restricts passing on blocks.
     * Also, responsible for moving object in each iteration
     * @param gameStateManager the GameStateManager instance that is in control of the game.
     */
    public void update(GameStateManager gameStateManager) {

        double dX = character.getVelocity().getX() * gameStateManager.getPassedSeconds();
        double dY = character.getVelocity().getY() * gameStateManager.getPassedSeconds();

        boolean isCollidingX = false;
        boolean isCollidingY = false;
        Rectangle tmpBBX = new Rectangle(character.getBoundingBox().x + (int) dX, character.getBoundingBox().y, character.getBoundingBox().width, character.getBoundingBox().height);
        Rectangle tmpBBY = new Rectangle(character.getBoundingBox().x, character.getBoundingBox().y + (int) dY, character.getBoundingBox().width, character.getBoundingBox().height);


        for (Mob mob : gameStateManager.getMobs()){
            if(!mob.isVisible())
                continue;

            if (mob.getBoundingBox().intersects(tmpBBX))
                isCollidingX = true;

            if (mob.getBoundingBox().intersects(tmpBBY))
                isCollidingY = true;
        }

        for (Block block : gameStateManager.getBlocks()){
            if (block.getBoundingBox().intersects(tmpBBX))
                isCollidingX = true;

            if (block.getBoundingBox().intersects(tmpBBY))
                isCollidingY = true;
        }

        if (!isCollidingX)
            character.getBoundingBox().x += dX;

        if (!isCollidingY)
            character.getBoundingBox().y += dY;

    }


}
