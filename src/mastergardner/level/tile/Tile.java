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
    /**
     * The sprite to use for the tile, object declaration in the constructor
     */
    public Sprite sprite;
    
    //-------------------------TILES-----------------
    
    /**
     * Basic Grass - not solid - green 16x16
     */
    public static Tile grass = new GrassTile(Sprite.grass);
    
    /**
     * Void Tile - not solid - black 16x16
     */
    public static Tile voidTile = new VoidTile(Sprite.voidTile);
    //-------------------------TILES-----------------//END
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
