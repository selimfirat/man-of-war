package com.manofwar.logic.mob;

import com.manofwar.logic.Config;
import com.manofwar.utilities.GraphicsManager;

import java.awt.*;

public class MobGraphicsComponent {

    private Mob mob;
    private int animationSequence = Config.ANIMATION_SPEED;

    public MobGraphicsComponent(Mob mob) {
        this.mob = mob;
    }

    public void update(GraphicsManager graphicsManager) {

        graphicsManager.draw(graphicsManager.getResource("mobs/" + mob.getType().name().toLowerCase() + "/" + mob.getVelocity().getDirection().name().toLowerCase() + "/" + (animationSequence/Config.ANIMATION_SPEED) + ".png"), mob.getBoundingBox());

        if (animationSequence == 15*Config.ANIMATION_SPEED)
            animationSequence = Config.ANIMATION_SPEED - 1;

        animationSequence++;

        Rectangle healthBB = (Rectangle) mob.getBoundingBox().clone();

        healthBB.height /= 15.0;
        healthBB.y -= healthBB.height*2;

        graphicsManager.draw(graphicsManager.getResource("bars/health0.png"), healthBB);

        double healthRatio = 1.0 * mob.getHealth() / mob.getMaxHealth();

        healthBB.width *= healthRatio;
        int healthColor;
        if (healthRatio > 0.66)
            healthColor = 1;
        else if (healthRatio > 0.33)
            healthColor = 3;
        else
            healthColor = 2;


        graphicsManager.draw(graphicsManager.getResource("bars/health" + healthColor + ".png"), healthBB);
    }
}
