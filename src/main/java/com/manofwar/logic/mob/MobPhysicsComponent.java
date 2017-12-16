package com.manofwar.logic.mob;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.block.Block;

import java.awt.*;

public class MobPhysicsComponent {

    private Mob mob;

    public MobPhysicsComponent(Mob mob) {
        this.mob = mob;
    }


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
