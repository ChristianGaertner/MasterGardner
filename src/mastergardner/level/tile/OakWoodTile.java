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
public class OakWoodTile extends Tile{
    
    /**
     *
     * @param sprite
     */
    public OakWoodTile(Sprite sprite) {
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
