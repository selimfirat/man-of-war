package com.manofwar.logic.bullet;

import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.block.Block;
import com.manofwar.logic.bullet.Bullet;
import com.manofwar.logic.mob.Mob;

import java.awt.*;

public class BulletPhysicsComponent {

    private Bullet bullet;

    /**
     * Simply, constructor.
     * @param bullet Bullet to be composited with this component
     */
    public BulletPhysicsComponent(Bullet bullet) {
        this.bullet = bullet;
    }


    /**
     * The method that is executed each iteration of game loop.
     * Resolves collisions with other game objects. For example, restricts passing on blocks.
     * Also, responsible for moving object in each iteration
     * @param gameStateManager the GameStateManager instance that is in control of the game.
     */
    public void update(GameStateManager gameStateManager) {

        Rectangle bb = bullet.getBoundingBox();

        double dX = bullet.getVelocity().getX() * gameStateManager.getPassedSeconds();
        double dY = bullet.getVelocity().getY() * gameStateManager.getPassedSeconds();
        bullet.getBoundingBox().x += dX;
        bullet.getBoundingBox().y += dY;


        for (Mob mob : gameStateManager.getMobs()){

            if (mob.isVisible() && mob.getBoundingBox().intersects(bb)) {

                mob.takeDamage(bullet.getPower());
                bullet.setVisible(false);
                return;
            }
        }


        for (Block block : gameStateManager.getBlocks()){
            if (block.getBoundingBox().intersects(bb)){

                bullet.setVisible(false);
                return;
            }
        }


    }
}
