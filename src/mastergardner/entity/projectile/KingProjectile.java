/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastergardner.entity.projectile;

/**
 *
 * @author Christian
 */
public class KingProjectile extends Projectile {
    
    public KingProjectile(int x, int y, double dir) {
        super(x, y, dir);
        range = 200;
        damage = 20;
        rateOfFire = 15;
        
        nx = speed * Math.cos(angle);
        ny = speed * Math.cos(angle);
    }
    
    @Override
    public void update() {
        move();
    }

    protected void move() {
        x += nx;
        y += ny;
    }
}
