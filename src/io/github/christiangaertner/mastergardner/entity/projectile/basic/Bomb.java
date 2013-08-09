package io.github.christiangaertner.mastergardner.entity.projectile.basic;

import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class Bomb extends Projectile {

    /**
     *
     * @param x
     * @param y
     * @param dir
     */
    public Bomb(int x, int y, double dir) {
        super(x, y, dir);
        range = random.nextInt(100) + 150;
        damage = 20;
        speed = 8;
        rateOfFire = 7;

        sprite = Sprite.projectiles_basic_bomb;

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
