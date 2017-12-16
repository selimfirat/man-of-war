package com.manofwar.logic.item;

import com.manofwar.utilities.GraphicsManager;


/**
 * ItemGraphicsComponent is the responsible class for the graphics related business of character. In other words, draws the item in the required position.
 * Works in coherence with GraphicsManager.
 */
public class ItemGraphicsComponent {

    private Item item;

    /**
     * Simply, constructor
     * @param item Character to be composited with this component
     */
    public ItemGraphicsComponent(Item item) {
        this.item = item;
    }


    /**
     * The method that is executed each iteration of game loop.
     * Requests to draw item graphics.
     * @param graphicsManager The graphics manager that is in control of graphics of game
     */
    public void update(GraphicsManager graphicsManager) {

        if(item.isVisible())
            graphicsManager.draw(graphicsManager.getResource(item.getItemType().name().toLowerCase() + ".png"), item.getBoundingBox());
    }

}
