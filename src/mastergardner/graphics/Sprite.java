/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.graphics;

/**
 *
 * @author Christian
 */
public class Sprite {
    
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;
    
    // Sprites
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    
    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }
    
    private void load() {
        for (int Ly = 0; Ly < SIZE; Ly++) {
            for (int Lx = 0; Lx < SIZE; Lx++) {
                pixels[Lx + Ly * SIZE] = sheet.pixels[( Lx + this.x) + (Ly + this.y) * sheet.SIZE];
            }
        }
    }
}
