package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class DarkRockTile extends Tile {

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
