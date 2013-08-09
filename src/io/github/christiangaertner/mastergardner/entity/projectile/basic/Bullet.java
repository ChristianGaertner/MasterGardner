package io.github.christiangaertner.mastergardner.entity.projectile.basic;

import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class Bullet extends Projectile {

    /**
     *
     * @param x
     * @param y
     * @param dir
     */
    public Bullet(int x, int y, double dir) {
        super(x, y, dir);
        range = random.nextInt(100) + 150;
        damage = 2;
        speed = 10;
        rateOfFire = 5;

        sprite = Sprite.projectiles_basic_bullet;

        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }

    @Override
    public void update() {
        move(nx, ny);
    }

    /**
     *
     */
    @Override
    public void render(Screen screen) {
        screen.renderProjectile((int) x - 12, (int) y - 2, this);
    }
}
