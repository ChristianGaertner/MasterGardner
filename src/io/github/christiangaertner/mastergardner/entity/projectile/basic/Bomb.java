package io.github.christiangaertner.mastergardner.entity.projectile.basic;

import io.github.christiangaertner.mastergardner.entity.particle.Particle;
import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.graphics.Renderer;
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
        range = random.nextInt(50) + 50;
        damage = 20;
        speed = 1;
        rateOfFire = 50;

        sprite = Sprite.projectiles_basic_bomb;

        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }

    /**
     *
     */
    @Override
    public void render(Renderer screen) {
        screen.renderProjectile((int) x - 12, (int) y - 2, this);
    }

    @Override
    protected void onCollision() {
        Particle p = new Particle((int) x, (int) y, 2, 50);
        level.add(p);
    }
}
