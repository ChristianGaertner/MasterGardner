/*
 * Grass Tile
 * 0,0 ; 16x16
 */
package mastergardner.level.tile;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class DarkWaterTile extends Tile{
    
    /**
     *
     * @param sprite
     */
    public DarkWaterTile(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    
}