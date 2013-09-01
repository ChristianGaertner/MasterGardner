package io.github.christiangaertner.mastergardner.entity.particle;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class Particle extends Entity {

    public int updates = 0;
    protected int lifetime;
    protected double x, y, xa, ya;

    public Particle(int x, int y, int lifetime) {
        this.x = x;
        this.y = y;
        
        this.lifetime = lifetime * 60;

        sprite = Sprite.particle_basic;

        this.xa = random.nextGaussian();
        this.ya = random.nextGaussian();
    }

    @Override
    public void update() {
        x += xa;
        y += ya;
        updates++;
        if (updates > lifetime) {
            remove();
        }
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderSprite((int) x, (int) y, sprite, false);
    }
    
    public int getLifeTime() {
        return lifetime;
    }
}
