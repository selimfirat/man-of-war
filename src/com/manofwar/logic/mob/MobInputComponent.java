package com.manofwar.logic.mob;

import com.manofwar.logic.Config;
import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.logic.bullet.Bullet;
import com.manofwar.logic.character.Character;

import java.awt.*;
import java.awt.event.KeyEvent;

// Simple AI Component
public class MobInputComponent {

    private Mob mob;

    public MobInputComponent(Mob mob) {
        this.mob = mob;


        mob.getVelocity().setX(Config.MOB_SPEED * (Math.random() > 0.5 ? -1 : 1));
    }

    private int bulletUpdateCounter = 0;

    public void update(GameStateManager gameStateManager) {

        Character character = gameStateManager.getCharacter();

        boolean isFIRE = false;

        // for readability
        if (Math.abs(mob.getBoundingBox().y - character.getBoundingBox().y) < character.getBoundingBox().height &&
                ((mob.getVelocity().getDirection() == Direction.LEFT && character.getBoundingBox().x < mob.getBoundingBox().x) ||
                (mob.getVelocity().getDirection() == Direction.RIGHT && character.getBoundingBox().x > mob.getBoundingBox().x)
        ))
                isFIRE = true;


        if (isFIRE && bulletUpdateCounter <= 0) {
            Rectangle bb = (Rectangle) mob.getBoundingBox().clone();
            bb.height *= 0.25;
            bb.width *= 0.25;
            bb.x += bb.width * 2;
            bb.y += bb.height * 2;

            Bullet bullet = new Bullet(bb, mob.getVelocity().getDirection(), mob.getPower(), true);
            gameStateManager.getBullets().add(bullet);
            bulletUpdateCounter = Config.MOB_BULLET_UPDATE_LIMIT;


            mob.getVelocity().setX(0);
        } else if (!isFIRE && mob.getVelocity().getX() == 0)
            mob.getVelocity().setX(Config.MOB_SPEED * (Math.random() > 0.5 ? -1 : 1));

        bulletUpdateCounter--;

    }

}
