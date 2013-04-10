/*
 * Random Gen for the level
 *
 */
package mastergardner.level;

import java.util.Random;

/**
 *
 * @author Christian
 */
public class RandomLevel extends Level{
    
    private final Random random;
    
    public RandomLevel(int width, int height) {
        super(width, height);
        this.random = new Random();
    }
    
    /**
     * This will generate thec random level, obviously
     */
    @Override
    protected void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = random.nextInt(4);
            }
        }
    }
}
