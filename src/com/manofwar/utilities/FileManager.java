package com.manofwar.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * FileManager instance is responsible for the handling persistent file system.
 */
public class FileManager {

    /**
     * Returns the requested image as BufferedImage
     * @param url the url as URL instance of the requested image
     * @return the requested image as BufferedImage
     */
    public BufferedImage getImage(URL url) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(url.toURI()));
        } catch (IOException | URISyntaxException e) {
            System.out.println("couldn't find the image file" + url + e);
        }
        return img;
    }

    /**
     * Returns the requested image as BufferedImage
     * @param urlString the url as URL instance of the requested image
     * @return the requested image as BufferedImage
     */
    public BufferedImage getImage(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return getImage(url);
    }

}
