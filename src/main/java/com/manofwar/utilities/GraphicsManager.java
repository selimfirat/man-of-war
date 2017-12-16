package com.manofwar.utilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * GraphicsManager class is responsible for drawing the game screen.
 */
public class GraphicsManager {

    private BufferedImage fullImage;
    private Graphics g2d;

    private FileManager fileManager;

    /**
     * Simply, constructor.
     * @param fileManager FileManager instance
     */
    public GraphicsManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    /**
     * Returns the full image to be drawn on GamePanel
     * @return the full image to be drawn on GamePanel.
     */
    public BufferedImage getFullImage() {
        return fullImage;
    }

    /**
     * Resets full image by creating
     */
    public void resetFullImage() {
        fullImage = new BufferedImage(800, 600,
                BufferedImage.TYPE_INT_RGB);

        g2d = fullImage.createGraphics();
    }

    public BufferedImage getResource(String name) {

        return fileManager.getImage(getClass().getClassLoader().getResource(   name));
    }

    public void draw(BufferedImage bufferedImage, Rectangle boundingBox) {

        g2d.drawImage(bufferedImage, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height, null);
    }

    public void setFullImage(BufferedImage fullImage) {
        this.fullImage = fullImage;
    }
}