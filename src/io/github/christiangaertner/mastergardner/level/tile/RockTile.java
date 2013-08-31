package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class RockTile extends Tile{
    
    /**
     *
     * @param sprite
     */
    public RockTile(Sprite sprite) {
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Renderer screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    
    @Override
    public boolean solid() {
        return true;
    }
}
