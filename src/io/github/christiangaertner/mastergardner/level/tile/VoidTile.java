/*
 * Void Tile
 * at margin of the map
 */
package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

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
        screen.renderTile(x << 4, y << 4, this);
    }
    
}
