/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.level.tile.spawn_level;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;
import mastergardner.level.tile.Tile;

/**
 *
 * @author Christian
 */
public class SpawnGrassTile extends Tile{
    
    public SpawnGrassTile(Sprite sprite){
        super(sprite);
    }
    
    @Override
    public void render(int x, int y, Screen screen){
        screen.renderTile(x << 4, y << 4, this);
    }
}
