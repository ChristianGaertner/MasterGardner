package io.github.christiangaertner.mastergardner.entity.projectile;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.entity.projectile.basic.Bomb;
import io.github.christiangaertner.mastergardner.entity.projectile.basic.Bullet;
import io.github.christiangaertner.mastergardner.graphics.Sprite;
import java.util.Random;

/**
 *
 * @author Christian
 */
public abstract class Projectile extends Entity {

    public enum ProjectileType {
        BOMB, BULLET;

        public static Projectile getProjectile(ProjectileType type, int x, int y, double dir) {
            switch(type) {
                case BOMB:
                    return new Bomb(x, y, dir);
                default:
                /** Falls thru **/
                case BULLET:
                    return new Bullet(x, y, dir);
                
            }
        }

        public ProjectileType getNext() {
            return values()[(ordinal()+1) % values().length];
        }
    }
    
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
        if (level.tileCollision(x, y, nx, ny, 7)) {
            remove();
            onCollision();
        }

        this.x += nx;
        this.y += ny;
        if (distance() > range) {
            remove();
        }
    }
    
    @Override
    public void update() {
        move(nx, ny);
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
    
    /**
     *
     */
    @Override
    public void remove() {
        removed = true;
        onRemoving();
    }
    
    /**
     * @EVENTSYSTEM
     * Gets called on collision,
     * the entity has been removed.
     * (You can override this by doing this:)
     * this.removed = false;
     */
    protected void onCollision() {
    }
    
    /**
     * @EVENTSYSTEM
     * Gets called when the projectile gets removed
     * the entity has been removed.
     * (You can override this by doing this:)
     * this.removed = false;
     */
    protected void onRemoving() {
    }
}
