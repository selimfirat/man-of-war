package com.manofwar.logic.mob;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.block.Block;

import java.awt.*;


/**
 * The physics component of the mob.
 * Works in coherence with other game objects' physics components. For example, checks collisins.
 */
public class MobPhysicsComponent {

    private Mob mob;


    /**
     * Simply, constructor.
     * @param mob Mob to be composited with this component
     */
    public MobPhysicsComponent(Mob mob) {
        this.mob = mob;
    }


    /**
     * The method that is executed each iteration of game loop.
     * Resolves collisions with character and blocks and decides whether to move or not. Includes a very bit of AI.
     * @param gameStateManager the GameStateManager instance that is in control of the game.
     */
    public void update(GameStateManager gameStateManager) {

        double dX = mob.getVelocity().getX() * gameStateManager.getPassedSeconds();

        boolean isCollidingX = false;

        Rectangle tmpBBX = new Rectangle(mob.getBoundingBox().x + (int) dX, mob.getBoundingBox().y, mob.getBoundingBox().width, mob.getBoundingBox().height);

        for (Mob mob : gameStateManager.getMobs()){
            if(!mob.isVisible() || mob == this.mob)
                continue;

            if (mob.getBoundingBox().intersects(tmpBBX))
                isCollidingX = true;

        }

        for (Block block : gameStateManager.getBlocks()){
            if (block.getBoundingBox().intersects(tmpBBX))
                isCollidingX = true;
        }

        if (!isCollidingX)
            mob.getBoundingBox().x += dX;
        else
            mob.getVelocity().setX(- mob.getVelocity().getX());


    }

}
