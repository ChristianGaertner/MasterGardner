/*
 * Tile Class
 *
 */
package mastergardner.level.tile;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class Tile {
    
    public int x, y;
    public Sprite sprite;
    
    public static Tile grass = new GrassTile(Sprite.grass);
    /**
     *
     * @param sprite
     */
    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }
    
    /**
     *
     * @param x
     * @param y
     * @param screen
     */
    public void render(int x, int y, Screen screen) {
    }
    
    /**
     *
     * @return boolean
     */
    public boolean solid() {
        return false;
    }
}
