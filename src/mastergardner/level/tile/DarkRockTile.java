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
public class DarkRockTile extends Tile{
    
    /**
     *
     * @param sprite
     */
    public DarkRockTile(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    
    @Override
    public boolean solid() {
        return true;
    }
}