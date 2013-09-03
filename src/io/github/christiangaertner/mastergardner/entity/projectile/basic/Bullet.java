package io.github.christiangaertner.mastergardner.entity.projectile.basic;

import io.github.christiangaertner.mastergardner.entity.particle.ParticleEmitter;
import io.github.christiangaertner.mastergardner.entity.particle.ParticleEmitter.ParticleType;
import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.graphics.Renderer;
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
        range = RANDOM.nextInt(100) + 150;
        damage = 2;
        speed = 10;
        
        roft = 1000/30;
        
        sprite = Sprite.projectiles_basic_bullet;

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
        ParticleEmitter emitter = new ParticleEmitter(ParticleType.BASIC, (int) x, (int) y, 1, 25);
        level.add(emitter.getParticles());
    }
}
