/*
 *
 *
 */
package mastergardner.level;

/**
 *
 * @author Christian
 */
public class TileCoordinate {
    
    private int x, y;
    private final int TILE_SIZE;
    
    /**
     *
     * @param x
     * @param y
     */
    public TileCoordinate(int x, int y) {
        this.TILE_SIZE = 16;
        this.x = x * TILE_SIZE;
        this.y = y * TILE_SIZE;
    }
    
    /**
     *
     * @return
     */
    public int x() {
        return x;
    }
    
    /**
     *
     * @return
     */
    public int y() {
        return y;
    }
    
    /**
     *
     * @return
     */
    public int[] xy() {
        int[] r = new int[2];
        r[0] = x;
        r[1] = y;
        return r;
    }
    
    
    
}
