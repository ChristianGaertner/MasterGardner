/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.entity.projectile;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class KingProjectile extends Projectile {
    
    /**
     *
     * @param x
     * @param y
     * @param dir
     */
    public KingProjectile(int x, int y, double dir) {
        super(x, y, dir);
        range = 200;
        damage = 20;
        speed = 4;
        rateOfFire = 15;
        
        sprite = Sprite.projectiles_king_basic;
        
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }
    
    @Override
    public void update() {
        move();
    }

    /**
     *
     */
    @Override
    protected void move() {
        this.x += nx;
        this.y += ny;
    }
    
    /**
     *
     */
    @Override
    public void render(Screen screen) {
        screen.renderProjectile(x, y, this);
    }
}
