package com.manofwar.logic.bullet;

import com.manofwar.utilities.GraphicsManager;

/**
 * BulletGraphicsComponent is the responsible class for the graphics related business of Bullet. In other words, draws the Bullet in the required position.
 * Works in coherence with GraphicsManager.
 */
public class BulletGraphicsComponent {

    private Bullet bullet;

    /**
     * Simply, constructor
     * @param bullet Bullet to be composited with this component
     */
    public BulletGraphicsComponent(Bullet bullet) {
        this.bullet = bullet;
    }

    /**
     * The method that is executed each iteration of game loop.
     * Requests to draw Bullet graphics.
     * @param graphicsManager The graphics manager that is in control of graphics of game
     */
    public void update(GraphicsManager graphicsManager) {

        graphicsManager.draw(graphicsManager.getResource("bullet_" + (bullet.isMobFire() ? "mob" : "character") + ".png"), bullet.getBoundingBox());
    }
}
