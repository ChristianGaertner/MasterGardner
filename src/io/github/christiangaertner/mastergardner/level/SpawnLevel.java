/*
 *
 *
 */
package io.github.christiangaertner.mastergardner.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Christian
 */
public class SpawnLevel extends Level {
    
    
    /**
     *
     * @param path
     */
    public SpawnLevel(String path) {
        super(path);
    }
    
    /**
     *
     * @param path
     */
    @Override
    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w * h];
            image.getRGB(0, 0, w, h, tiles, 0, w);
            
        } catch(IOException e) {
            System.out.println("Exception! Could not load level file!");
        }
    }
}
