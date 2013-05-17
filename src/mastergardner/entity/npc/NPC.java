/*
 * Mobs, Bots, Players, ...
 * 
 */
package mastergardner.entity.npc;

import mastergardner.entity.Entity;
import mastergardner.entity.projectile.KingProjectile;
import mastergardner.entity.projectile.Projectile;
import mastergardner.graphics.Sprite;

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
     *
     */
    protected boolean moving = false;

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
    
    protected void shoot(int x, int y, double dir) {
        Projectile p = new KingProjectile(x, y, dir);
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
