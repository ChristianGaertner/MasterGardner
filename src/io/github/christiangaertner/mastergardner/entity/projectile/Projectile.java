package io.github.christiangaertner.mastergardner.entity.projectile;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.graphics.Sprite;
import java.util.Random;

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
        if (level.tileCollision(x, y, nx, ny, 7)) remove();

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
