/*
 *
 *
 */
package mastergardner.entity.projectile;

import mastergardner.entity.Entity;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public abstract class Projectile extends Entity {
    
    /**
     *
     */
    protected final int xOrigin,
    /**
     *
     */
    yOrigin;
    /**
     *
     */
    protected double angle;
    /**
     *
     */
    protected Sprite sprite;
    
    /**
     *
     */
    protected double nx,
    /**
     *
     */
    ny;
    /**
     *
     */
    protected double speed,
    /**
     *
     */
    rateOfFire,
    /**
     *
     */
    range,
    /**
     *
     */
    damage;
    

    /**
     *
     * @param x
     * @param y
     * @param dir
     */
    public Projectile(int x, int y, double dir) {
        xOrigin = x;
        yOrigin = y;
        angle = dir;
        this.x = x;
        this.y = y;
    }
    
    public Sprite getSprite() {
        return sprite;
    }
    
    public int getSpriteSize() {
        return sprite.SIZE;
    }
    
    protected void move() {
    }
}
