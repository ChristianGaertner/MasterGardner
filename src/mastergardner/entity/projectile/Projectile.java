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
    
    protected final int xOrigin, yOrigin;
    protected double angle;
    Sprite sprite;
    protected double nx, ny;
    protected double speed, rateOfFire, range, damage;
    

    public Projectile(int x, int y, double dir) {
        xOrigin = x;
        yOrigin = y;
        angle = dir;
    }
}
