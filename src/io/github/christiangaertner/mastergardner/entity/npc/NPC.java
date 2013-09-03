/*
 * Mobs, Bots, Players, ...
 * 
 */
package io.github.christiangaertner.mastergardner.entity.npc;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.entity.projectile.Projectile.ProjectileType;

/**
 *
 * @author Christian
 */
public abstract class NPC extends Entity {

    /**
     * the direction (used for switching sprites
     */
    protected int dir = 2;
    /**
     * Whether the player is moving
     */
    protected boolean moving = false;
    /**
     * The running sped of the player
     */
    protected double running_speed;
    /**
     *
     */
    private long roftControll = System.currentTimeMillis();
    /**
     * 
     */
    private boolean roftIdle = true;
    private ProjectileType projectileType = ProjectileType.BOMB;
    
    protected int fired = 0;

    /**
     * Move the NPC
     *
     * @param xa
     * @param ya
     */
    public void move(int xa, int ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }

        //determine direction
        if (xa > 0) {
            dir = 1;
        } else if (xa < 0) {
            dir = 3;
        } else if (ya > 0) {
            dir = 2;
        } else if (ya < 0) {
            dir = 0;
        }


        if (!collision(xa, ya)) {
            x += xa;
            y += ya;
        }

    }

    /**
     *
     */
    @Override
    public void update() {
    }

    /**
     *
     * @param x
     * @param y
     * @param dir
     */
    protected void shoot(int x, int y, double dir) {
        
        long now = System.currentTimeMillis();
        
        Projectile p = ProjectileType.getProjectile(this.projectileType, x, y, dir);
        
        if (now - roftControll > p.ROFT) {
            level.add(p);
            roftControll = now;
        }
    }

    private boolean collision(int xa, int ya) {
        int xt;
        int yt;

        for (int c = 0; c < 4; c++) {
            xt = ((x + xa) + c % 2 * 12 - 7) >> 4;
            yt = ((y + ya) + c % 2 * 14 + 3) >> 4;
            if (level.getTile(xt, yt).solid()) {
                return true;
            }
        }
        //else
        return false;

    }
    
    public ProjectileType getProjectile() {
        return this.projectileType;
    }
    
    public void setProjectile(ProjectileType t) {
        this.projectileType = t;
    }
    
    public int getTimesFired() {
        return fired;
    }

    /**
     *
     */
    public void render() {
    }
}
