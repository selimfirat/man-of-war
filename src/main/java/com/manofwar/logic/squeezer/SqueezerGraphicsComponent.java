package com.manofwar.logic.squeezer;

import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.utilities.GraphicsManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * SqueezerGraphicsComponent is the responsible class for the graphics related business of Squeezer. In other words, draws the character in the required position.
 * Works in coherence with GraphicsManager.
 */
public class SqueezerGraphicsComponent {

    private Squeezer squeezer;
    /**
     * Simply, constructor
     * @param squeezer Squeezer to be composited with this component
     */

    public SqueezerGraphicsComponent(Squeezer squeezer) {
        this.squeezer = squeezer;
    }

    /**
     * The method that is executed each iteration of game loop.
     * Requests to draw squeezer graphics.
     * @param graphicsManager The graphics manager that is in control of graphics of game
     */

    public void update(GraphicsManager graphicsManager) {
        Direction direction = squeezer.getDirection();

        BufferedImage fullImage = graphicsManager.getResource("squeezer_" + direction.name().toLowerCase() + ".png");
        Rectangle intersection = squeezer.getBoundingBox().intersection(squeezer.getOriginalBoundingBox());

        int wc = (direction == Direction.UP || direction == Direction.DOWN) ? intersection.height : intersection.width;

        int w = Math.max(Math.min(wc, 50), 1);

        int x = (direction == Direction.RIGHT) ? 50 - w : 0;
        int y = (direction == Direction.DOWN) ? 50 - w : 0;

        int width = (direction == Direction.RIGHT || direction == Direction.LEFT) ? w : 38;
        int height = (direction == Direction.UP || direction == Direction.DOWN) ? w : 38;

        BufferedImage img = fullImage.getSubimage(x, y, width, height);
        graphicsManager.draw(img, intersection);
    }

}