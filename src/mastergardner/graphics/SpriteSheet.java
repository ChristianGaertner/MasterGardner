/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Christian
 */
public class SpriteSheet {
    
    private String path;
    public final int SIZE;
    public int[] pixels;
    
    /**
     *
     */
    public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
    
    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    
    
    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            
            int w;
            w = image.getWidth();
            int h;
            h = image.getHeight();
            
            image.getRGB(0, 0, w, h, pixels, 0, w);//translate image into pixels array
            
        } catch (IOException ex) {
            Logger.getLogger(SpriteSheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
