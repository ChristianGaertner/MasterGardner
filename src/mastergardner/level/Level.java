/*
 * Level Generation
 * and Level Updating
 */
package mastergardner.level;

import mastergardner.graphics.Screen;

/**
 *
 * @author Christian
 */
public class Level {
    
    private int width, height;
    private int[] tiles;
    
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        // generateLevel();
    }

    
    private void generateLevel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void loadLevel(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void time() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void render(int xScroll, int yScroll, Screen screen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}