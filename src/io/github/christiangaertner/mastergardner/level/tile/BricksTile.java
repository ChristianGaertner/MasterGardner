package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class BricksTile extends Tile {

    /**
     *
     * @param sprite
     */
    public BricksTile(Sprite sprite) {
        super(sprite);
        this.color_code = 0xffa5a5a5;
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
