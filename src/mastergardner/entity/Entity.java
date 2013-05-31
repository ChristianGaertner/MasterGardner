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
    /**
     *
     */
    protected Level level;
    /**
     *
     */
    protected static final Random random= new Random();
    
    
    /**
     *
     */
    public void update() {
    }
    
    /**
     *
     * @param screen
     */
    public void render(Screen screen) {
    }
    
    /**
     *
     */
    public void remove(){
        removed = true;
    }
    
    /**
     *
     * @return
     */
    public boolean isRemoved(){
        return removed;
    }
    
    /**
     *
     * @param level
     */
    public void init(Level level) {
        this.level = level;
    }
}
