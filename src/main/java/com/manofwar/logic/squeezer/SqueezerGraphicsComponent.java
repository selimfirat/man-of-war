package com.manofwar.logic.squeezer;

import com.manofwar.logic.Direction;
import com.manofwar.logic.GameStateManager;
import com.manofwar.utilities.GraphicsManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SqueezerGraphicsComponent {

    private Squeezer squeezer;

    public SqueezerGraphicsComponent(Squeezer squeezer) {
        this.squeezer = squeezer;
    }


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