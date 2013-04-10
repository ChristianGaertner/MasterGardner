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
    
    protected int width, height;
    protected int[] tiles;
    
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        // generateLevel();
    }

    
    protected void generateLevel() {
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
    
    /**
     *
     * @param xScroll
     * @param yScroll
     * @param screen
     */
    public void render(int xScroll, int yScroll, Screen screen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
