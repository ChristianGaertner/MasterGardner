/*
 * Abstract for entities
 * 
 */
package mastergardner.entity;

import java.util.Random;
import mastergardner.graphics.Screen;
import mastergardner.level.Level;

/**
 *
 * @author Christian
 */
public abstract class Entity {
    
    /**
     * Position of the Entity
     */
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random= new Random();
    
    
    public void update() {
    }
    
    public void render(Screen screen) {
    }
    
    public void remove(){
        throw new UnsupportedOperationException("Not supported yet.");
//        removed = true;
    }
    
    public boolean isRemoved(){
        return removed;
    }
}
