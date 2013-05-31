/*
 *
 *
 */
package mastergardner.entity.projectile;

import java.util.Random;
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
    protected double x,
            /**
             *
             */
            y;
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
    
    
    protected static final Random random = new Random();

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

    /**
     *
     * @return
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     *
     * @return
     */
    public int getSpriteSize() {
        return sprite.SIZE;
    }

    /**
     *
     * @param nx
     * @param ny
     */
    protected void move(double nx, double ny) {
        this.x += nx;
        this.y += ny;
        if (distance() > range) {
            remove();
        }
    }

    protected double distance() {
        return Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
    }

    /**
     *
     * @return
     */
    public double getRateOfFire() {
        return rateOfFire;
    }
}
