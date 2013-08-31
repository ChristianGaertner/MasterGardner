package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

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
    public void render(int x, int y, Renderer screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
