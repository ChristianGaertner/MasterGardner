/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.level.tile;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class FlowerTile extends Tile {
    
    /**
     *
     * @param sprite
     */
    public FlowerTile(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
