/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.graphics;

/**
 *
 * @author Christian
 */
public class SpriteSheet {
    
    private String path;
    private final int SIZE;
    public int[] pixels;
    
    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE * SIZE];
    }
    
}
