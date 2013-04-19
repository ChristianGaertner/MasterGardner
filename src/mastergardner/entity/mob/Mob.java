/*
 * Mobs, Bots, Players, ...
 * 
 */
package mastergardner.entity.mob;

import mastergardner.entity.Entity;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public abstract class Mob extends Entity {
    
    protected Sprite sprite;
    protected int dir = -1;
    protected boolean moving = false;
    
    
    /**
     * Move the Mob
     * @param xa
     * @param ya
     */
    public void move(int xa, int ya){
       
        //determine direction
        if (xa > 0) dir = 1;
        if (xa < 0) dir = 3;
        if (ya > 0) dir = 2;
        if (ya < 0) dir = 0;
        
        
        if (!collision()) {
           x += xa;
           y += ya;
       }
       
    }
    
    @Override
    public void update(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private boolean collision(){
        return false;
    }
    
    public void render() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
