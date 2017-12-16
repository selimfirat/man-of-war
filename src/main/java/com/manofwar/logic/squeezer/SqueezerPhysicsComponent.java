package com.manofwar.logic.squeezer;

import com.manofwar.logic.Config;
import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;

import java.awt.*;

/**
 * The physics component of the squeezer.
 * Works in coherence with other game objects' physics components.
 */
public class SqueezerPhysicsComponent {

    private Squeezer squeezer;
    private double passedSeconds = 0;
    int mlt = 1; // to determine whether going back

    /**
     * Simply, constructor.
     * @param squeezer Squeezer to be composited with this component
     */
    public SqueezerPhysicsComponent(Squeezer squeezer) {
        this.squeezer = squeezer;
        passedSeconds = 0.0;
    }

    /**
     * The method that is executed each iteration of game loop.
     * Responsible for squeezing and hurts the character if colliding with it
     * @param gameStateManager the GameStateManager instance that is in control of the game.
     */
    public void update(GameStateManager gameStateManager) {
        Rectangle bb = squeezer.getBoundingBox();
        Rectangle obb = squeezer.getOriginalBoundingBox();
        Direction direction = squeezer.getDirection();

        if (passedSeconds == 0.0) {
            switch (direction) {
                case UP:
                    bb.y = obb.y + Config.TILE_HEIGHT;
                    break;
                case DOWN:
                    bb.y = obb.y - Config.TILE_HEIGHT;
                    break;
                case LEFT:
                    bb.x = obb.x + Config.TILE_WIDTH;
                    break;
                case RIGHT:
                    bb.x = obb.x - Config.TILE_WIDTH;
                    break;
            }
        } else if (passedSeconds >= 0.15){
            switch (direction) {
                case UP:
                    bb.y += -3 * mlt;
                    break;
                case DOWN:
                    bb.y += 3 * mlt;
                    break;
                case LEFT:
                    bb.x += -3 * mlt;
                    break;
                case RIGHT:
                    bb.x += 3 * mlt;
                    break;
            }
        }
        passedSeconds += gameStateManager.getPassedSeconds();


        if (passedSeconds >= 0.25)
            mlt = -1;

        if (passedSeconds >= 0.35) {
            passedSeconds = 0.0;
            mlt = 1;
        }


        Rectangle intersection = bb.intersection(gameStateManager.getCharacter().getBoundingBox());
        if (intersection.width > 0 && intersection.height > 0) {
            gameStateManager.getCharacter().setHealth(gameStateManager.getCharacter().getHealth() - 1);
        }
    }
}
