/*
 *
 *
 */
package mastergardner.graphics;

import java.util.Random;

/**
 *
 * @author Christian
 */
public class Screen {
    
    private int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE -1;
    
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    
    private Random random;
    
    public Screen(int width, int height) {
        
        this.random = new Random();
        
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
        }
        
    }
    
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
    
    public void render(int xOffset,  int yOffset) {

        for (int y = 0; y < height; y++) {
            
            int yy;
            yy = y + yOffset;
            
            // if (yy >= height || yy >= height) break;
                                    
            for (int x = 0; x < width; x++) {
                
                int xx;
                xx = x + xOffset;
                
                // if (xx >= width || xx >= width) break;
                
                int tileIndex;
                tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                
                pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
            }
        }
    }
}
