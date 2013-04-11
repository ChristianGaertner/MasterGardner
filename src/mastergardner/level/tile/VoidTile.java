/*
 * Void Tile
 * at margin of the map
 */
package mastergardner.level.tile;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class VoidTile extends Tile{
    
    /**
     * Just a empty tile
     * @param sprite
     */
    public VoidTile(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x, y, this);
    }
    
}
