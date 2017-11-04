package com.manofwar.logic.mob;

import com.manofwar.utilities.GraphicsManager;

public class MobGraphicsComponent {

    private Mob mob;

    public MobGraphicsComponent(Mob mob) {
        this.mob = mob;
    }

    public void update(GraphicsManager graphicsManager) {

        graphicsManager.draw(graphicsManager.getResource("mob.png"), mob.getBoundingBox());
    }
}
