/*
 * Grass Tile
 * 0,0 ; 16x16
 */
package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class GrassTile extends Tile{
    
    /**
     *
     * @param sprite
     */
    public GrassTile(Sprite sprite) {
        super(sprite);
        this.color_code = 0xff00ff00;
    }
    
    @Override
    public void render(int x, int y, Renderer screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    
}
