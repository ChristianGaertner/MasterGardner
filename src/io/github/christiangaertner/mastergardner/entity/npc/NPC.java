/*
 * Mobs, Bots, Players, ...
 * 
 */
package io.github.christiangaertner.mastergardner.entity.npc;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.entity.projectile.basic.Bomb;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public abstract class NPC extends Entity {

    /**
     * The assoc sprite for the npc
     */
    protected Sprite sprite;
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
    private int roftControll = 0;
    /**
     * 
     */
    private boolean roftIdle = true;

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
        if (!roftIdle) {
            roftControll++;
            Projectile p = new Bomb(0, 0, 0);
            if (roftControll % p.getRateOfFire() == 0) {
                roftIdle = true;
                roftControll = (int) p.getRateOfFire();
            }
        }
        
    }

    /**
     *
     * @param x
     * @param y
     * @param dir
     */
    protected void shoot(int x, int y, double dir) {
        roftIdle = false;
        Projectile p = new Bomb(x, y, dir);
        if (roftControll % p.getRateOfFire() == 0) {
            level.addProjectile(p);
        }
        if (roftControll > 6000) {
            roftControll = 0;
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

    /**
     *
     */
    public void render() {
    }
}
