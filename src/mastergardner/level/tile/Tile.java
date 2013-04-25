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
     * Grass with flower - not solid - green (yellow) 16x16
     */
    public static Tile flower = new FlowerTile(Sprite.flower);
    
    /**
     * Grass with rock - solid - green (grey) 16x16
     */
    public static Tile rock = new RockTile(Sprite.rock);
    
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
