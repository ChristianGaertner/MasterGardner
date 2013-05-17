/*
 * Render
 *
 */
package mastergardner.graphics;

import java.util.Random;
import mastergardner.entity.npc.Player;
import mastergardner.level.tile.Tile;

/**
 *
 * @author Christian
 */
public class Screen {
    
    /**
     * Screen Height & Width
     */
    public int width, height;
    /**
     *
     */
    public int[] pixels;
    /**
     *
     */
    public final int MAP_SIZE = 64;
    /**
     *
     */
    public final int MAP_SIZE_MASK = MAP_SIZE -1;
    
    /**
     *
     */
    public int xOffset,
    /**
     *
     */
    yOffset;
    
    /**
     *
     */
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    
    private Random random;
    
    /**
     *
     * @param width
     * @param height
     */
    public Screen(int width, int height) {
        
        this.random = new Random();
        
        this.width = width;
        this.height = height;
        
        pixels = new int[width * height];
        
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
        }
        
    }
    
    /**
     *
     */
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
        
    /**
     *
     * @param xp
     * @param yp
     * @param tile
     */
    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xa = x + xp;
                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }
    
    /**
     * @param xp
     * @param yp
     * @param sprite
     * @param flip
     * FLIP DOC:
     * 0: nothing
     * 1: x
     * 2: y
     * 3: both
     */
    public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++) {
            
            int ya;
            ya = y + yp;
            
            //sprite flipping
            int ys;
            ys = y;
            if (flip == 2 || flip == 3) ys = (sprite.SIZE - 1) - y;
            
            for (int x = 0; x < sprite.SIZE; x++) {
                
                int xa;
                xa = x + xp;
                
                //sprite flipping
                int xs;
                xs = x;
                if (flip == 1 || flip == 3) xs = (sprite.SIZE - 1) - x;
                
                
                
                if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                int col = sprite.pixels[xs + ys * sprite.SIZE]; //get color of pixel
                if (col != 0xffFF00FF) pixels[xa + ya * width] = col; //if its pink (FF00FF) do not render ('cause this should be transparent)
            }
        }
    }
    
    /**
     *
     * @param xOffset
     * @param yOffset
     */
    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
