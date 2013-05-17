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
class PlanksTile extends Tile {
    
    /**
     *
     * @param sprite
     */
    public PlanksTile(Sprite sprite) {
        super(sprite);
        this.color_code = 0xff956a02;
    }
    
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
